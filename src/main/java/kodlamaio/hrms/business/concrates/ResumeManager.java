package kodlamaio.hrms.business.concrates;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.business.requests.educationRequest.CreateEducationRequest;
import kodlamaio.hrms.business.requests.jobExperienceRequest.CreateJobExperienceRequest;
import kodlamaio.hrms.business.requests.knowledgeRequest.CreateKnowledgeRequest;
import kodlamaio.hrms.business.requests.languageRequests.CreateLanguageRequest;
import kodlamaio.hrms.business.requests.resumeRequest.CreateResumeRequest;
import kodlamaio.hrms.dataAccess.*;
import kodlamaio.hrms.entities.concrates.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class ResumeManager implements ResumeService {
    private final CvRepository cvRepository;

    private final CandidatesService candidatesService;

    private final EducationService educationService;

    private final JobExperienceService jobExperienceService;

    private final LanguageService languageService;

    private final KnowledgeService knowledgeService;

    public ResumeManager(CvRepository cvRepository, CandidatesService candidatesService,
                         EducationService educationService, JobExperienceService jobExperienceService,
                         LanguageService languageService,
                         KnowledgeService knowledgeService) {
        this.cvRepository = cvRepository;
        this.candidatesService = candidatesService;
        this.educationService = educationService;
        this.jobExperienceService = jobExperienceService;
        this.languageService = languageService;
        this.knowledgeService = knowledgeService;
    }

    @Override
    @Transactional
    public Resume add(CreateResumeRequest createResumeRequest) {
        Resume resume = new Resume();
        List<CreateEducationRequest> educations = createResumeRequest.getEducations();
        List<CreateJobExperienceRequest> jobExperiences = createResumeRequest.getJobExperiences();
        List<CreateKnowledgeRequest> skills = createResumeRequest.getSkills();
        List<Language> languages = languageService.addAll(createResumeRequest.getLanguages());
        resume.getLanguages().addAll(languages);




       /*
        List<Education> educations = new ArrayList<>();
        List<JobExperience> jobExperiences =new ArrayList<>();
        List<Language> languages = new ArrayList<>();
        List<Skills> skills = new ArrayList<>();
        Candidate candidate = candidatesService.getCandidateById(createResumeRequest.getCandidateId());
        Education education = educationService.getEducationById(createResumeRequest.getEducationId());
        JobExperience jobExperience = jobExperienceService.jobExperienceGetById(createResumeRequest.getJobExperienceId());
        Language language = languageService.getLanguageById(createResumeRequest.getLanguageId());
        Skills skills = knowledgeService.getKnowledgeById(createResumeRequest.getKnowledgeId());

        skills.add(skills);
        languages.add(language);
        jobExperiences.add(jobExperience);
        educations.add(education);
        resume.setCandidate(candidate);
        resume.setLanguages(languages);
        resume.setEducations(educations);
        resume.setJobExperiences(jobExperiences);
        resume.setSkills(skills);
        resume.setLinkedin(createResumeRequest.getLinkedin());
        resume.setGitLink(createResumeRequest.getGitLink());
        resume.setPhotoLink(createResumeRequest.getPhotoLink());
        resume.setTextArea(createResumeRequest.getTextArea());*/
        return cvRepository.save(resume);
    }

    @Override
    public void delete(Long id) {
        cvRepository.deleteById(id);
    }

    @Override
    public Resume getCandidateCv(Long id) {
        Candidate candidate = candidatesService.getCandidateById(id);
        return candidate.getResume();
    }

    @Override
    public Resume getById(Long id) {
        return cvRepository.findById(id).orElseThrow();
    }
}
