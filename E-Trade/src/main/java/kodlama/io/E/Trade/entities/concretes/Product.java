package kodlama.io.E.Trade.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import kodlama.io.E.Trade.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseEntity{


    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;
    @Column(name="descriptions")
    private String descriptions;



    @ManyToOne ( fetch = FetchType.LAZY)
    @JoinColumn(name="categories_id")
    @JsonIgnore
    /* JSONIGNORE
    Bu tür bir özelleştirme özellikle döngüsel ilişkileri önlemek veya verileri gereksiz yere şişirmemek için kullanışlı olabilir.
    Örneğin, Category nesnesi içinde Product nesnesine referans yapıyorsanız ve bu Product nesnesi içinde de Category nesnesine geri referans varsa,
    bu döngüsel bir ilişki oluşturabilir ve veri alışverişini karmaşıklaştırabilir. @JsonIgnore bu tür durumları yönetmek için kullanılabilir.
     */
    private Categories categories;

}
