package project.cms.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import project.cms.dto.UsuarioRequest;
import project.cms.entity.Usuario;
import project.cms.exception.UserRegistrationException;
import project.cms.repository.UsuarioRepository;

import java.util.Optional;

@Data
@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(UsuarioRequest usuarioRequest){
        //se login nao existe, cadastra salvando o usuario.
        if(checaSeLoginJaExiste(usuarioRequest)){
            Usuario usuario = dtoParaEntity(usuarioRequest);
            usuarioRepository.save(usuario);
            return usuario;
        } else{
            throw new UserRegistrationException("O login já existe");
        }
    }

    public Boolean checaSeLoginJaExiste(UsuarioRequest usuarioRequest){
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByLogin(usuarioRequest.getLogin());
        //checa se login ja existe no banco de dados.
        return usuario.isEmpty();
    }

    public Usuario dtoParaEntity(UsuarioRequest usuarioRequest){
        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioRequest.getLogin());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setAfiliacao(usuarioRequest.getAfiliacao());
        return usuario;
    }
}
