package kodlamaio.hrms.entities.concrates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @ManyToOne
    private Cv cv;



}
