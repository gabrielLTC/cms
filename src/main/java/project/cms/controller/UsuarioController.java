package project.cms.controller;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.cms.dto.UsuarioRequest;
import project.cms.entity.Usuario;
import project.cms.service.UsuarioService;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
    @NonNull UsuarioService usuarioService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> postNewCustomer(
            @RequestBody UsuarioRequest usuarioRequest) {

        usuarioService.checaSeLoginJaExiste(usuarioRequest);

        Usuario usuario = new Usuario();
        usuario.setLogin(usuarioRequest.getLogin());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setNome(usuarioRequest.getNome());
        usuario.setAfiliacao(usuarioRequest.getAfiliacao());



        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
