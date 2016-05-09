package ocpjp;

import javax.swing.JFrame;

abstract class GUI {//Construct abstract Java classes 
	//Use the static and final keywords
	static final String [] Schedule1 = {"Drunken Driving","Substance(Possesion)","Theft","Robbery","Shoplifting"};
	static final String [] Schedule2 = {"Armed Robbery","Substance(Supplier)","Hi-Jacking","GBH","Unlicensed Fire Arm(Possession)"};
	static final String [] Schedule3 = {"Rape","Attempted Murder","Theft","Robbery","Shoplifting"};
//	static Icon i = new ImageIcon("database_topics.jpg");
	public static void main(String[] args) {
	
		GUI2 go = new GUI2();//Apply object composition principles (including has-a relationships)
		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		go.setSize(1000,1000);	
		go.setVisible(true);	
}
	

}


