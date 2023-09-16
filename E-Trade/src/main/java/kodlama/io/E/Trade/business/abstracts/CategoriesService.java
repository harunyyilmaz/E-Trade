package kodlama.io.E.Trade.business.abstracts;

import kodlama.io.E.Trade.dto.request.CreateCategoriesRequest;
import kodlama.io.E.Trade.dto.request.UpdateCategoriesRequest;
import kodlama.io.E.Trade.dto.responses.GetAllCategoriesResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdCategoriesResponse;

import java.util.List;

public interface CategoriesService {

    List<GetAllCategoriesResponse> getAll();
    GetByIdCategoriesResponse getById(int id);
    void add(CreateCategoriesRequest createCategoriesRequest);
    void update(UpdateCategoriesRequest updateCategoriesRequest);
    void deleteById(int id);
}
