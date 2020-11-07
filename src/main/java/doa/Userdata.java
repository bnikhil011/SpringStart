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
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception occured "+e);
		}
		
		return false;
	}
	
	public  boolean removeUser(String userid)
	{
		for (User user : UserList)
		{
			if(user.getUserid().equals(userid))
				{
					UserList.remove(user);
					return true;
				}
			
		}
		
		return false;
	}
	public boolean updateUser(User user)
	{
		for (User exixuser : UserList)
		{
			if(exixuser.getUserid().equals(user.getUserid()))
				{
					exixuser.setName(user.getName());
					exixuser.setFriends(user.getFriends());
					exixuser.setPassword(user.getPassword());
					
					return true;
				}
		}
		return false;
	}
	
	public List giveAllUsers() {
		if(UserList.isEmpty())
		{
			System.out.println("List is Empty");
			return null;
		}
		return (List)UserList;
	}
	

}
