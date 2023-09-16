package kodlama.io.E.Trade.wepApi.controller;

import kodlama.io.E.Trade.business.abstracts.CategoriesService;
import kodlama.io.E.Trade.dto.request.CreateCategoriesRequest;
import kodlama.io.E.Trade.dto.request.UpdateCategoriesRequest;
import kodlama.io.E.Trade.dto.responses.GetAllCategoriesResponse;
import kodlama.io.E.Trade.dto.responses.GetByIdCategoriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoriesControllers {
    private CategoriesService categoriesService;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll(){
        return this.categoriesService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdCategoriesResponse getById(@PathVariable int id){
        return this.categoriesService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody @Valid CreateCategoriesRequest createCategoriesRequest){
        this.categoriesService.add(createCategoriesRequest);
    }
    @PutMapping
    void update(@RequestBody UpdateCategoriesRequest updateCategoriesRequest){
        this.categoriesService.update(updateCategoriesRequest);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        this.categoriesService.deleteById(id);
    }

}
