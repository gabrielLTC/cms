package project.cms.entity;

import project.cms.enums.TipoAtividade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    TipoAtividade tipo;
    String descricao;
    LocalDate data;
    LocalDateTime horarioInicial;
    LocalDateTime horarioFinal;

    @ManyToOne
    Edicao edicao;
}
