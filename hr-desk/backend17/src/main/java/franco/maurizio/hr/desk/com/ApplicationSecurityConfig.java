package franco.maurizio.hr.desk.com;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import franco.maurizio.hr.desk.com.service.LoginService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {

	@Autowired
	private LoginService loginService;
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationSecurityConfig.class);

	
	private static final String API_URL_PATTERN = "/api/v1/role/";
	
//	@Bean
//    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http,
//                                                      HandlerMappingIntrospector introspector) throws Exception {
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
//
//        http.csrf(csrfConfigurer ->
//                csrfConfigurer.ignoringRequestMatchers(mvcMatcherBuilder.pattern(API_URL_PATTERN),
//                        PathRequest.toH2Console()));
//
//        http.headers(headersConfigurer ->
//                headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
//
//        http.authorizeHttpRequests(auth ->
//                auth
//                        .requestMatchers(mvcMatcherBuilder.pattern(API_URL_PATTERN)).permitAll()
//                        //This line is optional in .authenticated() case as .anyRequest().authenticated()
//                        //would be applied for H2 path anyway
//                        .requestMatchers(PathRequest.toH2Console()).permitAll()
////                        .anyRequest().authenticated()
//        );
//
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
	
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	logger.info("a XXXXXXXXXXXXXXX:" + PathRequest.toH2Console()); 
    	
    	
    	
        http.httpBasic(withDefaults()).authorizeHttpRequests(requests -> requests
        		.requestMatchers(HttpMethod.GET, "/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/user/").permitAll()//to allow registration????
                .requestMatchers(HttpMethod.GET, "/api/v1/user/email/**").permitAll()//to allow login
                .requestMatchers(HttpMethod.GET, "/api/v1/survey/getSurveyForCandidate/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/surveyreplyrequest/start/").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/v1/surveyreplyrequest/end/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/application/info/").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/pdf/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/role/").authenticated()
                .requestMatchers(HttpMethod.GET, "/api/v1/coursepagecustom").authenticated()
                .requestMatchers(HttpMethod.GET, "/api/v1/positionuserowner").authenticated()
                .requestMatchers(HttpMethod.PATCH, "/api/v1/user/**").authenticated()
                .requestMatchers(HttpMethod.GET, "/api/v1/**/**").authenticated()
                .requestMatchers(HttpMethod.POST, "/api/v1/**/**").authenticated()
                .requestMatchers(HttpMethod.POST, "/api/v1/coursepage/createcoursepagecustom").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/v1/**/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/v1/**/**").authenticated()
                .requestMatchers(HttpMethod.GET, "/api/v1/role/level/**").authenticated()
            ).csrf(csrf -> csrf.disable());
        //security configuration for h2 console
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions().disable());
        return http.build();
	}
    
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().
//                requestMatchers(new AntPathRequestMatcher("/h2-console/**"))
//                ;
//    }
    
//    public static final String API_URL_PATTERN = "/h2-console/*" ;
//    
//    @Bean
//    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http,
//                                                      HandlerMappingIntrospector introspector) throws Exception {
//        MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
//
//        logger.info("XXXXXXXXXXXXXXX:" + PathRequest.toH2Console());
//        http.csrf(csrfConfigurer ->
//                csrfConfigurer.ignoringRequestMatchers(mvcMatcherBuilder.pattern(API_URL_PATTERN),
//                        PathRequest.toH2Console()));
//
//        http.headers(headersConfigurer ->
//                headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));
//
//        http.authorizeHttpRequests(auth ->
//                auth
//                        .requestMatchers(mvcMatcherBuilder.pattern(API_URL_PATTERN)).permitAll()
//                        //This line is optional in .authenticated() case as .anyRequest().authenticated()
//                        //would be applied for H2 path anyway
//                        .requestMatchers(PathRequest.toH2Console()).authenticated()
//                        .anyRequest().authenticated()
//        );
//
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {		
//		http.authorizeRequests().antMatchers("/api/v1/**/").permitAll()
//		                        .antMatchers("/api/v1/**").permitAll()
//		                        .antMatchers("/api/v1/**/**").permitAll()
//		                        .and().csrf().disable().cors();
//	}
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		logger.info("SpringSecurityConfiguration_Database.configureGlobal - START");
		auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	      CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(Arrays.asList("*"));
			config.setAllowedMethods(Arrays.asList("*"));
			config.setAllowedHeaders(Arrays.asList("*"));
			config.setAllowCredentials(true);
	      config.applyPermitDefaultValues();
	      
	      source.registerCorsConfiguration("/api/v1/**", config);
	      source.registerCorsConfiguration("/**", config);
	      source.registerCorsConfiguration("/user", config);
	      return source;
	}	
	
}






















