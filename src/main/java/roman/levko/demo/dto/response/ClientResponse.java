package roman.levko.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import roman.levko.demo.entity.Client;

@Getter
@Setter
public class ClientResponse {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String country;
    private String city;
    private Double ranking;
    private String image;

    public ClientResponse(Client client) {

        id = client.getId();
        name = client.getName();
        username = client.getUsername();
        password = client.getPassword();
        country = client.getCountry();
        city = client.getCity();
        ranking = client.getRanking();
        image = client.getImage();

    }
}
