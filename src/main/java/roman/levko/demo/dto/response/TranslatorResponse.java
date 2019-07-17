package roman.levko.demo.dto.response;

import lombok.Getter;
import lombok.Setter;
import roman.levko.demo.entity.Translator;

@Getter
@Setter
public class TranslatorResponse {

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
    private String image;

    public TranslatorResponse(Translator translator) {

        id = translator.getId();
        firstName = translator.getFirstName();
        secondName = translator.getSecondName();
        username = translator.getUsername();
        password = translator.getPassword();
        country = translator.getCountry();
        city = translator.getCity();
        age = translator.getAge();
        yearsOfExperience = translator.getYearsOfExperience();
        ranking = translator.getRanking();
        image = translator.getImage();

    }
}
