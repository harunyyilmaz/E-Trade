package kodlama.io.E.Trade.business.abstracts;

import kodlama.io.E.Trade.dto.request.CreateProductRequest;
import kodlama.io.E.Trade.dto.request.UpdateProductRequest;
import kodlama.io.E.Trade.dto.responses.GetAllProductResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdProductResponse;


import java.util.List;

public interface ProductService {

    List<GetAllProductResponse> getAll();

    GetByIdProductResponse getById(int id);
    void add(CreateProductRequest createProductRequest);

    void update(UpdateProductRequest updateProductRequest);

    void deleteById(int id);

}
