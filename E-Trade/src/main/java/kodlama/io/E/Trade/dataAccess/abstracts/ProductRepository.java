package kodlama.io.E.Trade.dataAccess.abstracts;

import kodlama.io.E.Trade.entities.concretes.Product;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    boolean existsByName(String name);

}
