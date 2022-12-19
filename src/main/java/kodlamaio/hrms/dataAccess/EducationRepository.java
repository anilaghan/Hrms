package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education,Long> {
}
