package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesRepository extends JpaRepository<Candidate,Integer> {
}
