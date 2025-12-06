package hu.nje.cukraszda.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig {
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->auth
                        .requestMatchers( // Mindenki jogosult
                            "/css/**",
                            "/fonts/**",
                            "/images/**",
                            "/js/**",
                            "/less/**"
                        ).permitAll()
                        .requestMatchers( // Mindeki jogosult / Oldalak
                                "/",
                                "/index",
                                "/adatbazis",
                                "/login",
                                "/register",
                                "/registering"
                        ).permitAll()
                        // Bejelentkezett felhasználóknak
                        .requestMatchers("/uzenetek").authenticated()
                        // Admin jogosultsággal
                        .requestMatchers(
                                "/admin/**"
                        ).hasRole("ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(form->form
                        .loginPage("/login") // Login oldal
                        .loginProcessingUrl("/logging_in") // POST ide megy a form
                        .defaultSuccessUrl("/", true)
                        .permitAll())
                .logout(logout->logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
