package project.cms.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cms.entity.Edicao;
import project.cms.entity.Evento;

@Repository
public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
  Optional<Edicao> findEdicaoByEvento(Evento evento);
}
