package Baitap.ntu65131861.nguyenhoangluu.SessionWithSS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeHttpRequests(auth->auth
        			.anyRequest().authenticated()
        			)
        	.formLogin(form -> form
        			.loginPage("/login")
        			.permitAll()
        			.defaultSuccessUrl("/home",true)
        			)
        	.logout(logout -> logout
        			.permitAll()
        			.logoutSuccessUrl("/login?logout")
        			)
        	.sessionManagement(session -> session
        			.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
        			.maximumSessions(1)
        			.maxSessionsPreventsLogin(true)
        			);
        return http.build();
    }
}