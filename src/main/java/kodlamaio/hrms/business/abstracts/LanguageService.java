package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.business.requests.languageRequests.CreateLanguageRequest;
import kodlamaio.hrms.entities.concrates.Language;

public interface LanguageService {
     Language add(CreateLanguageRequest createLanguageRequest);

     void delete(Long id);
}
