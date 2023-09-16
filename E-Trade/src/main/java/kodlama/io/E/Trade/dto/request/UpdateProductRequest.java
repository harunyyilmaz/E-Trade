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
