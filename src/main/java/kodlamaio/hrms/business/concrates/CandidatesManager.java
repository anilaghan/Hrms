package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.adapter.abstracts.ValidatePersonService;
import kodlamaio.hrms.business.abstracts.CandidatesService;
import kodlamaio.hrms.business.requests.candidateRequest.CreatCandidateRequest;
import kodlamaio.hrms.business.requests.candidateRequest.UpdateCandidateRequest;
import kodlamaio.hrms.business.responses.CandidatesResponse.GetAllCandidatesResponse;
import kodlamaio.hrms.core.utilities.Activation.concrates.EmailActivationManager;
import kodlamaio.hrms.dataAccess.CandidatesRepository;
import kodlamaio.hrms.entities.concrates.Candidate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatesManager implements CandidatesService {
    private final CandidatesRepository candidatesRepository;
    private final ValidatePersonService validatePersonService;

    private final PasswordEncoder passwordEncoder;

    private final EmailActivationManager emailActivationManager;


    public CandidatesManager(CandidatesRepository candidatesRepository, ValidatePersonService validatePersonService, PasswordEncoder passwordEncoder, EmailActivationManager emailActivationManager) {
        this.candidatesRepository = candidatesRepository;
        this.validatePersonService = validatePersonService;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.emailActivationManager = emailActivationManager;
    }

    @Override
    public List<GetAllCandidatesResponse> getAll() {
        return candidatesRepository.findAll().stream().map(GetAllCandidatesResponse::new).toList();
    }

    @Override
    public Candidate add(CreatCandidateRequest creatCandidateRequest) {
        Candidate candidate = new Candidate();
        List<Candidate> userList = candidatesRepository.findAll();
        String encodedPassword = this.passwordEncoder.encode(creatCandidateRequest.getPassword());
        for (Candidate candidate1 : userList) {
            if (candidate1.getEmail().equals(creatCandidateRequest.getEmail()) || candidate1.getIdentityNumber().equals(creatCandidateRequest.getIdentityNumber())) {
                throw new RuntimeException("Bu kullanıcı daha önce kayıt olmuş.");
            }
        }
        if (!this.validatePersonService.validate(creatCandidateRequest) || !this.emailActivationManager.activate()) {
            throw new RuntimeException("Tc Kimlik No Doğrulaması Geçersiz.");
        }
        if (!creatCandidateRequest.getPassword().equals(creatCandidateRequest.getRepeatPassword())) {
            throw new RuntimeException("Şifreleriniz Eşleşmiyor");
        }
        candidate.setFirstName(creatCandidateRequest.getFirstName());
        candidate.setLastName(creatCandidateRequest.getLastName());
        candidate.setIdentityNumber(creatCandidateRequest.getIdentityNumber());
        candidate.setYearOfBirth(creatCandidateRequest.getYearOfBirth());
        candidate.setEmail(creatCandidateRequest.getEmail());
        candidate.setPassword(encodedPassword);


        return candidatesRepository.save(candidate);
    }

    @Override
    public Candidate update(Long id, UpdateCandidateRequest updateCandidateRequest) {

        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Candidate getCandidateById(Long id) {
        return candidatesRepository.findById(id).orElseThrow();
    }
}
