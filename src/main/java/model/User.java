package model;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	/**
	 * @param name  : User name
	 * @param userid : User id with which user will login
	 * @param passowrd : User password
	 * @param friends : user friends 
	 */
	private String name;
	private String userid;
	private String password;
	private Collection <String> friends = new ArrayList();
	private int num ;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<String> getFriends() {
		return friends;
	}
	public void setFriends(Collection<String> friends) {
		this.friends = friends;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public User(String name, String userid, String password, Collection<String> fiends, int num) {
		super();
		this.name = name;
		this.userid = userid;
		this.password = password;
		this.friends = fiends;
		this.num =num;
	}
	public User(int num)
	{
		this.num = num;
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", userid=" + userid + ", password=" + password + ", fiends=" + friends + ", num="+num+"]";
	}
	
	
	

}
