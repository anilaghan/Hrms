package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.languageRequests.CreateLanguageRequest;
import kodlamaio.hrms.entities.concrates.Language;

import java.util.List;

public interface LanguageService {
     Language add(CreateLanguageRequest createLanguageRequest);

     void delete(Long id);

     Language getLanguageById(Long id);

     List<Language> addAll(List<CreateLanguageRequest> createLanguageRequests);
}
