package project.cms.entity;

import project.cms.enums.TipoDeUsuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
