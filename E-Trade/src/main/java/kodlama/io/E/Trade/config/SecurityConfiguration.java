package kodlama.io.E.Trade.config;

import jakarta.servlet.http.HttpServletResponse;
import kodlama.io.E.Trade.dataAccess.abstracts.UserRepository;
import kodlama.io.E.Trade.security.JWTFilter;
import kodlama.io.E.Trade.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        @Autowired
        private UserRepository userRepo;
        @Autowired
        private JWTFilter filter;
        @Autowired
        private SecurityService uds;

        private static final String[] AUTH_WHITELIST = {
                // ... mevcut beyaz listeler
                "/auth/**",
                "/swagger-ui/**",
                "v3/api-docs/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/v3/api-docs/**",
                "/api/public/**",
                "/api/public/authenticate",
                "/actuator/*",
                "/swagger-ui/**",
                "/tax",
                "/tax/**",
                "/category/**",
                "/category",


        };

        private static final String[] USER_AUTH_WHITELIST = {
                "/user",
                "/customer",
                "/product",
                "/categories",



        };

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.headers().frameOptions().disable();
            http.csrf().disable()
                    .httpBasic().disable()
                    .cors()
                    .configurationSource(request -> {
                        CorsConfiguration configuration = new CorsConfiguration();
                        configuration.setAllowedOrigins(List.of("*"));
                        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                        configuration.setAllowedHeaders(List.of("*"));
                        configuration.setExposedHeaders(List.of("Content-Disposition"));
                        return configuration;
                    }).and()
                    .authorizeHttpRequests()
                    // .requestMatchers("/**").permitAll()
                    .requestMatchers(AUTH_WHITELIST).permitAll() // Whitelist tüm kullanıcılar için erişilebilir
                    .requestMatchers("/user/**", "/categories/**", "/product/**").hasRole("ROLE_USER") // user belirtilen endpointlere erişebilir
                    .requestMatchers("/**").hasRole("ROLE_ADMIN")  // Admin tüm endpointlere erişebilir
                    .requestMatchers("/customer/**", "/categories/**" , "/product/**").hasRole("ROLE_CUSTOMER") // customer belirtilen endpointlere erişebilir
                    .requestMatchers(USER_AUTH_WHITELIST).hasAuthority("ROLE_ADMIN")
                    .and()
                    .userDetailsService(uds)
                    .exceptionHandling()
                    .authenticationEntryPoint((request, response, authException) ->
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                    )
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

            http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
            return authenticationConfiguration.getAuthenticationManager();
        }
}
