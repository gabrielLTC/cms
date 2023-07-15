package project.cms.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
@AllArgsConstructor
public class EventoResponse {

  String nomeEvento;
  String siglaEvento;
  String descricaoEvento;

  Integer numeroEdicao;
  Integer anoEdicao;
  LocalDate dataInicialEdicao;
  LocalDate dataFinalEdicao;
  String cidadeEdicao;
}
