package project.cms.service;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import project.cms.dto.UsuarioRequest;
import project.cms.dto.UsuarioResponse;
import project.cms.entity.Atividade;
import project.cms.entity.Usuario;
import project.cms.exception.FavoritAlreadyExistException;
import project.cms.exception.UserRegistrationException;
import project.cms.repository.UsuarioRepository;

@Data
@Service
@AllArgsConstructor
public class UsuarioService {

  private UsuarioRepository usuarioRepository;

  public UsuarioResponse cadastraUsuario(UsuarioRequest usuarioRequest) {

    // se login nao existe, cadastra salvando o usuario.
    if (checaSeLoginJaExiste(usuarioRequest)) {
      Usuario usuario = dtoParaEntity(usuarioRequest);
      usuarioRepository.save(usuario);
      return montaUsuarioResponse(usuario);
    } else {
      throw new UserRegistrationException("O login já existe");
    }
  }

  public UsuarioResponse adicionaFavoritos(UsuarioRequest usuarioRequest){
    Usuario usuario = usuarioRepository.findUsuarioByLogin(usuarioRequest.getLogin()).orElseThrow(() -> new UserRegistrationException("Usuario não encontrado"));

    List<String> usuarioListaFavoritos =  usuario.getFavoritos() ;
    List<String> usuarioRequestListaFavoritos = usuarioRequest.getFavoritos();
    List<String> listaFinal = adicionaCasoNaoExista(usuarioListaFavoritos, usuarioRequestListaFavoritos);

    usuario.setFavoritos(listaFinal);
    usuarioRepository.save(usuario);
    return montaUsuarioResponse(usuario);
  }

  public Boolean checaSeLoginJaExiste(UsuarioRequest usuarioRequest) {
    // busca usuario no banco de dados.
    Optional<Usuario> usuario = usuarioRepository.findUsuarioByLogin(usuarioRequest.getLogin());
    // checa se login ja existe no banco de dados.
    return usuario.isEmpty();
  }

  public Usuario dtoParaEntity(UsuarioRequest usuarioRequest) {
    Usuario usuario = new Usuario();
    usuario.setLogin(usuarioRequest.getLogin());
    usuario.setEmail(usuarioRequest.getEmail());
    usuario.setNome(usuarioRequest.getNome());
    usuario.setAfiliacao(usuarioRequest.getAfiliacao());
    return usuario;
  }

  public UsuarioResponse montaUsuarioResponse(Usuario usuario) {
    return new UsuarioResponse(
            usuario.getLogin(),
            usuario.getEmail(),
            usuario.getNome(),
            usuario.getAfiliacao(),
            usuario.getFavoritos());
  }

  public List<String> adicionaCasoNaoExista(List<String> usuarioLista, List<String> usuarioRequestList){
    for (String atividade : usuarioRequestList) {
      String nome = atividade;
      boolean existe = false;

      for (String atividadeExistente : usuarioLista) {
        if (atividadeExistente.equals(nome)) {
          existe = true;
          //break;
          throw  new FavoritAlreadyExistException("Essa atividade já foi favoritada.");
        }
      }
      if (!existe) {
        usuarioLista.add(atividade);
      }
    }
    return usuarioLista;
  }
}
