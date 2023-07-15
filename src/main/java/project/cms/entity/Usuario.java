package project.cms.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.cms.enums.TipoDeUsuario;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String login;
  String senha;
  String email;
  String nome;
  String afiliacao;

  @Enumerated(EnumType.ORDINAL)
  TipoDeUsuario tipo;

  @OneToOne(cascade = CascadeType.PERSIST)
  Edicao edicao;

  @OneToMany
  @JoinColumn(name = "usuario_id")
  List<Atividade> favoritos;
}
