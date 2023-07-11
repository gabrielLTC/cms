package entity;

import enums.TipoAtividade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atividade {
    Long id;
    String nome;
    TipoAtividade tipo;
    String descricao;
    LocalDate data;
    LocalDateTime horarioInicial;
    LocalDateTime horarioFinal;
    Edicao edicao;
}
