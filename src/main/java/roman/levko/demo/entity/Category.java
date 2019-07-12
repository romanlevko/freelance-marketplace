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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true)
    private String name;

    @ManyToMany (mappedBy = "categories")
    private List<Translator> translators = new ArrayList<>();

    @ManyToMany (mappedBy = "categories")
    private List<Client> clients = new ArrayList<>();

    @OneToOne (mappedBy = "category")
    private Job job;

}
