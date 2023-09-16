package kodlama.io.E.Trade.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCategoriesResponse {
    private int id;
    private String name;
}
