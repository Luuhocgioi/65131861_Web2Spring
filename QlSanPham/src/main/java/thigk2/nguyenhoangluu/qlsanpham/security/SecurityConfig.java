package thigk2.nguyenhoangluu.qlsanpham.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() 
                .anyRequest().authenticated()          
            )
            .formLogin(form -> form
                .defaultSuccessUrl("/products", true)   
                .permitAll()                           
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login")             
                .permitAll()
            );
            
        http.csrf(csrf -> csrf.disable()); 

        return http.build();
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); 
    }
}