package kodlama.io.E.Trade.wepApi.controller;

import kodlama.io.E.Trade.business.abstracts.ProductService;
import kodlama.io.E.Trade.dto.request.CreateProductRequest;
import kodlama.io.E.Trade.dto.request.UpdateProductRequest;
import kodlama.io.E.Trade.dto.responses.GetAllProductResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsControllers {
    private ProductService productService;

    @GetMapping
    public List<GetAllProductResponse> getAll() {

        return this.productService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdProductResponse getById(@PathVariable int id) {
        return this.productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateProductRequest createProductRequest){
        this.productService.add(createProductRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateProductRequest updateProductRequest){
        this.productService.update(updateProductRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        this.productService.deleteById(id);
    }

}
