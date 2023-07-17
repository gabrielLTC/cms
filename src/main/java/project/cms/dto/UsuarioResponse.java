package project.cms.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {
  String usuarioLogin;
  String usuarioEmail;
  String ususarioNome;
  String ususarioAfiliacao;
  List<String> favoritos;
}
