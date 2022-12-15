package kodlamaio.hrms.entities.concrates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name ="employer_id",referencedColumnName = "user_id" )
public class Employer extends User{

    @Column(name="company_name")
    private String companyName;
    @Column(name="web_site")
    private String webSite;
    @Column(name="phone")
    private String phone;
    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertise> advertises;
}
