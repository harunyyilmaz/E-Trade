package kodlama.io.E.Trade.business.rules;

import kodlama.io.E.Trade.core.utilities.exceptions.BusinessExceptions;
import kodlama.io.E.Trade.dataAccess.abstracts.CategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriesBusinessRules {
    private CategoriesRepository categoriesRepository;
    public void checkIfCategoriesNameExists(String name){
        if (this.categoriesRepository.existsByName(name)){
            throw new BusinessExceptions("Categories name already exists !");
        }
    }
}
