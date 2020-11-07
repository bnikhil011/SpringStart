package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import model.User;
import service.DataDeserializerandSerilizer;
import service.UserServiceImp;

public class Mainclass {

	private static Scanner sc = new Scanner(System.in);
	private static UserServiceImp userServiceImp ;
	public static void main(String[] args) {
		
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("C:\\Users\\WELCOME\\Documents\\workspace-sts-3.9.14.RELEASE\\SpringAgainStart\\src\\main\\resources\\Springconfig.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("C:\\\\Users\\\\WELCOME\\\\Documents\\\\workspace-sts-3.9.14.RELEASE\\\\SpringAgainStart\\\\src\\\\main\\\\resources\\\\Springconfig.xml");
		userServiceImp = context.getBean("Userservice",UserServiceImp.class);
		
	     while(true)
		{
			System.out.println("Enter 0 to exit 1 to continue");
			if (sc.nextInt()==0)
			{
				sc.nextLine();
				userServiceImp.serializedata();
				break;
			}
			int action ;
			System.out.println("1 to add user \n2 to delete user \n3 to Update User \n4 to get all User");
			action = sc.nextInt();
			sc.nextLine();
			if(action==1)
			{
				User user = context.getBean("BlankUser",User.class);
				
				user = getUserdata(user);
				if(!userServiceImp.isAvilable(user.getUserid()) && userServiceImp.addUser(user))
					System.out.println("User added Sucessfully");
				else
				{
					try {
				
					throw new Exception("User id already exist , User some other id ");
				
					}
					
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
			else if(action==2)
			{	System.out.println("Enter User id of whome u want to delete ");
				String userid = sc.nextLine();
				if (userServiceImp.removeUser(userid))
					System.out.println("User removed sucessfully");
				else
					System.out.println("User doesn't exixt with this id");
			}
			else if (action ==3)
			{	System.out.println("Enter User id of whome u want to update ");
				String userid = sc.nextLine();
				if (userServiceImp.isAvilable(userid))
					{	
						User updateuser = context.getBean("BlankUser",User.class);
						updateuser = getUpdatedUserdata(updateuser);
						userServiceImp.updateUser(updateuser);
						System.out.println("User Updated sucessfully");
					}
				else
					System.out.println("User doesn't exixt with this id");
				
				
			}
			else
			{
				ArrayList<User>  data = (ArrayList)userServiceImp.giveAllUsers();
				for (User us:data)
					System.out.println(us);
				
			}
			
		}

	}
	
	public static User getUserdata(User user)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name");
		user.setName(sc.nextLine());
		
		System.out.println("Enter User id");
		user.setUserid(sc.nextLine());
		
		System.out.println("Enter User password");
		user.setPassword(sc.nextLine());
		
		
		while(true)
		{
			System.out.println("Enter friend userid, 0 to exit ");
			String friend = sc.nextLine();
			if(friend.equals("0"))
				break;
			if(userServiceImp.isAvilable(friend))
				{	try{
						
							user.getFriends().add(friend);
						}
				catch(Exception e) {
				System.out.println(e);
				}
				}
			else
				System.out.println("user not avilable with this user id ");
		}
		
		return user;
	}
	
	public static User getUpdatedUserdata(User user)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter User Name");
		user.setName(sc.nextLine());
		
		System.out.println("Enter User password");
		user.setPassword(sc.nextLine());
		
		System.out.println("Enter friend names, 0 to exit ");
		while(true)
		{
			System.out.println("Enter friend userid, 0 to exit ");
			String friend = sc.nextLine();
			if(friend.equals("0"))
				break;
			if(userServiceImp.isAvilable(friend))
				{	try{
						
							user.getFriends().add(friend);
						}
				catch(Exception e) {
				System.out.println(e);
				}
				}
			else
				System.out.println("user not avilable with this user id");
		}
		
		return user;
	}

}
