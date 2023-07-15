package project.cms.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String nome;
  String sigla;
  String descricao;

  @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
  List<Edicao> edicao;
}
