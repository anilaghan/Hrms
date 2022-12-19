package kodlamaio.hrms.entities.concrates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cv_id")
    private Long id;
    @Column(name="cv_photo")
    private String photoLink;
    @Column(name = "cv_git_link")
    private String gitLink;
    @Column(name = "cv_linkedin_link")
    private String linkedin;
    @Column(name = "cv_text")
    private String textArea;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cv")
    private List<Education> educations;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cv")
    private List<JobExperience> jobExperiences;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cv")
    private List<Language> languages;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "cv")
    private List<Knowledge> knowledges;



}
