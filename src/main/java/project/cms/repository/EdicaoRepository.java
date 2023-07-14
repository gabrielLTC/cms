package project.cms.repository;

import project.cms.entity.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
}
