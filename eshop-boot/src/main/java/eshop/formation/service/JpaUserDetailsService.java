package eshop.formation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import eshop.formation.model.Roles;
import eshop.formation.model.Utilisateur;
import eshop.formation.repo.IUtilisateurRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

	@Autowired
	private IUtilisateurRepository utilisateurRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur = this.utilisateurRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("L'utilisateur n'existe pas."));

		// Si l'utilisateur n'a pas été trouvé, l'exception sera jetée, et on s'arrêtera
		// là

		UserBuilder userBuilder = User.withUsername(username).password(utilisateur.getPassword())
				.disabled(utilisateur.isDisabled());

		List<String> roles = utilisateur.getRoles().stream().map(Roles::name).toList();

		userBuilder.roles(roles.toArray(new String[0]));

		return userBuilder.build();

//		return new SecurityUser(utilisateur);
	}

}
