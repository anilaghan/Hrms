package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Resume,Long> {
}
