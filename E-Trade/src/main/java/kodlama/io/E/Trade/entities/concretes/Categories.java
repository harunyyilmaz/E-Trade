package kodlama.io.E.Trade.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "categories")
    private List<Product> products;
}
