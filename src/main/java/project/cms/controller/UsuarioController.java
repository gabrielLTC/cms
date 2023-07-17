package project.cms.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.cms.dto.UsuarioRequest;
import project.cms.dto.UsuarioResponse;
import project.cms.entity.Usuario;
import project.cms.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
  @Autowired @NonNull UsuarioService usuarioService;

  // Se cadastrar no sistema
  @PostMapping(
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UsuarioResponse> cadastrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {
    UsuarioResponse usuarioResponse = usuarioService.cadastraUsuario(usuarioRequest);
    return new ResponseEntity<>(usuarioResponse, HttpStatus.CREATED);
  }

  @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<UsuarioResponse> favoritaAtividade(@RequestBody UsuarioRequest usuarioRequest){
    UsuarioResponse usuarioResponse = usuarioService.adicionaFavoritos(usuarioRequest);
    return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
  }
}
