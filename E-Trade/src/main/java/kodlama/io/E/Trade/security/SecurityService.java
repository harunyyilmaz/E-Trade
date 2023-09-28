package kodlama.io.E.Trade.security;

import kodlama.io.E.Trade.dataAccess.abstracts.UserRepository;
import kodlama.io.E.Trade.entities.concretes.Role;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor                                        // UserDetailsService springframework den geliyor.
public class SecurityService implements UserDetailsService {

    @Autowired
     private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<kodlama.io.E.Trade.entities.concretes.User> user = userRepository.findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with email = " + email);
        } else {
            // Dinamik yetkilendirme
            for (Role role : user.get().getRoles()) { // 'Role' sizin kendi Role sınıfınız olmalı
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName().toUpperCase()));
            }
        }
        return new User(email, user.get().getPassword(), grantedAuthorities);
    }
}
