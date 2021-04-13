package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class studentAccount
{
	public studentAccount(String ID)
	 {	 
    JFrame f=new JFrame("Student Info");
	
	JButton b1=new JButton("Profile");
	b1.setBounds(150,170,200,40);
	JButton b2=new JButton("Result");
	b2.setBounds(150,220,200,40);
	JButton b3=new JButton("Change Password");
	b3.setBounds(150,270,200,40);
	JButton b4=new JButton("Log Out");
	b4.setBounds(150,320,200,40);
	
	
	b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			student_info ob=new student_info();
			ob.showinformation(ID,ID);
			f.setVisible(false);
		}
	});
	b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			results obs= new results();
			obs.result(ID,ID);
			f.setVisible(false);
			
		}
	});
	
		b3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			new changepass(ID);
			f.setVisible(false);
		}
	});
	
		b4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			new login();
			f.setVisible(false);
			
		}
	});

	f.add(b1);
	f.add(b2);
	f.add(b3);
	f.add(b4);
    f.setSize(500,600);
    f.setLayout(null);
    f.setVisible(true);
	
	}
}