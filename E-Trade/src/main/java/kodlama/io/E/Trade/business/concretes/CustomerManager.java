package kodlama.io.E.Trade.business.concretes;

import kodlama.io.E.Trade.business.abstracts.CustomerService;
import kodlama.io.E.Trade.core.utilities.mappers.ModelMapperService;
import kodlama.io.E.Trade.dataAccess.abstracts.CustomerRepository;
import kodlama.io.E.Trade.dto.request.CreateCustomerRequest;
import kodlama.io.E.Trade.dto.request.UpdateCustomerRequest;
import kodlama.io.E.Trade.dto.responses.GetAllCustomerResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdCustomerResponse;
import kodlama.io.E.Trade.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    private CustomerRepository customerRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> users = this.customerRepository.findAll();
        List<GetAllCustomerResponse> getAllUserResponses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllCustomerResponse.class)).collect(Collectors.toList());
        return getAllUserResponses;
    }

    @Override
    public GetByIdCustomerResponse getById(int id) {
        Customer user = this.customerRepository.findById(id).orElseThrow();
        GetByIdCustomerResponse getByIdCustomerResponse = this.modelMapperService.forResponse().map(user, GetByIdCustomerResponse.class);
        return getByIdCustomerResponse;
    }

    @Override
    public void add(CreateCustomerRequest createUserRequest) {
        this.customerRepository.existsByLastName(createUserRequest.getEmail());

        Customer user = this.modelMapperService.forRequest().map(createUserRequest, Customer.class);
        this.customerRepository.save(user);
    }

    @Override
    public void update(UpdateCustomerRequest updateUserRequest) {
        Customer user = this.modelMapperService.forRequest().map(updateUserRequest, Customer.class);
        this.customerRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        this.customerRepository.deleteById(id);
    }
}
