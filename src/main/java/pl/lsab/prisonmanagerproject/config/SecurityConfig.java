package pl.lsab.prisonmanagerproject.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder)throws Exception{
        managerBuilder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("SELECT username, haslo, enable FROM admin WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, 'default' FROM admin WHERE username = ?");
    }
    @Override
    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/app/**").authenticated().anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/logowanie").permitAll()
                .defaultSuccessUrl("/")
                .failureUrl("/logowanie?error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/wylogowanie"))
                .logoutSuccessUrl("/logowanie")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .httpBasic();
    }
}