package project.cms.entity;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Espaco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String nome;
  String localizacao;
  Integer capacidade;

  @ElementCollection List<String> recursos;

  @OneToOne Atividade atividade;
}
