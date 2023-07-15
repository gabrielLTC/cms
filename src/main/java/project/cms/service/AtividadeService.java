package project.cms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import project.cms.dto.AtividadeResponse;
import project.cms.dto.EspacoResponse;
import project.cms.entity.Atividade;
import project.cms.entity.Evento;
import project.cms.exception.ActivityNotFoundException;

@Service
public class AtividadeService {

  public AtividadeResponse montaAtividadeResponse(Evento evento, String atividadeNome) {
    Atividade atividade = buscaAtividadeNaEdicaoDoEvento(evento, atividadeNome);
    return new AtividadeResponse(
        evento.getNome(),
        evento.getEdicao().get(0).getAno(),
        atividade.getNome(),
        atividade.getTipo(),
        atividade.getDescricao(),
        atividade.getData(),
        atividade.getHorarioInicial(),
        atividade.getHorarioFinal(),
        new EspacoResponse(
            atividade.getEspaco().getNome(),
            atividade.getEspaco().getLocalizacao(),
            atividade.getEspaco().getCapacidade()));
  }

  public Atividade buscaAtividadeNaEdicaoDoEvento(Evento evento, String atividadeNome) {
    List<Atividade> atividadesList = evento.getEdicao().get(0).getAtividades();
    for (Atividade atividade : atividadesList) {
      if (atividade.getNome().equals(atividadeNome)) {
        return atividade;
      }
    }
    throw new ActivityNotFoundException("Atividade não encontrada na edição do evento.");
  }
}
