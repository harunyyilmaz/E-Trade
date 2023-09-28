package kodlama.io.E.Trade.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret")
    // ${jwt.secret} ifadesi, yapılandırma dosyasındaki jwt.secret adlı bir özelliğin değerini çekmek için kullanılır.
    // Örneğin, eğer application.properties dosyanızda aşağıdaki gibi bir yapılandırma varsa:
    // Ve @Value("${jwt.secret}") kodunu bir Spring bileşeninde kullanıyorsanız,
    // jwt.secret özelliğinin değeri (mySecretKey) bu bileşenin ilgili alanına veya metot parametresine otomatik olarak enjekte edilecektir.
    //Yani, bu kod, JWT (JSON Web Token) ile ilgili gizli bir anahtarı almak için kullanılır. JWT'ler,
    // kimlik doğrulama ve yetkilendirme gibi güvenlik işlemlerinde sıklıkla kullanılır
    // ve bu anahtar genellikle JWT'leri oluşturmak ve doğrulamak için kullanılır.
    private String secret;

    public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
        return JWT.create() // JWT oluşturma işlemini başlatır.
                .withSubject("User Details")  // JWT'nin konusunu belirtir
                .withClaim("email", email) // JWT içinde özel bir talep (claim) ekler, bu talep e-posta adresini içerir
                .withIssuedAt(new Date()) // JWT'nin verildiği tarihi ekler
                .withIssuer("ALLIANZ")// JWT'nin yayıncısını belirtir
                .sign(Algorithm.HMAC256(secret));//JWT'yi gizli bir anahtarla imzalar  Son olarak, imzalanmış JWT'yi bir dize olarak döndürür.
    }

    public String validateTokenAndRetrieveSubject(String token) throws JWTVerificationException {
        //validateTokenAndRetrieveSubject metodu, verilen bir JWT'yi doğrular ve JWT içeriğinden e-posta adresini çıkarır. İşte bu kodun ne yaptığı:
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret)) // JWT doğrulama işlemini başlatır. Bu işlem, JWT'nin gizli anahtarla doğrulama gereksinimlerini belirtir.
                .withSubject("User Details") // JWT'nin konusunu kontrol eder
                .withIssuer("ALLIANZ") // JWT'nin yayıncısını kontrol eder
                .build(); //  Bu satır, JWTVerifier nesnesini tamamlar ve doğrulayıcıyı oluşturur


        DecodedJWT jwt = verifier.verify(token);  // DecodedJWT jwt = verifier.verify(token);: Bu satırda, oluşturulan JWTVerifier kullanılarak verilen token adlı JWT doğrulanır.
        // Eğer JWT doğrulama işlemi başarılıysa, doğrulanan JWT bir DecodedJWT nesnesi olarak jwt değişkenine atanır.
        return jwt.getClaim("email").asString();
        //return jwt.getClaim("email").asString();: Bu satırda, doğrulanan JWT içindeki "email" iddiasının değeri çıkarılır ve bir Java String olarak döndürülür.
        // Yani, bu fonksiyon JWT içindeki e-posta adresini alır ve geri döndürür.
    }
}
