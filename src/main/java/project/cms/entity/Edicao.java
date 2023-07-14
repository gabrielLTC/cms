package project.cms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Data
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

    @OneToOne
    Evento evento;

    @OneToOne
    Usuario usuario;

    @OneToMany(mappedBy = "edicao", cascade = CascadeType.PERSIST)
    List<Atividade> atividades;

}
