package kodlamaio.hrms.entities.concrates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cv")
public class Resume {

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

    @OneToMany

    private List<Education> educations;
    @OneToMany

    private List<JobExperience> jobExperiences;
    @OneToMany(mappedBy = "resume")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Language> languages = new ArrayList<>();
    @OneToMany
    private List<Skills> skills;



}
