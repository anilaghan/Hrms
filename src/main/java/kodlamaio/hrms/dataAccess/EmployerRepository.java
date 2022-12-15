package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Employer;

import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployerRepository extends JpaRepository<Employer,Long> {


}
