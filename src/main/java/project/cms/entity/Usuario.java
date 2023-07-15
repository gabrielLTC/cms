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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.cms.enums.TipoDeUsuario;

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
  @Enumerated(EnumType.ORDINAL)
  TipoDeUsuario tipo;

  @OneToOne(cascade = CascadeType.PERSIST) Edicao edicao;

  @OneToMany
  @JoinColumn(name = "usuario_id")
  List<Atividade> favoritos;
}
