package kodlama.io.E.Trade.dataAccess.abstracts;

import kodlama.io.E.Trade.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long > {

    Optional<User> findByEmail(String email);

    // bir Java programlama dilinde sıkça kullanılan bir veritabanı sorgusu ifadesini temsil eder.
    // Bu ifade genellikle bir JPA (Java Persistence API) veya Spring Data JPA gibi veritabanı erişim çerçeveleri ile ilişkilendirilir.


    /*
    Bu metodun dönüş türüdür. Optional Java 8'den itibaren sunulan bir sınıftır ve bir değerin var olup olmadığını temsil eder.
    Bu durumda, User türünde bir değeri temsil etmek için Optional kullanılmıştır. Optional kullanılmasının nedeni,
     veritabanı sorgusu sonucunda bir sonuç elde edilebileceği gibi elde edilemeyebileceği durumları ele almak içindir. Eğer sonuç bulunursa,
     bu sonuç Optional içinde saklanır ve kullanılabilir.

findByEmail(String email): Bu metodun adıdır ve bir sorgu metodu olarak kullanılır.
Genellikle JPA veya Spring Data JPA tarafından sağlanan dinamik sorgu oluşturma mekanizmalarını kullanarak veritabanından belirli bir kriteri karşılayan nesneleri sorgular.
 Bu özel metot, bir kullanıcının e-posta adresine göre veritabanında bir kullanıcıyı bulmak amacıyla tasarlanmıştır.
  email parametresi, bu amaçla kullanılan arama kriterini temsil eder.

Yani, bu metot, belirli bir e-posta adresine sahip bir kullanıcıyı bulmak için kullanılır ve sonucu Optional içinde döndürür.
Eğer veritabanında böyle bir kullanıcı varsa, Optional içinde bu kullanıcı nesnesi bulunur ve bu nesneye erişebilirsiniz.
Eğer belirtilen e-posta adresine sahip bir kullanıcı bulunmazsa, Optional içi boş olur ve bu durumu ele almak için programınızda gerekli kontrolleri yapabilirsiniz.
     */

}
