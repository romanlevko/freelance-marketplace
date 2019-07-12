package roman.levko.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long volume;
    private Date deadline;
    private Double pricePerWord;
    @Column (columnDefinition = "text")
    private String description;
    private String sourceLanguage;
    private String targetLanguage;

    @ManyToMany
    private List<Translator> translators = new ArrayList<>();

    @ManyToMany (mappedBy = "jobs")
    private List<Client> clients = new ArrayList<>();

    @OneToOne
    private Assignment assignment;

    @OneToOne
    private Category category;
}
