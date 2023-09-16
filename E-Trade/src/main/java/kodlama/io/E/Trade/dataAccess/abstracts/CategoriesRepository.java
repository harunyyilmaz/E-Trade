package kodlama.io.E.Trade.dataAccess.abstracts;

import kodlama.io.E.Trade.entities.concretes.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Integer> {
    boolean existsByName(String name);
}
