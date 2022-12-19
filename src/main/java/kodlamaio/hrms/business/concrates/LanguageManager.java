package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.requests.languageRequests.CreateLanguageRequest;
import kodlamaio.hrms.dataAccess.LanguageRepository;
import kodlamaio.hrms.entities.concrates.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements LanguageService {

    @Autowired
    private LanguageRepository languageRepository;


    @Override
    public Language add(CreateLanguageRequest createLanguageRequest) {
        Language language = new Language();
        language.setName(createLanguageRequest.getLanguageName());
        language.setLanguageLevel(createLanguageRequest.getLanguageLevel());
        return languageRepository.save(language);
    }

    @Override
    public void delete(Long id) {
        languageRepository.deleteById(id);
    }
}
