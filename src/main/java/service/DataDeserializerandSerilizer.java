package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import doa.Userdata;

public class DataDeserializerandSerilizer {
	private Userdata userdata;

	public DataDeserializerandSerilizer()
	{
	
		
		try {
			File file = new File("C:\\Users\\WELCOME\\Documents\\workspace-sts-3.9.14.RELEASE\\SpringAgainStart\\src\\main\\resources\\data.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.userdata = (Userdata)ois.readObject();
			System.out.println("Data Deserilized sucessfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.userdata = new Userdata();
			e.printStackTrace();
		}
	
		}
	
		
	
	public Userdata getUserdata() {
		return userdata;
	}

	public boolean dataSerializer (Userdata userdata)
	{
		try {
			
				File file = new File("C:\\Users\\WELCOME\\Documents\\workspace-sts-3.9.14.RELEASE\\SpringAgainStart\\src\\main\\resources\\data.txt");
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(this.userdata);
				System.out.println("Data Deserilized sucessfully");
				return true;
			}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
