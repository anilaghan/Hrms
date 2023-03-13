package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeRepository extends JpaRepository<Skills,Long> {
}
