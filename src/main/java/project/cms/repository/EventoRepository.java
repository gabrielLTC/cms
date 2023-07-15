package project.cms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cms.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

  Optional<Evento> findEventoByNome(String eventoNome);
}
