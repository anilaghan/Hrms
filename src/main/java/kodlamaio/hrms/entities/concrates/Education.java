package kodlamaio.hrms.entities.concrates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "departman_name")
    private String departmanName;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "graduate_date")
    private LocalDate graduateDate;
    @Column(name="graduate_status")
    private boolean graduateStatus;

    @ManyToOne
    private Cv cv;
}
