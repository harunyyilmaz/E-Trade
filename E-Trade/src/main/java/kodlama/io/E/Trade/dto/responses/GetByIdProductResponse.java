package kodlama.io.E.Trade.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdProductResponse {

    private int id;
    private String name;
    private String descriptions;
    private double price;
}
