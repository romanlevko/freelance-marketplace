package roman.levko.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (mappedBy = "assignment")
    private Translator translator;

    @OneToOne (mappedBy = "assignment")
    private Job job;

    @OneToOne(mappedBy = "assignment")
    private Client client;
}