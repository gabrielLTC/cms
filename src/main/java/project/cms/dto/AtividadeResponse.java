package project.cms.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import project.cms.enums.TipoAtividade;

@Data
@NonNull
@AllArgsConstructor
public class AtividadeResponse {
  String nomeDoEvento;
  Integer anoDaEdicao;

  String nomeDaAtividade;
  TipoAtividade tipoDaAtividade;
  String descricaoDaAtividade;
  LocalDate dataDaAtividade;
  LocalDateTime horarioInicialDaAtividade;
  LocalDateTime horarioFinalDaAtividade;
  EspacoResponse espaco;
}
