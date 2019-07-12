package roman.levko.demo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientRequest {

    private String name;
    private String username;
    private String password;
    private String country;
    private String city;
    private Double ranking;
    private List <Long> jobs;
}
