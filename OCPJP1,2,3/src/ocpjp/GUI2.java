
package ocpjp;//Use package and import statements
//Identify when and how to apply abstract classes
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//Create top-level 
@SuppressWarnings("serial")
public class GUI2 extends JFrame{//Choose between interface inheritance and class inheritance
	
	private static JTextField tf,tf1,tf2,tf3,tf4;
	private JButton B1;
	private JLabel L1,L2,L3,L4;
	static String ID,name,surname,address;
	
	static Icon x = new ImageIcon("SAPS.png");
        static Icon b = new ImageIcon("new-crime-logo-Small.png");
        
	public String toString(){
            
            return "Name : "+name +" Surname : "+ surname+" Address : "+address+" ID no : "+ID;
        }
		 GUI2(){
			
			super("SAPS");
			setLayout(new FlowLayout());
			
			tf = new JTextField();
			tf.setColumns(10);
			tf.setText("RECORD HOLDER");
			tf.setForeground(Color.RED);
			tf.setBackground(Color.BLUE);
			tf.setEditable(false);
			tf.setAlignmentX(JFrame.TOP_ALIGNMENT);
			add(tf);
			//JPanel P1 = new JPanel((LayoutManager) x);
			//P1.setSize(100,100);
			//add(P1);
			L1 = new JLabel("ID");
			L1.setBounds(100, 200, 100, 200);
			//P1.setVisible(true);
			add(L1);
			tf1 = new JTextField();		
			tf1.setColumns(13);
			tf1.setToolTipText("ID Number");	
			tf1.setFont(new Font("Serif",Font.BOLD,12));
			tf1.setCaretColor(Color.RED);
			add(tf1);
			
			L2 = new JLabel("Name");
			L2.setBounds(150, 300, 150, 300);	
			L2.setAlignmentX(150);
			L2.setAlignmentY(300);
		
			add(L2);
			
			tf2 = new JTextField();		
			tf2.setColumns(10);
			tf2.setToolTipText("Enter Name Here");	
			tf2.setFont(new Font("Serif",Font.ITALIC,12));
			tf2.setCaretColor(Color.RED);
			add(tf2);
			
			L3 = new JLabel("Surname");		
			add(L3);
			
			tf3 = new JTextField();		
			tf3.setColumns(10);
			tf3.setToolTipText("Enter Surname Here");	
			tf3.setFont(new Font("Serif",Font.ITALIC,12));
			tf3.setCaretColor(Color.RED);			
			add(tf3);
			
			L4 = new JLabel("Address");
			L4.setAlignmentX(RIGHT_ALIGNMENT);		
			add(L4);
			
			tf4 = new JTextField();		
			tf4.setColumns(10);
			tf4.setToolTipText("Enter Address Here");	
			tf4.setFont(new Font("Serif",Font.ITALIC,12));
			tf4.setCaretColor(Color.RED);
			add(tf4);
			
			B1 = new JButton("Submit",x);
            B1.setRolloverSelectedIcon(b);
			B1.setToolTipText("Enter Button");				
			add(B1);	
		
		/*P1.setBackground(Color.RED);
		P1.setAlignmentX(800);
		P1.setAlignmentY(600);*/

		Handle han = new Handle();
		B1.addActionListener(han);
		
		//super.getContentPane().add(P1);
		}
	/*Use access modifiers: 
		private
		Create nested classes*/
		private class Handle implements ActionListener{//Write code that declares, implements and/or extends interfaces

			@Override
			public void actionPerformed(ActionEvent event) {		
				
				JOptionPane.showMessageDialog(null, String.format("Loading Database...\n"
						+"Adding Information...", event.getActionCommand()));
			
				try{
				ID = tf1.getText();//Common coupling 
				name = tf2.getText();
				surname = tf3.getText();
				address = tf4.getText();
				ToDB.Store();//Use virtual method invocation
				}catch(NullPointerException e){
					JOptionPane.showMessageDialog(null, "There Were Some Empty Fields");			
				}
		}	
	}
}
