package net.amentum.niomedic.niogateway;

import feign.Logger;
import feign.RequestInterceptor;
import net.amentum.niomedic.niogateway.exception.ApiErrorDecoder;
import net.amentum.niomedic.niogateway.interceptor.UserFeignClientInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class NioGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(NioGatewayApplication.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("hier_token");
        config.addAllowedHeader("Content-Type");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("OPTIONS");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

    @Configuration
    @EnableResourceServer
    public static class ResourceServiceConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers(
                            "/auth/**","/auth/oauth/**","/auth/oauth/check_token",
                            "/info**",
                            "/messages**",
                            "/refreshsocket**" ,
                            "/message-test" ,
                            "/refreshsocket/**",
                            "/ws/**",
                            "/app/**",
                            "/topic/**",
                            "/user/**",
                            "/hystrix.stream**").permitAll()
                    .antMatchers(HttpMethod.POST,"/users").permitAll()
                    .antMatchers(HttpMethod.GET,"/users/hashPass**").permitAll()
                    .antMatchers(HttpMethod.GET,"/users/recoverPassword**","users/findImageByUsername**").permitAll()
                    .antMatchers(HttpMethod.GET,"/new-user/link**").permitAll()
                    .antMatchers(HttpMethod.GET,"/new-user/find**").permitAll()
                    .antMatchers(HttpMethod.POST,"/users/recoverPassword**").permitAll()
                    .antMatchers(HttpMethod.POST,"/create-new-user**").permitAll()
                    .antMatchers(HttpMethod.GET,"/create-new-user/link**").permitAll()
                    .antMatchers(HttpMethod.GET,"/medicos-auth/obtenerPorEspecialidad**").permitAll()
                    .antMatchers(HttpMethod.GET,"/catalogo-especialidades-auth/findAll**").permitAll()
                    .antMatchers(HttpMethod.GET,"/eventos-auth/search**").permitAll()
                    .antMatchers(HttpMethod.POST,"/eventos**").permitAll()
                    .antMatchers("/sockets**").permitAll()
                    .anyRequest().authenticated().and().csrf().disable()
                    .httpBasic().disable().headers()
                    .frameOptions().sameOrigin();
        }
    }


    @Bean
    public RequestInterceptor getUserFeignClientInterceptor() {
        return new UserFeignClientInterceptor();
    }

    @Configuration
    public class feignConfiguration{
        @Bean
        public ApiErrorDecoder myErrorDecoder() {
            return new ApiErrorDecoder();
        }

        @Bean
        Logger.Level feignLoggerLevel() {
            return Logger.Level.FULL;
        }
    }


}