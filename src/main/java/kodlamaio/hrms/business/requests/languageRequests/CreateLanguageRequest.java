package kodlamaio.hrms.business.requests.languageRequests;

import kodlamaio.hrms.entities.concrates.LanguageLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageRequest {
    private String languageName;
    private LanguageLevel languageLevel;

}
