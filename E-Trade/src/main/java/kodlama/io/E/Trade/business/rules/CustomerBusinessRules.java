package kodlama.io.E.Trade.business.rules;

import kodlama.io.E.Trade.core.utilities.exceptions.BusinessExceptions;
import kodlama.io.E.Trade.dataAccess.abstracts.CustomerRepository;

public class CustomerBusinessRules{
    private CustomerRepository customerRepository;

    public void checkIfCustomerNameExists(String lastName){
        if(this.customerRepository.existsByLastName(lastName)){
            throw new BusinessExceptions("Customer email already exists !");
        }

    }
}

