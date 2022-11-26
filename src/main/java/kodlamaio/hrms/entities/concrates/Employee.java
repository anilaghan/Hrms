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
@PrimaryKeyJoinColumn(name = "employee_id",referencedColumnName = "user_id" )
@Table(name="employees")
public class Employee extends User{

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;

}
