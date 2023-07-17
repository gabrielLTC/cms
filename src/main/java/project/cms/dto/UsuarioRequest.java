package project.cms.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {
  String login;
  String email;
  String nome;
  String afiliacao;
  List<String> favoritos;
}
