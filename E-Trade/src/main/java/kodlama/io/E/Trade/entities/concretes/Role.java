package kodlama.io.E.Trade.entities.concretes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import kodlama.io.E.Trade.base.BaseEntity;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role extends BaseEntity {

    @Column(unique = true)
    private String name;
    @Column
    private String description;

    @ManyToMany(mappedBy = "roles" ,cascade = {CascadeType.PERSIST , CascadeType.MERGE })
    private Set<User> users;

    public Role(@JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("user") Set<User> users) {
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public Role() {
    }

    /*
    JSON Verilerini Nesneye Dönüştürme: Bu yapıcı metot, JSON verilerini doğrudan bir Java nesnesine dönüştürmek için kullanılır.
     Bir JSON verisi alındığında, bu veriyi ilgili Java sınıfına çevirmek istediğinizde, bu tür bir yapıcı metot kullanmak uygun olabilir.
      Jackson, @JsonProperty kullanımı ile bu işlemi gerçekleştirir ve JSON'daki anahtarları ilgili alanlarla eşleştirir.

Özelleştirilmiş JSON İşlemi: JSON verileri ile Java nesneleri arasındaki dönüşümü özelleştirmek için bu tür yapıcı metotları kullanabilirsiniz.
 Örneğin, JSON'da farklı bir anahtar adı kullanılıyorsa veya JSON'da olmayan bazı alanları varsayılan değerlerle doldurmak isterseniz,
  bu yapıcı metotlarını kullanabilirsiniz.

Doğrulama ve İş Kuralları: Bu yapıcı metotları kullanarak gelen JSON verilerini doğrulayabilir ve belirli iş kurallarını uygulayabilirsiniz.
Örneğin, gelen JSON verisinin belirli bir formata uymasını veya belirli bir koşulu sağlamasını gerektiren iş mantığı kurallarını bu yapıcı içinde uygulayabilirsiniz.

Bağımlılıkları Yönetme: Bu yapıcı metotları kullanarak bağımlılıkları
 (örneğin, Set<User> users) yönetmek ve ilişkili nesneleri bu yapıcı aracılığıyla eklemek veya kaldırmak daha kolay olabilir.
  Jackson ve benzeri kütüphaneler, ilişkili nesneleri otomatik olarak çözebilir ve ekleme işlemini gerçekleştirebilir.

Sonuç olarak, bu tür özelleştirilmiş yapıcı metotlar, JSON verilerini Java nesnelerine dönüştürmek ve ilgili iş mantığı ve gereksinimleri ele almak için kullanılır.
 JSON işleme kütüphaneleri, bu tür yapıcı metotları kullanarak JSON verileri ile Java nesneleri arasındaki dönüşümü daha esnek hale getirir.
     */
}
