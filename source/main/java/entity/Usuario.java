package entity;

import enums.TipoDeUsuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String email;
    String nome;
    String afiliacao;
    TipoDeUsuario tipo;

    @OneToOne
    Edicao edicao;

    @ManyToMany
    List<Atividade> favoritos;
}
