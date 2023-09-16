package kodlama.io.E.Trade.business.abstracts;

import kodlama.io.E.Trade.dto.request.CreateCustomerRequest;
import kodlama.io.E.Trade.dto.request.UpdateCustomerRequest;
import kodlama.io.E.Trade.dto.responses.GetAllCustomerResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdCustomerResponse;

import java.util.List;

public interface CustomerService {

    List<GetAllCustomerResponse> getAll();
    GetByIdCustomerResponse getById(int id);
    void add(CreateCustomerRequest createUserRequest);

    void update(UpdateCustomerRequest updateUserRequest);
    void deleteById(int id);
}
