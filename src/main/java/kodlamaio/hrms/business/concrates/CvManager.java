package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.business.requests.cvRequest.CreateCvRequest;
import kodlamaio.hrms.dataAccess.*;
import kodlamaio.hrms.entities.concrates.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CvManager implements CvService {
    private final CvRepository cvRepository;

    private final CandidatesRepository candidatesRepository;

    private final EducationRepository educationRepository;

    private final JobExperianceRepository jobExperianceRepository;

    private final LanguageRepository languageRepository;

    private final KnowledgeRepository knowledgeRepository;

    public CvManager(CvRepository cvRepository, CandidatesRepository candidatesRepository, EducationRepository educationRepository, JobExperianceRepository jobExperianceRepository, LanguageRepository languageRepository, KnowledgeRepository knowledgeRepository) {
        this.cvRepository = cvRepository;
        this.candidatesRepository = candidatesRepository;
        this.educationRepository = educationRepository;
        this.jobExperianceRepository = jobExperianceRepository;
        this.languageRepository = languageRepository;
        this.knowledgeRepository = knowledgeRepository;
    }

    @Override
    public Cv add(CreateCvRequest createCvRequest) {
        Cv cv = new Cv();
        List<Education> educations = new ArrayList<>();
        List<JobExperience> jobExperiences =new ArrayList<>();
        List<Language> languages = new ArrayList<>();
        List<Knowledge> knowledges = new ArrayList<>();
        Candidate candidate = candidatesRepository.getReferenceById(createCvRequest.getCandidateId());
        Education education = educationRepository.getReferenceById(createCvRequest.getEducationId());
        JobExperience jobExperience = jobExperianceRepository.getReferenceById(createCvRequest.getEducationId());
        Language language = languageRepository.getReferenceById(createCvRequest.getLanguageId());
        Knowledge knowledge = knowledgeRepository.getReferenceById(createCvRequest.getKnowledgeId());

        knowledges.add(knowledge);
        languages.add(language);
        jobExperiences.add(jobExperience);
        educations.add(education);
        cv.setCandidate(candidate);
        cv.setLanguages(languages);
        cv.setEducations(educations);
        cv.setJobExperiences(jobExperiences);
        cv.setKnowledges(knowledges);
        cv.setLinkedin(createCvRequest.getLinkedin());
        cv.setGitLink(createCvRequest.getGitLink());
        cv.setPhotoLink(createCvRequest.getPhotoLink());
        cv.setTextArea(createCvRequest.getTextArea());
        return cvRepository.save(cv);
    }

    @Override
    public void delete(Long id) {
        cvRepository.deleteById(id);
    }
}
