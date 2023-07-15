package project.cms.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.cms.entity.Atividade;
import project.cms.entity.Edicao;
import project.cms.entity.Espaco;
import project.cms.entity.Evento;
import project.cms.entity.Usuario;
import project.cms.enums.TipoAtividade;
import project.cms.enums.TipoDeUsuario;
import project.cms.repository.AtividadeRepository;
import project.cms.repository.EventoRepository;
import project.cms.repository.UsuarioRepository;

@Component
public class InitializeData {
  @Autowired UsuarioRepository usuarioRepository;

  @Autowired EventoRepository eventoRepository;

  @Autowired AtividadeRepository atividadeRepository;

  @PostConstruct
  public void initializeData() {
    // insere os usuarios no banco de dados
    Usuario usuario1 = new Usuario();
    usuario1.setLogin("pedro022");
    usuario1.setSenha("1111");
    usuario1.setEmail("pedro@gmail.com");
    usuario1.setNome("Pedro Carvalho");
    usuario1.setAfiliacao("Afiliação 1");
    usuario1.setTipo(TipoDeUsuario.ORGANIZADOR);
    usuarioRepository.save(usuario1);

    Usuario usuario2 = new Usuario();
    usuario2.setLogin("gabriel022");
    usuario2.setSenha("2222");
    usuario2.setEmail("gabriel022@gmail.com");
    usuario2.setNome("Gabriel Lannes");
    usuario2.setAfiliacao("Afiliação 2");
    usuario2.setTipo(TipoDeUsuario.ORGANIZADOR);
    usuarioRepository.save(usuario2);

    Usuario usuario3 = new Usuario();
    usuario3.setLogin("joao044");
    usuario3.setSenha("3333");
    usuario3.setEmail("joao.boladao@gmail.com");
    usuario3.setNome("João Francisco");
    usuario3.setAfiliacao("Afiliação 3");
    usuario3.setTipo(TipoDeUsuario.USUARIO_SIMPLES);
    usuarioRepository.save(usuario3);

    Usuario usuario4 = new Usuario();
    usuario4.setLogin("ronaldo69");
    usuario4.setSenha("4444");
    usuario4.setEmail("ronaldo69@gmail.com");
    usuario4.setNome("Ronaldo Xavier");
    usuario4.setAfiliacao("Afiliação 4");
    usuario4.setTipo(TipoDeUsuario.USUARIO_SIMPLES);
    usuarioRepository.save(usuario4);

    // insere evento, com edição passada e edição atual
    List<Edicao> edicaoList = new ArrayList<>();
    Evento evento = new Evento();
    evento.setNome("bianaldolivro");
    evento.setSigla("BL");
    evento.setDescricao(
        "Maior evento da Ameríca Latina para todos aqueles que são fãs da leitura, que acontece a cada 2 anos.");
    evento.setEdicao(edicaoList);

    Edicao edicaoPassada = new Edicao();
    edicaoPassada.setNumero(1);
    edicaoPassada.setAno(2021);
    edicaoPassada.setDataInicial(LocalDate.of(2022, 9, 14));
    edicaoPassada.setDataFinal(LocalDate.of(2022, 9, 21));
    edicaoPassada.setCidade("Rio de Janeiro");

    Edicao edicaoAtual = new Edicao();
    edicaoAtual.setNumero(2);
    edicaoAtual.setAno(2023);
    edicaoAtual.setDataInicial(LocalDate.of(2023, 11, 14));
    edicaoAtual.setDataFinal(LocalDate.of(2023, 11, 21));
    edicaoAtual.setCidade("Rio de Janeiro");

    // salvo os eventos com as edições
    evento.getEdicao().add(edicaoPassada);
    evento.getEdicao().add(edicaoAtual);
    eventoRepository.save(evento);
    edicaoPassada.setUsuario(usuario1);
    edicaoAtual.setUsuario(usuario2);
    edicaoPassada.setEvento(evento);
    edicaoAtual.setEvento(evento);
    eventoRepository.save(evento);

    // criadas 2 atividades com seus respectivos espaços
    Atividade atividade1 = new Atividade();
    atividade1.setNome("documentariobianaldolivro");
    atividade1.setTipo(TipoAtividade.PAINEL);
    atividade1.setDescricao("Exibição do documentário sobre a Bianal do Livro");
    atividade1.setData(LocalDate.of(2023, 11, 16));
    atividade1.setHorarioInicial(LocalDateTime.of(2023, 11, 16, 14, 0));
    atividade1.setHorarioFinal(LocalDateTime.of(2023, 11, 16, 15, 30));

    List<String> recursosList1 = new ArrayList<>();
    recursosList1.add("Retroprojetor");
    recursosList1.add("300 cadeiras");
    recursosList1.add("10 Caixas de som tamanho 3");
    Espaco espaco1 = new Espaco();
    espaco1.setNome("Stand de Exibição Cinematográfica");
    espaco1.setLocalizacao("Bloco Azul");
    espaco1.setCapacidade(300);
    espaco1.setRecursos(recursosList1);
    atividade1.setEspaco(espaco1);

    // fim primeira atividade

    // inicio segunda atividade
    Atividade atividade2 = new Atividade();
    atividade2.setNome("palestrapaulocoelho");
    atividade2.setTipo(TipoAtividade.PALESTRA);
    atividade2.setDescricao("Palestra com Paulo Coelho falando sobre sua profissão de escritor");
    atividade2.setData(LocalDate.of(2023, 11, 17));
    atividade2.setHorarioInicial(LocalDateTime.of(2023, 11, 17, 17, 0));
    atividade2.setHorarioFinal(LocalDateTime.of(2023, 11, 17, 18, 30));

    List<String> recursosList2 = new ArrayList<>();
    recursosList2.add("Microfone");
    recursosList2.add("Palco");
    recursosList2.add("água");
    Espaco espaco2 = new Espaco();
    espaco2.setNome("Stand de Palestras");
    espaco2.setLocalizacao("Bloco Vermelho");
    espaco2.setCapacidade(200);
    espaco2.setRecursos(recursosList2);
    atividade2.setEspaco(espaco2);

    // salva as atividades
    atividadeRepository.save(atividade1);
    atividadeRepository.save(atividade2);

    atividade1.setEdicao(edicaoAtual);
    atividade2.setEdicao(edicaoAtual);
    atividadeRepository.save(atividade1);
    atividadeRepository.save(atividade2);
  }
}
