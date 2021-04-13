package college.pack;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public  class student_reg
{
	public student_reg(String user)
	{
	JFrame c=new JFrame("Registration");
	
    JLabel l_name=new JLabel("Name");
	JLabel l_fname=new JLabel("Father's Name");
    JLabel l_mname=new JLabel("Mother's Name");
    JLabel l_tname=new JLabel("Class Teacher ID");
	JLabel l_pass=new JLabel("Password");
	JLabel l_year=new JLabel("Passing Year");
	
    JTextField t_name=new JTextField(20);
	JTextField t_fname=new JTextField(20);
	  JTextField t_mname=new JTextField(20);
	  JTextField t_tname=new JTextField(20);
	  JPasswordField t_pass=new JPasswordField(20);
	  JTextField t_year=new JTextField(20);
	  
		
      JButton button=new JButton("Register");

 button.addActionListener(new ActionListener()
 {
        public void actionPerformed(ActionEvent e)
        {
             databaseClass ob=new databaseClass();

                String pwd=new String(t_pass.getPassword());
	if (isNullOrEmpty(t_name.getText())||isNullOrEmpty(t_fname.getText())||isNullOrEmpty(t_mname.getText())||isNullOrEmpty(t_tname.getText())||isNullOrEmpty(pwd)||isNullOrEmpty(t_year.getText()))
	{ 
    JOptionPane.showMessageDialog(null, "Please Enter All Values","OK",JOptionPane.INFORMATION_MESSAGE);
	}
	else
	{	
	ob.student_reg(t_name.getText(),t_fname.getText(),t_mname.getText(),t_tname.getText(),t_year.getText(),pwd);
	c.dispose();
	JOptionPane.showMessageDialog(null, "Reg. Successfull!","Success!!",JOptionPane.INFORMATION_MESSAGE);
			new adminAccount(user);
	}

        }
 });
		
		c.getContentPane().setBackground(Color.CYAN);
		c.add(l_name);
		c.add(t_name);
		c.add(l_fname);
		c.add(t_fname);
		c.add(l_mname);
		c.add(t_mname);
		c.add(l_tname);
		c.add(t_tname);
		c.add(l_pass);
		c.add(t_pass);
		c.add(l_year);
		c.add(t_year);
		
        c.add(button);
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.setVisible(true);
        c.setSize(300,600);   
	}
    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }	
}