package kodlama.io.E.Trade.dataAccess.abstracts;

import kodlama.io.E.Trade.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsByLastName(String lastName);
}
