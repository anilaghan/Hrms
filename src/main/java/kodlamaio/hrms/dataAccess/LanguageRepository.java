package kodlamaio.hrms.dataAccess;

import kodlamaio.hrms.entities.concrates.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language,Long> {
}
