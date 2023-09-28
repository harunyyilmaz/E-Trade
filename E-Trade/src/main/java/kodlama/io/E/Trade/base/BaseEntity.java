package kodlama.io.E.Trade.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class}) // bunun sayesinde   "*LastModifiedDate * CreatedDate " alanları otomatik olarak doldurulacaktır.


public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @LastModifiedDate // son güncelleme tarihi takibi
    private Date updateDate;
    @CreatedDate // oluşturulma tarihi takibi ( oluşturulma tarihi ve saati izlemek için kullanılır.)
    private LocalDateTime createdAt = LocalDateTime.now();
}

// Veritabanı tablolarının temel yapısını tanımlayan, ancak doğrudan bir veritabanı tablosuna gelmeyen bir sınıf türüdür.
// Bu sınıflar genellikle diğer JPA varlıkları tarafından genişletilir ve böylece bu varlıkların ortak özelliklerini ve davranışlarını miras alır.
// Bir uygulama için birden fazla varlık sınıfı arasında paylaşılan özellikleri ve alanları tanımlamak için kullanılır
// Örneğin bir veritabanı tablosunun her bir satırında bulunan yinelenen alanları ( örnek oluşturma tarihi güncelleme tarihi gibi.)