package kodlama.io.E.Trade.entities.concretes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import kodlama.io.E.Trade.base.BaseEntity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)  // *** Jackson, JSON verilerini Java nesnelerine dönüştürmek ve
                                            // Java nesnelerini JSON verilerine dönüştürmek için kullanılan popüler bir Java kütüphanesidir.
                                            // *** Bu işaretleme yöntemi, JSON çıktısı oluşturulurken Java nesne alanlarının nasıl işleneceğini belirtir.
                                            // JsonInclude.Include.NON_NULL parametresi ile kullanıldığında, bu,
                                            // sadece Java nesnelerinde null olmayan alanların JSON çıktısına dahil edileceği anlamına gelir.
public class User extends BaseEntity {

    private String userName;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private boolean isEnable;

    public User(@JsonProperty("userName") String userName,
                @JsonProperty("firstName") String firstName,
                @JsonProperty("lastName") String lastName,
                @JsonProperty("email") String email,
                @JsonProperty("password") String password,
                @JsonProperty("isEnable") boolean isEnable) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnable = isEnable;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<Role> roles = new HashSet<>();

    public User() {

    }
}
