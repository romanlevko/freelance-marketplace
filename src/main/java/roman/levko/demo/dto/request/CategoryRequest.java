package roman.levko.demo.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryRequest {
    @NotNull
    private String name;


}
