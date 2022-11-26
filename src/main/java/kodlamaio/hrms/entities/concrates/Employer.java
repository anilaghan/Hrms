package kodlamaio.hrms.entities.concrates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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

}
