package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Edicao {
    Long id;
    Integer numero;
    Integer ano;
    LocalDate dataInicial;
    LocalDate dataFinal;
    String cidade;
    Evento evento;
    Usuario usuario;
    List<Atividade> atividades;

}
