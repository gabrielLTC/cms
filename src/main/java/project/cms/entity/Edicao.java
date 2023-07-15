package project.cms.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Edicao {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  Integer numero;
  Integer ano;
  LocalDate dataInicial;
  LocalDate dataFinal;
  String cidade;

  @ManyToOne
  @JoinColumn(name = "evento_id")
  Evento evento;

  @OneToOne
  Usuario usuario;

  @OneToMany(mappedBy = "edicao", cascade = CascadeType.PERSIST)
  List<Atividade> atividades;
}
