package kodlama.io.E.Trade.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="descriptions")
    private String descriptions;


    @ManyToOne
    @JoinColumn(name="categories_id")
    private Categories categories;

}
