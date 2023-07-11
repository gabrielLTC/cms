package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    Long id;
    String nome;
    String sigla;
    String descricao;
    Edicao edicao;
}
