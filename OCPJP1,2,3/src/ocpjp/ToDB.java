package ocpjp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
//IS-A Relationship
abstract class ToDB extends GUI2{//Construct abstract subclasses
	static Connection conect = null;
	 static void DBconect() {
		
		try{
			conect =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gui_crime","root","264356");

		}catch(SQLException e){
			e.printStackTrace();
		JOptionPane.showMessageDialog(null, "Database Unavailable",JOptionPane.MESSAGE_PROPERTY,0);
	}
}

	public static void Store(){
		DBconect();
		try{
		String que;	
		
		que = "INSERT INTO `gui_crime`.`suspect` (suspect_ID,Name,Surname,Address) VALUES (?, ?, ?, ?)";

		java.sql.PreparedStatement add = conect.prepareStatement(que);
		
		add.setString(1, ID);//Apply cohesion, low-coupling, IS-A, and HAS-A principles
		add.setString(2, name);
		add.setString(3, surname);
		add.setString(4, address);
		add.executeUpdate();
		conect.close();
		JOptionPane.showMessageDialog(null, "Information Stored");
		
	}catch(SQLException e){
		JOptionPane.showMessageDialog(null, "Information Storing Error",JOptionPane.MESSAGE_PROPERTY,1);
	
    }finally{
        Printer();      
        }

}
        protected static void Printer(){
        GUI2 G = new GUI2();
        //Use the instanceof operator and casting
        System.out.println("Suspect Information : \n\n" + G);
        System.out.println(G instanceof GUI2);
        //Design a class using a Singleton design pattern
        Single instance = Single.getInstance();//Implicit casting
        instance.print();
        }
}
