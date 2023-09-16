package kodlama.io.E.Trade.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String firstName;
    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String lastName;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    @Size(min = 5,max = 20)
    private int password;


}
