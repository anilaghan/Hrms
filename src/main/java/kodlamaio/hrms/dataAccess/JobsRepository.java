package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Jobs,Integer> {
}
