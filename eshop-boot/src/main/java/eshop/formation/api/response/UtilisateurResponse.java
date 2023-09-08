package eshop.formation.api.response;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

import eshop.formation.model.Roles;
import eshop.formation.model.Utilisateur;

public class UtilisateurResponse {
	private int id;
	private String username;
	private String roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public static UtilisateurResponse convert(Utilisateur utilisateur) {
		UtilisateurResponse response = new UtilisateurResponse();

		// Permer de recopier les infos communes de utilisateur vers response
		BeanUtils.copyProperties(utilisateur, response);

		response.setRoles(String.join(",", utilisateur.getRoles().stream().map(Roles::name).collect(Collectors.toSet())));

		return response;
	}
}
