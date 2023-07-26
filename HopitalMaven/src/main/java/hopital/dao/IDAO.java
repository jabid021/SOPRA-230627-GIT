package hopital.dao;

import java.util.List;

import hopital.model.Compte;

public interface IDAO<T,K> {

	
	String urlBdd = "jdbc:mysql://localhost:3306/hopital?characterEncoding=UTF-8";
	String loginBdd = "root";
	String passwordBdd = "";
	
	public T findById(K id);
	public List<T> findAll();
	public T insert(T obj);
	public void update(T obj);
	public void delete(K id);
	
}
