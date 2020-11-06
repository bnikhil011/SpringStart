package service;

import java.util.List;

import doa.Userdata;
import model.User;

public class UserServiceImp implements UserService {
	private Userdata userdata;
	
	public UserServiceImp (Userdata userdata)
	{
		this.userdata = userdata;
	}

	public boolean addUser(User user) {
		
		return  this.userdata.addUser(user);
	}

	public boolean removeUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List giveAllUsers() {
		// TODO Auto-generated method stub
		return userdata.giveAllUsers();
	}
	

}
