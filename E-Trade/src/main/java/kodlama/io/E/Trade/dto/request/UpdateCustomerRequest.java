package kodlama.io.E.Trade.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    @NotNull
    @NotNull
    private int id;
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
    private String password;

}
