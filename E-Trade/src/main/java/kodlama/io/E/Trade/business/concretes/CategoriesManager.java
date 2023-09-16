package kodlama.io.E.Trade.business.concretes;

import kodlama.io.E.Trade.business.abstracts.CategoriesService;
import kodlama.io.E.Trade.business.rules.CategoriesBusinessRules;
import kodlama.io.E.Trade.core.utilities.mappers.ModelMapperService;
import kodlama.io.E.Trade.dataAccess.abstracts.CategoriesRepository;
import kodlama.io.E.Trade.dto.request.CreateCategoriesRequest;
import kodlama.io.E.Trade.dto.request.UpdateCategoriesRequest;
import kodlama.io.E.Trade.dto.responses.GetAllCategoriesResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdCategoriesResponse;
import kodlama.io.E.Trade.entities.concretes.Categories;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoriesManager implements CategoriesService {
    private CategoriesRepository categoriesRepository;
    private ModelMapperService modelMapperService;
    private CategoriesBusinessRules categoriesBusinessRules;
    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Categories> categories=this.categoriesRepository.findAll();
        List<GetAllCategoriesResponse> categoriesResponses = categories.stream()
                .map(categories1 -> this.modelMapperService.forResponse()
                        .map(categories1,GetAllCategoriesResponse.class)).collect(Collectors.toList());
        return categoriesResponses;
    }

    @Override
    public GetByIdCategoriesResponse getById(int id) {
        Categories categories = this.categoriesRepository.findById(id).orElseThrow();
        GetByIdCategoriesResponse categoriesResponse =this.modelMapperService.forResponse().map(categories,GetByIdCategoriesResponse.class);
        return categoriesResponse;
    }

    @Override
    public void add(CreateCategoriesRequest createCategoriesRequest) {

        this.categoriesRepository.existsByName(createCategoriesRequest.getName());

        Categories categories = this.modelMapperService.forRequest().map(createCategoriesRequest,Categories.class);
        this.categoriesRepository.save(categories);

    }

    @Override
    public void update(UpdateCategoriesRequest updateCategoriesRequest) {
        Categories categories = this.modelMapperService.forRequest().map(updateCategoriesRequest,Categories.class);
        this.categoriesRepository.save(categories);
    }

    @Override
    public void deleteById(int id) {
        this.categoriesRepository.deleteById(id);
    }
}
