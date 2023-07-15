package project.cms.entity;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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

  @ElementCollection
  List<String> recursos;

  @OneToOne(cascade = CascadeType.PERSIST) Atividade atividade;
}
