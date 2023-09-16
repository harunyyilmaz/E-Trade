package kodlama.io.E.Trade.business.rules;

import kodlama.io.E.Trade.core.utilities.exceptions.BusinessExceptions;
import kodlama.io.E.Trade.dataAccess.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductBusinessRules {
    private ProductRepository productRepository;
    public void checkIfProductNameExists(String name){
        if(this.productRepository.existsByName(name)){
            throw new BusinessExceptions("Product name already exists !");
        }
    }
}
