package kodlamaio.hrms.entities.concrates;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
    private Long id;
    @Column(name="job_name")
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "job")
    private List<JobAdvertise> advertise;
}
