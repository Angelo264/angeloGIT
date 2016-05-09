package Assignment09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import Assign9.print;

public class User {
	
	static String name,surname,cellNo,cho;
	static int n;
	//Declare and use an ArrayList of a given type 
	static ArrayList<String> list = new ArrayList<String>();
	static ArrayList<String> list1 = new ArrayList<String>();
	static StringBuilder Buil =  new StringBuilder();
	static StringBuffer Buf = new StringBuffer();
	//java.time.LocalDate
	static LocalDate now = LocalDate.now();	
	//java.time.LocalDateTime
	static LocalTime time;
	static LocalDateTime LDT = LocalDateTime.now();
	//java.time.format.DateTimeFormatter
	static DateTimeFormatter format = DateTimeFormatter.ISO_DATE_TIME;
	static Connection Conec;
	
	public static void UserC() {	
		print L = () -> JOptionPane.showMessageDialog(null,"Create Student Account");
		L.printS();/*Write a simple Lambda expression 
		that consumes a Lambda Predicate expression*/
		try{
		name 	= JOptionPane.showInputDialog("Enter Student's Name");
		surname = JOptionPane.showInputDialog("Enter Student's Surname");
		cellNo	= JOptionPane.showInputDialog("Enter Cellphone Number");
		
		list.add("Name :"+name);
		list.add("Surname :"+surname);	
		list.add("Cellphone :"+cellNo);		
		
		for(String List:list){
			JOptionPane.showMessageDialog(null,"Student Information \n" +List);
		}
		
	}catch(NullPointerException e){
		e.printStackTrace();
	}finally{
		meth();
	}
	}
	

	public static void meth(){
		try{
		//Manipulate data using the StringBuilder class and its methods
		Buil.append(name);
		Buil.append(surname);
		Buil.append(cellNo).delete(10, 20);
		Buf.append(name);		
		Buf.append(cellNo);	
		Buf.append(surname);
		Buf.reverse();
		Buf.setLength(8);
		
		JOptionPane.showMessageDialog(null,"\nYour Username is : "+Buil
		+"\nYour Password is : "+Buf);
		Lo2DB();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Lo2DB();
		}
		}
	
	protected static void Lo2DB(){
		//Creating and manipulating Strings
		String user,pass,query,date;
		user = Buil.toString().toLowerCase();
		pass = Buf.toString().toLowerCase();
		date = now.toString();
		try{			
			DB();
			query = "INSERT INTO `login`.`users` (Username,Password,Creation_Date) VALUES (?, ?, ?)";

			PreparedStatement ins = (PreparedStatement) Conec.prepareStatement(query);
			
			ins.setString(1, user);
			ins.setString(2, pass);
			ins.setString(3, date);
			ins.executeUpdate();
			Conec.close();
			JOptionPane.showMessageDialog(null, "Username & Password"
											+"\nSuccesfully Created");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Start.main(null);
		}
	}
	protected static void DB(){		
		try{
			Conec = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","264356");			
	
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}