package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.requests.languageRequests.CreateLanguageRequest;
import kodlamaio.hrms.entities.concrates.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/languages")
public class LanguageController {
    @Autowired
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    Language add(CreateLanguageRequest createLanguageRequest){
        return languageService.add(createLanguageRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        languageService.delete(id);
    }



}
