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
public class UpdateProductRequest {

    @NotNull
    @NotBlank
    private int id;
    @NotNull
    @NotBlank
    @Size(min =3,max = 20)
    private String name;
    @NotNull
    @NotBlank
    private String descriptions;
    @NotNull
    @NotBlank
    private double price;
}
