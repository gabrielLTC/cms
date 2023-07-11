package entity;

import enums.TipoAtividade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
