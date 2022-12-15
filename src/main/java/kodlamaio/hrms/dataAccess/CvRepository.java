package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Cv;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvRepository extends JpaRepository<Cv,Long> {
}
