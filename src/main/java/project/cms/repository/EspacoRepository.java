package project.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.cms.entity.Espaco;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {}
