package doa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.User;

public class Userdata {
	
	private static Collection <User> UserList = new ArrayList();
	public boolean addUser(User user)
	{
		try {
			UserList.add(user);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception occured "+e);
		}
		
		return false;
	}
	
	private boolean removeUser(User user)
	{
		
		return false;
	}
	public boolean updateUser(User user)
	{
		
		return false;
	}
	
	public List giveAllUsers() {
		// TODO Auto-generated method stub
		return (List)UserList;
	}
	

}
