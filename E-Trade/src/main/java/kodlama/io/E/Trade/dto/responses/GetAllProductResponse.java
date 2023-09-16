package kodlama.io.E.Trade.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllProductResponse {

    private int id;
    private String name;
    private String descriptions;
    private double price;

    private int categoriesId;
    private String categoriesName;

    private int userId;
    private String userName;


}

