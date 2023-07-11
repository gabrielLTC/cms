package entity;

import enums.TipoDeUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    Long id;
    String login;
    String email;
    String nome;
    String afiliacao;
    TipoDeUsuario tipo;
    Edicao edicao;
    List<Atividade> favoritos;
}
