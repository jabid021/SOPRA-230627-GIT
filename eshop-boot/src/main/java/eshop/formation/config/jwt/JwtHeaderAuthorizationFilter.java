package eshop.formation.config.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import eshop.formation.model.Roles;
import eshop.formation.model.Utilisateur;
import eshop.formation.repo.IUtilisateurRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtHeaderAuthorizationFilter extends OncePerRequestFilter {
	@Autowired
	private IUtilisateurRepository utilisateurRepo;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		String authHeader = request.getHeader("Authorization");
		String token = null;
		
		if (authHeader != null) {
			token = authHeader.substring(7); // On retire "Bearer " qui fait 7 caractères
		}
		
		Optional<String> optUsername = JwtUtil.getUsername(token);
		
		// Si on a le nom d'utilisateur, le jeton est valide
		if (optUsername.isPresent()) {
			String username = optUsername.get();
			
			Utilisateur utilisateur = this.utilisateurRepo.findByUsername(username)
					.orElseThrow(() -> new UsernameNotFoundException("L'utilisateur n'existe pas."));
			
				
				// Simuler la connexion grâce au jeton
				
				// Créer la liste des rôles
				List<GrantedAuthority> authorities = new ArrayList<>();
				
				// Le préfix "ROLE_" permet d'indiquer à SPRING SECURITY qu'il s'agit d'un rôle
				
				for(Roles role : utilisateur.getRoles()) {
					authorities.add(new SimpleGrantedAuthority("ROLE_"+ role.name()));
				}
				
				// Recréer un nouvel Authentication
				Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
				
				// Injecter cet Authentication dans le contexte de sécurité
				SecurityContextHolder.getContext().setAuthentication(authentication);
			
		}
		
		// Important, pour passer à la suite
		filterChain.doFilter(request, response);
	}
}
