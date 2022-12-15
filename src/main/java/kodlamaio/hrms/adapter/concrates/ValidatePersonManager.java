package kodlamaio.hrms.adapter.concrates;

import kodlamaio.hrms.adapter.abstracts.ValidatePersonService;
import kodlamaio.hrms.business.requests.CandidateRequest.CreatCandidateRequest;
import kodlamaio.hrms.mernis.IQUKPSPublicSoap;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service("mernis")
public class ValidatePersonManager implements ValidatePersonService {
    private final IQUKPSPublicSoap iqukpsPublicSoap = new IQUKPSPublicSoap();

    @Override
    public boolean validate(CreatCandidateRequest creatCandidateRequest) {
        try {
            return this.iqukpsPublicSoap.TCKimlikNoDogrula(
                    Long.parseLong(creatCandidateRequest.getIdentityNumber()),
                    creatCandidateRequest.getFirstName().toUpperCase(new Locale("tr", "TR")),
                    creatCandidateRequest.getLastName().toUpperCase(new Locale("tr", "TR")),
                    creatCandidateRequest.getYearOfBirth().getYear());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
