package eshop.formation.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import eshop.formation.model.Roles;
import eshop.formation.model.Utilisateur;

public class SecurityUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Utilisateur utilisateur;

	public SecurityUser(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> authorities = utilisateur.getRoles().stream().map(Roles::authority).toList();
				
		return AuthorityUtils.commaSeparatedStringToAuthorityList(String.join(",", authorities.toArray(new String[0])));
	}

	@Override
	public String getPassword() {
		return utilisateur.getPassword();
	}

	@Override
	public String getUsername() {
		return utilisateur.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return !utilisateur.isDisabled();
	}

}
