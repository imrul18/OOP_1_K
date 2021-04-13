package college.pack;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class adminAccount
{
	public adminAccount(String ID)
	{	 
        JFrame f=new JFrame("Admin Account");
        
	JButton b1=new JButton("Create Student Account");
	b1.setBounds(120,50,200,40);
        JButton b2=new JButton("Create Teacher Account");
	b2.setBounds(120,100,200,40);
		JLabel s_ID=new JLabel("Student ID:");
	s_ID.setBounds(120,150,200,40);
		JTextField st_ID=new JTextField();
	st_ID.setBounds(190,150,130,40);
        JButton b3=new JButton("Student Details Info");
	b3.setBounds(120,200,200,40);
		JButton b4=new JButton("Show All Teacher");
	b4.setBounds(120,250,200,40);
		JLabel ta_ID=new JLabel("Teacher ID:");
	ta_ID.setBounds(120,300,200,40);
		JTextField te_ID=new JTextField();
	te_ID.setBounds(190,300,130,40);
        JButton b5=new JButton("Show Teacher Information");
	b5.setBounds(120,350,200,40);
		JLabel l_ID=new JLabel("Student/Teacher ID:");
	l_ID.setBounds(120,400,200,40);
		JTextField t_ID=new JTextField();
	t_ID.setBounds(250,400,70,40);
		JButton b6=new JButton("Delete Student/Teacher account");
	b6.setBounds(120,450,200,40);
		JButton b7=new JButton("Log Out");
	b7.setBounds(120,500,200,40);
	
	
	b1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) 
		{
			new student_reg(ID);
			f.setVisible(false);
            
		}
	});
        
        b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			new teacher_reg(ID);
			f.setVisible(false);
		}
	});
        
        b3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			student_info ob=new student_info();
			ob.showinformation(st_ID.getText(),ID);
			f.setVisible(false);
		}
	});
        
		b4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			all_teacher ob=new all_teacher();
			ob.showinformation(0,ID);
			f.setVisible(false);
            
		}
	});
	
        b5.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			teacher_info ob=new teacher_info();
			ob.showinformation(te_ID.getText(),ID);
			f.setVisible(false);
		}
	});
	
		b6.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(isNullOrEmpty(t_ID.getText()))
			{
			JOptionPane.showMessageDialog(null, "Enter ID!","Failed!!",JOptionPane.INFORMATION_MESSAGE);
			}
			else {
			databaseClass ob=new databaseClass();
			ob.deleteaccount(t_ID.getText());
			
			JOptionPane.showMessageDialog(null, "Delete Account!","Success!!",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	});
	
		b7.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			
			new login();
			f.setVisible(false);
			
		}
	});
	
	f.add(b1);
	f.add(b2);
	f.add(s_ID);
	f.add(st_ID);
    f.add(b3);
	f.add(b4);
	f.add(ta_ID);
	f.add(te_ID);
	f.add(b5);
	f.add(l_ID);
	f.add(t_ID);
	f.add(b6);
	f.add(b7);
    f.setSize(500,600);
    f.setLayout(null);
    f.setVisible(true);
	}
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }
}