package user.dao;

import java.util.List;

import user.model.User;

public interface  IUser{
	
	public void insert(User usuario);
	public void update(User user);
	public void delete(int idUser);
	public List<User>  userGetAll();
	public User userGetById(int idUser);

}
