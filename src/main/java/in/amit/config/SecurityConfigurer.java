package in.amit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize
						.requestMatchers("/welcome").permitAll()
						.anyRequest().authenticated()
				)
				.httpBasic(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults());
		return http.build();
	}
    
    @Bean
    InMemoryUserDetailsManager inMemoryUserDetails() {
    	UserDetails amitUser = User.withDefaultPasswordEncoder()
    		.username("amit")
    		.password("testing")
    		.authorities("ADMIN")
    		.build();
    	UserDetails sohanDetails = User.withDefaultPasswordEncoder()
    		.username("sohan")
    		.password("test")
    		.authorities("USER")
    		.build();
    	return new InMemoryUserDetailsManager(amitUser, sohanDetails);
    	
    }
    
    
}
