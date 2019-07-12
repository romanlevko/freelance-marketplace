package roman.levko.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Translator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    private String country;
    private String city;
    private Long age;
    private Long yearsOfExperience;
    private Double ranking;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToMany (mappedBy = "translators")
    private List<Job> jobs = new ArrayList<>();

    @OneToMany (mappedBy = "translator")
    private List<Assignment> assignments = new ArrayList<>();

}
