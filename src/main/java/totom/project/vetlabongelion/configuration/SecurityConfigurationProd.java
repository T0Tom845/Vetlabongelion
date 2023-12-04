package totom.project.vetlabongelion.configuration;


import lombok.RequiredArgsConstructor;
import org.apache.catalina.mbeans.DataSourceUserDatabaseMBean;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


import javax.sql.DataSource;

import java.util.Properties;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@Profile("production")
@Primary
@RequiredArgsConstructor
public class SecurityConfigurationProd {

    @Autowired
    private final DataSource dataSource;
    @Bean
    JdbcUserDetailsManager users(DataSource dataSource)throws Exception{
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
        manager.createUser(User.builder()
                        .username("admin")
                        .password("{noop}pas")
                .build());
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http
                .authorizeHttpRequests((auth ->auth
                        .anyRequest().authenticated())
                )
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

}



