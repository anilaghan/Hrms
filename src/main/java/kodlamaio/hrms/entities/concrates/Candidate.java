package kodlamaio.hrms.entities.concrates;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name = "candidate_id",referencedColumnName = "user_id" )
public class Candidate extends User{

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "year_of_birth")
    private String yearOfBirth;
    @Column(name = "identity_number")
    private String identityNumber;



}
