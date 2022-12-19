package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.business.requests.educationRequest.CreateEducationRequest;
import kodlamaio.hrms.dataAccess.EducationRepository;
import kodlamaio.hrms.entities.concrates.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    @Autowired
    private final EducationRepository educationRepository;

    public EducationManager(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public Education add(CreateEducationRequest createEducationRequest) {
        Education education = new Education();
        education.setSchoolName(createEducationRequest.getSchoolName());
        education.setDepartmanName(createEducationRequest.getDepartmanName());
        education.setStartDate(createEducationRequest.getStartDate());
        education.setGraduateDate(createEducationRequest.getGraduateDate());
        education.setGraduateStatus(createEducationRequest.isGraduateStatus());

        return educationRepository.save(education);
    }

    @Override
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public List<Education> getAllSorted() {
        return educationRepository.findAll(Sort.by(Sort.Direction.DESC,"GraduateDate"));
    }
}
