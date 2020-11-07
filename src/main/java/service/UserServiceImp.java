package service;

import java.util.ArrayList;
import java.util.List;

import doa.Userdata;
import model.User;

public class UserServiceImp implements UserService {
	private Userdata userdata;
	private DataDeserializerandSerilizer dataeder;
	
	public UserServiceImp (DataDeserializerandSerilizer dataeder)
	{
		this.dataeder = dataeder;
		this.userdata = dataeder.getUserdata();
	}

	public boolean addUser(User user) {
		
		return  this.userdata.addUser(user);
	}

	public boolean removeUser(String userid) {
		// TODO Auto-generated method stub
		return this.userdata.removeUser(userid);
	}

	public boolean updateUser(User user) {
		return userdata.updateUser(user);
		
	}

	public List giveAllUsers() {
		// TODO Auto-generated method stub
		return userdata.giveAllUsers();
	}

	public boolean isAvilable(String userId) {
		try{
			ArrayList <User>list = (ArrayList)giveAllUsers();
		
		for(User u:list)
		{
			if(u.getUserid().equals(userId))
				return true;
		}
		}
		catch(Exception e)
		{
			System.out.println("");
		}
		return false;
	}
	
	public void serializedata()
	{
		this.dataeder.dataSerializer(this.userdata);
	}
	

}
