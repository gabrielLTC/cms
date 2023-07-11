package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Espaco {
    Long id;
    String nome;
    String localizacao;
    Integer capacidade;
    String recursos;
}
