package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Knowledge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeRepository extends JpaRepository<Knowledge,Long> {
}
