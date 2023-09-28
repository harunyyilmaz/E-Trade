package kodlama.io.E.Trade.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import kodlama.io.E.Trade.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Table(name="customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends BaseEntity {


    @Column(name="firstName")
    private String firstname;
    @Column(name="lastName")
    private String lastName;
    @Column(name="email" , unique = true)
    private String email;
    @Column(name="password" , unique = true)
    private String password;
    @Column(name="age")
    private int age;
    @Column(name="birthYear")
    private int birthYear;







}
