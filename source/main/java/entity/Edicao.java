package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
