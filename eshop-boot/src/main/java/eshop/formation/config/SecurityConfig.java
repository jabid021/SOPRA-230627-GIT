package eshop.formation.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import eshop.formation.config.jwt.JwtHeaderAuthorizationFilter;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true) // Activer les annotations PrePost pour les accès
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, JwtHeaderAuthorizationFilter jwtFilter) throws Exception {
		
		// Mise en place des authorisations
		http.authorizeHttpRequests(authorize -> {
//			authorize.requestMatchers("/api/hello").permitAll(); // Autorisé à tout le monde
			authorize.requestMatchers("/api/utilisateur/connexion").anonymous(); // Autorisé à tout le monde

//			authorize.requestMatchers("/api/hello", "/api/utilisateur/**").permitAll(); // Autorisé à tout le monde

			// Les accès seront configurés via les annotations PrePost
//			authorize.requestMatchers("/api/fournisseur/**").hasRole("ADMIN"); // Autotisé aux utilisateurs "admin"

			authorize.requestMatchers("/**").permitAll();
//			authorize.requestMatchers("/**").authenticated(); // Autorisé aux utilisateurs connectés
		});

		// Méthode d'authentification par formulaire HTML
//		http.formLogin(Customizer.withDefaults());

		// Méthode d'authentification par HTTP Basic
		http.httpBasic(Customizer.withDefaults());

		// Désactiver la protection CSRF
		http.csrf(c -> c.disable());

		// Configurer les CORS (Cross-Origine Resources Sharing)
		http.cors(c -> {
			CorsConfigurationSource source = request -> {
				CorsConfiguration config = new CorsConfiguration();

				// On autorise tout le monde
				config.setAllowedOrigins(List.of("*"));

				// On autorise toutes les commandes HTTP (GET, POST, PUT, ...)
				config.setAllowedMethods(List.of("*"));

				// On autorise toutes les en-têtes HTTP
				config.setAllowedHeaders(List.of("*"));

				return config;
			};

			c.configurationSource(source);
		});

		// Positionner le filtre JWT AVANT le filter
		// UsernamePasswordAuthenticationFilter
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		// Désactiver la session utilisateur par cookie, puisque c'est plus utilisé avec
		// JWT
		http.sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		return http.build();
	}
	
	

	// Grace à ce Bean, on pourra injecter un AuthenticationManager directement
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// Pas d'encadage sur les mots de passe - PAS BIEN
//		return NoOpPasswordEncoder.getInstance();

//		System.out.println(new BCryptPasswordEncoder().encode("123456"));

		// Encodage Blowfish
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public static MethodSecurityExpressionHandler methodExpressionHandler(RoleHierarchy roleHierarchy) {
//		DefaultMethodSecurityExpressionHandler hdlr = new DefaultMethodSecurityExpressionHandler();
//		
//		hdlr.setRoleHierarchy(roleHierarchy);		
//		
//		return hdlr;
//	}
//	
	@Bean
	public RoleHierarchy roleHierarchy() {
		String hierarchy = """
					ROLE_SUPER_ADMIN > ROLE_ADMIN
					ROLE_ADMIN > ROLE_USER
				""";
		
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		
		roleHierarchy.setHierarchy(hierarchy);
		
		return roleHierarchy;
	}

//	@Bean
//	public UserDetailsService inMemory() {
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//		// Création d'un utilisateur
//		manager.createUser(User.withUsername("user").password(passwordEncoder().encode("123456")).roles("USER").build());
//
//		// Création d'un administrateur
//		manager.createUser(User.withUsername("admin").password(passwordEncoder().encode("123456")).roles("ADMIN").build());
//
//		return manager;
//	}
	
	
}
