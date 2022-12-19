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


    @OneToOne
    private Candidate candidate;
    @OneToMany
    private List<Education> educations;
    @OneToMany
    private List<JobExperience> jobExperiences;
    @OneToMany
    private List<Language> languages;
    @OneToMany
    private List<Knowledge> knowledges;



}
