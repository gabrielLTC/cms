package project.cms.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.cms.dto.EventoResponse;
import project.cms.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {

  @Autowired @NonNull EventoService eventoService;

  @GetMapping(value = "/{eventoNome}/eventoEdicao", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EventoResponse> eventoInfo(
      @PathVariable String eventoNome, @PathVariable String edicaoNome) {
    EventoResponse eventoResponse = eventoService.buscaEventoEdicao(eventoNome, edicaoNome);
    return new ResponseEntity<>(eventoResponse, HttpStatus.OK);
  }
}
