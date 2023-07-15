package project.cms.service;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import project.cms.dto.EventoResponse;
import project.cms.entity.Edicao;
import project.cms.entity.Evento;
import project.cms.exception.EditionNotFoundException;
import project.cms.exception.EventNotFoundException;
import project.cms.repository.EdicaoRepository;
import project.cms.repository.EventoRepository;

@Data
@Service
@AllArgsConstructor
public class EventoService {

  private EventoRepository eventoRepository;
  private EdicaoRepository edicaoRepository;

  //    public Boolean checaSeEventoExiste(String eventoNome){
  //        Optional<Evento> evento =
  // eventoRepository.findEventoByNome(eventoNome).orElseThrow(EventNotFoundException::new);
  //        return evento.isEmpty();
  //    }

  public EventoResponse buscaEventoEdicao(String eventoNome, String edicaoAno) {
    Evento evento =
        eventoRepository
            .findEventoByNome(eventoNome)
            .orElseThrow(() -> new EventNotFoundException("Evento não encotrado."));

    EventoResponse eventoResponse = null;
    List<Edicao> edicaoList = evento.getEdicao();
    for (Edicao edicao : edicaoList) {
      if (edicao.getAno().equals(Integer.parseInt(edicaoAno))) {
        eventoResponse =
            new EventoResponse(
                evento.getNome(),
                evento.getSigla(),
                evento.getDescricao(),
                edicao.getNumero(),
                edicao.getAno(),
                edicao.getDataInicial(),
                edicao.getDataFinal(),
                edicao.getCidade());
      } else {
        throw new EditionNotFoundException("Edição não encontrada.");
      }
    }
    return eventoResponse;
  }
}
