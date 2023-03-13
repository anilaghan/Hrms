package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.requests.languageRequests.CreateLanguageRequest;
import kodlamaio.hrms.dataAccess.LanguageRepository;
import kodlamaio.hrms.entities.concrates.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Language> addAll(List<CreateLanguageRequest> createLanguageRequests){
        return  createLanguageRequests.stream().map(this::add).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

    @Override
    public Language getLanguageById(Long id) {
        return languageRepository.findById(id).orElseThrow();
    }
}
