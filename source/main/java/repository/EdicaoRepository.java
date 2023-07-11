package repository;

import entity.Edicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
}
