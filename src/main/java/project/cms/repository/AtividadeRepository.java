package project.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cms.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {}
