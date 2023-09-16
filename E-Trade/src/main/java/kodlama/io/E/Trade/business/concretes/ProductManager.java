package kodlama.io.E.Trade.business.concretes;

import kodlama.io.E.Trade.business.abstracts.ProductService;
import kodlama.io.E.Trade.business.rules.ProductBusinessRules;
import kodlama.io.E.Trade.core.utilities.mappers.ModelMapperService;
import kodlama.io.E.Trade.dataAccess.abstracts.ProductRepository;
import kodlama.io.E.Trade.dto.request.CreateProductRequest;
import kodlama.io.E.Trade.dto.request.UpdateProductRequest;
import kodlama.io.E.Trade.dto.responses.GetAllProductResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdProductResponse;
import kodlama.io.E.Trade.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;
    private ProductBusinessRules productBusinessRules;
    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = productRepository.findAll();
        List<GetAllProductResponse> getAllProductResponses = products.stream()
                .map(product -> this.modelMapperService.forResponse()
                        .map(product,GetAllProductResponse.class)).collect(Collectors.toList());
        return getAllProductResponses;
    }

    @Override
    public GetByIdProductResponse getById(int id) {
        Product product = this.productRepository.findById(id).orElseThrow();
        GetByIdProductResponse productResponse = this.modelMapperService.forResponse().map(product,GetByIdProductResponse.class);
        return productResponse;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {

        this.productBusinessRules.checkIfProductNameExists(createProductRequest.getName());

        Product product = this.modelMapperService.forRequest().map(createProductRequest,Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest,Product.class);
        this.productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {
        this.productRepository.deleteById(id);
    }
}
