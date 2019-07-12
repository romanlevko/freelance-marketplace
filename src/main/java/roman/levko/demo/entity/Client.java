package roman.levko.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String country;
    private String city;
    private Double ranking;


    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToMany
    private List<Job> jobs = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    private List<Assignment> assignments = new ArrayList<>();
}
