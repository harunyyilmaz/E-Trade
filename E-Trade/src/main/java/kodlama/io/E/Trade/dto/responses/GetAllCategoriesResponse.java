package kodlama.io.E.Trade.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCategoriesResponse {
    private int id;
    private String name;
    private String userName;
}
