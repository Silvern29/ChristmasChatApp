//package at.redlinghaus.config;
//
//import at.redlinghaus.security.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//@EnableWebSecurity
//@ComponentScan("at.redlinghaus")
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Bean
//    public AccessDeniedHandler accessDeniedHandler() {
//        return new CustomAccessDeniedHandler();
//    }
//
//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() {
//        return new CustomLogoutSuccessHandler();
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler loginSuccessHandler() {
//        return new CustomLoginSuccessHandler();
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        final DaoAuthenticationProvider bean = new CustomDaoAuthenticationProvider();
//        bean.setUserDetailsService(customUserDetailsService);
//        bean.setPasswordEncoder(encoder());
//        return bean;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/index", "/authenticate")
//                .permitAll()
//                .antMatchers("/secured/**/**", "/secured/**/**/**", "/secured/socket", "/secured/success")
//                .authenticated()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login").permitAll()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginProcessingUrl("/authenticate")
//                .successHandler(loginSuccessHandler())
//                .failureUrl("/denied").permitAll()
//                .and()
//                .logout()
//                .logoutSuccessHandler(logoutSuccessHandler())
//                .and()
//                /**
//                 * Applies to User Roles - not to login failures or unauthenticated access attempts.
//                 */
//                .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler())
//                .and()
//                .authenticationProvider(authenticationProvider());
//    }
//
//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}pass") // Spring Security 5 requires specifying the password storage format
//                .roles("USER");
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/resources/**");
//    }
//}