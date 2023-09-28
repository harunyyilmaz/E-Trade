package kodlama.io.E.Trade.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kodlama.io.E.Trade.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categories extends BaseEntity {

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "categories" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Product> products;
}
