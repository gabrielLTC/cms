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
import project.cms.dto.AtividadeResponse;
import project.cms.entity.Evento;
import project.cms.service.AtividadeService;
import project.cms.service.EventoService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

  @Autowired @NonNull EventoService eventoService;
  @Autowired @NonNull AtividadeService atividadeService;

  // Visualizar atividade de um evento
  @GetMapping(
      value = "/{eventoNome}/{edicaoAno}/{atividadeNome}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AtividadeResponse> eventoInfo(
      @PathVariable String eventoNome,
      @PathVariable String edicaoAno,
      @PathVariable String atividadeNome) {
    Evento evento = eventoService.buscaEvento(eventoNome, edicaoAno);
    AtividadeResponse atividadeResponse =
        atividadeService.montaAtividadeResponse(evento, atividadeNome);

    return new ResponseEntity<>(atividadeResponse, HttpStatus.OK);
  }
}
