package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.requests.EmployerRequest.CreateEmployerRequest;
import kodlamaio.hrms.business.responses.EmployerResponse.GetAllEmployerResponse;
import kodlamaio.hrms.core.utilities.Activation.concrates.EmailActivationManager;
import kodlamaio.hrms.core.utilities.Activation.concrates.EmployeeActivationManager;
import kodlamaio.hrms.dataAccess.AdvertiseRepository;
import kodlamaio.hrms.dataAccess.EmployerRepository;
import kodlamaio.hrms.entities.concrates.Employer;
import kodlamaio.hrms.entities.concrates.JobAdvertise;
import kodlamaio.hrms.entities.dtos.AdvertiseWithEmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class EmployerManager implements EmployerService {
    private final EmployerRepository employerRepository;

    private final AdvertiseRepository advertiseRepository;

    private final PasswordEncoder passwordEncoder;
    private final EmailActivationManager emailActivationManager;
    private final EmployeeActivationManager employeeActivationManager;
@Autowired
    public EmployerManager(EmployerRepository employerRepository, AdvertiseRepository advertiseRepository, PasswordEncoder passwordEncoder, EmailActivationManager emailActivationManager, EmployeeActivationManager employeeActivationManager) {
        this.employerRepository = employerRepository;
        this.advertiseRepository = advertiseRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailActivationManager = emailActivationManager;
        this.employeeActivationManager = employeeActivationManager;
    }

    @Override
    public List<GetAllEmployerResponse> getAll() {
        return employerRepository.findAll().stream().map(GetAllEmployerResponse::new).toList();
    }

    @Override
    public Employer add(CreateEmployerRequest createEmployerRequest) {
        Employer employer = new Employer();
        List<Employer> userList = employerRepository.findAll();
        String encodedPassword = this.passwordEncoder.encode(createEmployerRequest.getPassword());
        for(Employer employer1:userList){
            if(employer1.getEmail().equals(createEmployerRequest.getEmail())){
                throw new RuntimeException("Bu Email ile Kayıtlı Kullanıcı Mevcuttur.");
            }
        }
        if(!emailActivationManager.activate() || !employeeActivationManager.activate()){
            throw new RuntimeException("Lütfen Emailinizi Doğrulayınız.");
        }
        if(!createEmployerRequest.getPassword().equals(createEmployerRequest.getRepeatPassword())){
            throw new RuntimeException("Şifreleriniz Eşleşmiyor.");
        }
        employer.setCompanyName(createEmployerRequest.getCompanyName());
        employer.setWebSite(createEmployerRequest.getWebSite());
        employer.setPhone(createEmployerRequest.getPhone());
        employer.setEmail(createEmployerRequest.getEmail());
        employer.setPassword(encodedPassword);
        return employerRepository.save(employer);
    }

    @Override
    public List<AdvertiseWithEmployerDto> getEmployerWithAdvertises(Long id) {
            Employer employer = employerRepository.findById(id).orElseThrow();
            List<JobAdvertise> result = employer.getAdvertises();
            List<AdvertiseWithEmployerDto> advertiseWithEmployerDtos = new ArrayList<>();
            for(JobAdvertise advertise:result){
                if(advertise.isAdvertiseStatus()){
                    AdvertiseWithEmployerDto advertiseWithEmployerDto = new AdvertiseWithEmployerDto();
                    advertiseWithEmployerDto.setId(advertise.getId());
                    advertiseWithEmployerDto.setJobPosition(advertise.getJob().getName());
                    advertiseWithEmployerDto.setPublishDate(advertise.getPublishDate());
                    advertiseWithEmployerDto.setLastApplicationDate(advertise.getLastApplicationDate());
                    advertiseWithEmployerDto.setOpenPositions(advertise.getOpenPositions());
                    advertiseWithEmployerDto.setStatus(advertise.isAdvertiseStatus());
                    advertiseWithEmployerDto.setCompanyName(employer.getCompanyName());
                    advertiseWithEmployerDtos.add(advertiseWithEmployerDto);
                }
            }
            return advertiseWithEmployerDtos;

    }

    @Override
    public Employer employerAdvertisePasive(Long employerId, Long advertiseId) {
        List<AdvertiseWithEmployerDto> employerAdvertises = getEmployerWithAdvertises(employerId);
        for(AdvertiseWithEmployerDto advertise:employerAdvertises){
            if(advertise.getId().equals(advertiseId)){
                advertise.setStatus(false);
            }
        }
        return null;
    }

}
