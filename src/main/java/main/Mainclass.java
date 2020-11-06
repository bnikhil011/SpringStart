package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import model.User;
import service.UserServiceImp;

public class Mainclass {

	private static Scanner sc = new Scanner(System.in);
	private static UserServiceImp userServiceImp ;
	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("C:\\Users\\WELCOME\\Documents\\workspace-sts-3.9.14.RELEASE\\SpringAgainStart\\src\\main\\resources\\Springconfig.xml"));
		while(true)
		{
			System.out.println("Enter 0 to exit 1 to continue");
			if (sc.nextInt()==0)
				break;
			int action ;
			System.out.println("1 to add user \n2 to delete user \n3 to Update User \n4 to get all User");
			action = sc.nextInt();
			if(action==1)
			{
				User user = factory.getBean("BlankUser",User.class);
				userServiceImp= factory.getBean("Userservice",UserServiceImp.class);
				user = getUserdata(user);
				if(userServiceImp.addUser(user))
					System.out.println("User added Sucessfully");
				
			}
			else if(action==2)
			{
				
			}
			else if (action ==3)
			{
				
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
		
		System.out.println("Enter friend names, 0 to exit ");
		while(true)
		{
			String friend = sc.nextLine();
			if(friend.equals("0"))
				break;
		user.getFriends().add(friend);
		}
		
		return user;
	}

}
