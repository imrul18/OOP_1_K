package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class uploadresult
{
	public uploadresult(String ID)
	{	 
        JFrame f=new JFrame("Upolad Result");
		
		JLabel l_ID=new JLabel("Student ID:");
	l_ID.setBounds(120,70,200,40);
		JTextField t_ID=new JTextField();
	t_ID.setBounds(180,70,140,40);
		JLabel l_Number=new JLabel("Number:");
	l_Number.setBounds(120,120,200,40);
		JTextField t_Number=new JTextField();
	t_Number.setBounds(180,120,140,40);
	
        JButton b1=new JButton("Upload");
	b1.setBounds(120,220,200,40);
		JButton b3=new JButton("Bonus");
	b3.setBounds(120,270,200,40);
		JButton b2=new JButton("Home");
	b2.setBounds(120,320,200,40);
       
	
        
        b1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			databaseClass ob=new databaseClass();
			
         if (isNullOrEmpty(t_ID.getText())||isNullOrEmpty(t_Number.getText()))
		{ 
		JOptionPane.showMessageDialog(null, "Please Enter All Values","OK",JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{	
		ob.uploadresult(t_ID.getText(), t_Number.getText(),ID);
		JOptionPane.showMessageDialog(null, "Upload Successful","OK",JOptionPane.INFORMATION_MESSAGE);
		
	}
		}
	});
        
        b2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
            new teacherAccount(ID);
			f.setVisible(false);
		}
	});

	b3.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			databaseClass obs=new databaseClass();
			obs.bonus(ID);
			
		JOptionPane.showMessageDialog(null, "Done","Done",JOptionPane.INFORMATION_MESSAGE);
			f.setVisible(true);
		}
	});
	
	    
	f.add(l_ID);
	f.add(t_ID);
	f.add(l_Number);	
	f.add(t_Number);
	f.add(b1);
	f.add(b2);
	f.add(b3);
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