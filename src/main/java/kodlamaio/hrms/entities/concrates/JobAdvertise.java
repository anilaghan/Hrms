package kodlamaio.hrms.entities.concrates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertises")
public class JobAdvertise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="advertise_id")
    private Long id;

    private String title;

    private City city;

    private double minSalary;

    private double maxSalary;

    private String openPositions;

    private LocalDate lastApplicationDate;

    private boolean advertiseStatus;

    private String description;

    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
