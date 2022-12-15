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
@Table(name="job_expreiances")
public class JobExperiance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_experiance_id")
    private Long id;
    @Column(name="company_name")
    private String companyName;
    @Column(name="job_position")
    private String jobPositon;
    @Column(name="start_date")
    private LocalDate startDate;
    @Column(name="end_date")
    private LocalDate endDate;
    @Column(name="job_status")
    private boolean jobStatus;

    @ManyToOne
    private Cv cv;
}
