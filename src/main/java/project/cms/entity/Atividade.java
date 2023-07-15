package project.cms.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.cms.enums.TipoAtividade;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atividade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  String nome;

  @Enumerated(EnumType.ORDINAL)
  TipoAtividade tipo;

  String descricao;
  LocalDate data;
  LocalDateTime horarioInicial;
  LocalDateTime horarioFinal;

  @ManyToOne(cascade = CascadeType.PERSIST)
  Edicao edicao;

  @OneToOne(cascade = CascadeType.PERSIST)
  Espaco espaco;
}
