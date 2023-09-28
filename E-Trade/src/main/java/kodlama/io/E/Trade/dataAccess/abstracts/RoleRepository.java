package kodlama.io.E.Trade.dataAccess.abstracts;

import kodlama.io.E.Trade.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    /*
    bir Java programında kullanılan bir metot imzasını ifade eder.
    Bu metot, belirli bir isme sahip bir kullanıcı rolünü (veya yetkisini) veritabanından veya başka bir kaynaktan bulmak amacıyla tasarlanmıştır.
    Bu metotun anlamını aşağıda daha detaylı bir şekilde açıklayalım:

Role: Bu, metodu çağıran programda kullanılan veri türünü temsil eder.
Genellikle bir sınıf veya veri tabanı tablosu olarak düşünülebilir.
Bu özel durumda, Role sınıfı, kullanıcıların sistemde sahip olabileceği farklı rolleri veya yetkileri temsil eder.
Örnek roller "ADMIN", "USER", "GUEST" gibi isimlerle ifade edilebilir.

findByName(String name): Bu, metodu çağıranın bir isimle ilişkilendirilen bir rolü bulmasını sağlayan metot adıdır.
name parametresi, aranan rolün adını (ismini) temsil eder. Yani, bu metot verilen isme sahip bir rolü bulmak için kullanılır.

Genellikle bu tür metotlar, kullanıcı oturum açma ve yetkilendirme sistemlerinde kullanılır.
Örneğin, bir kullanıcının hangi rolleri (veya yetkileri) olduğunu belirlemek için bu metot kullanılabilir.
Eğer bir kullanıcı "ADMIN" rolüne sahipse, o kullanıcının yönetici yetkilerine sahip olduğunu anlayabilirsiniz.

Bu metot, veritabanı veya başka bir kaynak üzerinde arama yaparken kullanılır ve sonuç olarak belirli bir isme sahip bir rol döndürür.
 Eğer belirtilen isme sahip bir rol bulunmazsa, genellikle null veya başka bir uygun değer döndürülür.
 Kullanıcıların sistemdeki rollerini doğru bir şekilde yönetmek ve yetkilendirmek için bu tür metotlar önemlidir.
     */
}
