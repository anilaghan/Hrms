package kodlamaio.hrms.entities.concrates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="languages")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="language_id")
    private Long id;
    @Column(name = "language_name" )
    private String name;
    @Column(name="language_level")
    private LanguageLevel languageLevel;

    @ManyToOne(cascade = CascadeType.ALL)
    private Resume resume;






}
