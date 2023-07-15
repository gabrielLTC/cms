package project.cms.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import project.cms.dto.EventoResponse;
import project.cms.entity.Edicao;
import project.cms.entity.Evento;
import project.cms.exception.EditionNotFoundException;
import project.cms.exception.EventNotFoundException;
import project.cms.repository.EventoRepository;

@Data
@Service
@AllArgsConstructor
public class EventoService {

  private EventoRepository eventoRepository;

  // Busca Evento e edição.
  public EventoResponse montaResponseEventoEdicao(String eventoNome, String edicaoAno) {
    Evento evento = buscaEvento(eventoNome, edicaoAno);
    return new EventoResponse(
        evento.getNome(),
        evento.getSigla(),
        evento.getDescricao(),
        evento.getEdicao().get(0).getNumero(),
        evento.getEdicao().get(0).getAno(),
        evento.getEdicao().get(0).getDataInicial(),
        evento.getEdicao().get(0).getDataFinal(),
        evento.getEdicao().get(0).getCidade());
  }

  // Busca Evento no banco de dados e devolve o evento setado apenas com a edicao solicitada.
  public Evento buscaEvento(String eventoNome, String edicaoAno) {
    Evento evento =
        eventoRepository
            .findEventoByNome(eventoNome)
            .orElseThrow(() -> new EventNotFoundException("Evento não encotrado."));
    List<Edicao> edicaoList = evento.getEdicao();
    for (Edicao edicao : edicaoList) {
      if (edicao.getAno().equals(Integer.parseInt(edicaoAno))) {
        edicaoList = new ArrayList<>();
        edicaoList.add(edicao);
        evento.setEdicao(edicaoList);
        return evento;
      }
    }
    throw new EditionNotFoundException("Edição não encontrada.");
  }
}
