package kodlama.io.E.Trade.wepApi.controller;

import kodlama.io.E.Trade.business.abstracts.CustomerService;
import kodlama.io.E.Trade.dto.request.CreateCustomerRequest;
import kodlama.io.E.Trade.dto.request.UpdateCustomerRequest;
import kodlama.io.E.Trade.dto.responses.GetAllCustomerResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class CustomerController {
    private CustomerService userService;
    @GetMapping
    public List<GetAllCustomerResponse> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCustomerResponse getById(@PathVariable int id){
        return this.userService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Validated CreateCustomerRequest createUserRequest){
        this.userService.add(createUserRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCustomerRequest updateUserRequest){
        this.userService.update(updateUserRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        this.userService.deleteById(id);
    }
}
