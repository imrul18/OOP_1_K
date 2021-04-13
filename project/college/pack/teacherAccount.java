package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class teacherAccount
{
	public teacherAccount(String ID)
	{	 
        JFrame f=new JFrame("Teacher Account");
		
    JLabel l_ID=new JLabel("Student ID:");
	l_ID.setBounds(150,120,200,40);
		JTextField t_ID=new JTextField();
	t_ID.setBounds(230,120,120,40);
        JButton b1=new JButton("Student Details Info");
	b1.setBounds(150,170,200,40);
		JButton b2=new JButton("Student Result");
	b2.setBounds(150,220,200,40);
        JButton b3=new JButton("Profile");
	b3.setBounds(150,270,200,40);
		JButton b4=new JButton("Upload Result");
	b4.setBounds(150,320,200,40);
		JButton b5=new JButton("Change Password");
	b5.setBounds(150,370,200,40);
	JButton b6=new JButton("Log Out");
	b6.setBounds(150,420,200,40);
        
        b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			student_info ob=new student_info();
			ob.showinformation(t_ID.getText(),ID);
			f.setVisible(false);
		}
	});
        
        b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{        
			results obs=new results();
			obs.result(t_ID.getText(),ID);
			f.setVisible(false);
		}
	});
	
	    b3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			teacher_info ob=new teacher_info();
			ob.showinformation(ID,ID);
			f.setVisible(false);
		}
	});
        
        b4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			new uploadresult(ID);
			f.setVisible(false);
		}
	});
	
		b5.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			new changepass(ID);
			f.setVisible(false);
		}
	});
	
		b6.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			
			new login();
			f.setVisible(false);
			
		}
	});
	
	f.add(l_ID);
	f.add(t_ID);
	f.add(b1);
	f.add(b2);
	f.add(b3);
	f.add(b4);
	f.add(b5);
	f.add(b6);
    f.setSize(500,600);
    f.setLayout(null);
    f.setVisible(true);
	}
}