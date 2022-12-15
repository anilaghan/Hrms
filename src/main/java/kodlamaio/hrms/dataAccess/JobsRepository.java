package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsRepository extends JpaRepository<Job,Long> {
}
