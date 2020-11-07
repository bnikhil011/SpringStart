package doa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.User;

public class Userdata implements Serializable {
	
	private  Collection <User> UserList = new ArrayList();
	
	
	
	
	public boolean addUser(User user)
	{
		try {
			this.UserList.add(user);
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
		for (User user : this.UserList)
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
		for (User exixuser : this.UserList)
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
		if(this.UserList.isEmpty())
		{
			System.out.println("List is Empty");
			return null;
		}
		return (List)this.UserList;
	}
	

}
