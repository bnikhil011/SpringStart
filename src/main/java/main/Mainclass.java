package main;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import model.User;
import service.UserServiceImp;

public class Mainclass {

	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("C:\\Users\\WELCOME\\Documents\\workspace-sts-3.9.14.RELEASE\\SpringAgainStart\\src\\main\\resources\\Springconfig.xml"));
		User user = factory.getBean("BlankUser",User.class);
		UserServiceImp userServiceImp= factory.getBean("Userservice",UserServiceImp.class);
		user = getUserdata(user);
		if(userServiceImp.addUser(user))
			System.out.println("User added Sucessfully");
		
		System.out.println(user);
		
		

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
