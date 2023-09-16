package kodlama.io.E.Trade.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdCustomerResponse {

    private int id;
    private String firstName;
    private String LastName;
    private int age;
    private int birthYear;
}
