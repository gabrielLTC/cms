package project.cms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
@AllArgsConstructor
public class EspacoResponse {
  String nomeDoEspaco;
  String localizacaoDoEspaco;
  Integer capacidadeDoEspaco;
}
