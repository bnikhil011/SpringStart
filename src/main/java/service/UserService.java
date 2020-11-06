package service;

import java.util.List;

import model.User;

public interface UserService {
	
	public boolean addUser(User user);
	public boolean removeUser(User user);
	public boolean  updateUser(User user );
	public List giveAllUsers();

}
