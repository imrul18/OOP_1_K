package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public  class changepass
{
	public changepass(String user)
	{
   
	JFrame c=new JFrame("Password Change");
    JLabel l_pass=new JLabel("New Pass:");
	l_pass.setBounds(120,70,200,40);
	JPasswordField t_pass=new JPasswordField(10);
		t_pass.setBounds(220,70,140,40);

    JButton button=new JButton("Change");
	button.setBounds(160,120,100,40);
 button.addActionListener(new ActionListener()
 {
        public void actionPerformed(ActionEvent e)
        {
				databaseClass mydbObj=new databaseClass();
				String pwd=new String(t_pass.getPassword());
				
			  	if(pwd.length()<6){
					  JOptionPane.showMessageDialog(null, "Password must be min 6 character","Failed",JOptionPane.INFORMATION_MESSAGE);}
				  else{
					  mydbObj.changepassword(user,pwd);
                    JOptionPane.showMessageDialog(null, "Password Changed!","Successfull!!",JOptionPane.INFORMATION_MESSAGE);
                    			 
					new login();
					c.setVisible(false);
				  }
                
             
                
        }
 }
		);
		
		
		c.getContentPane().setBackground(Color.CYAN);
       	c.add(l_pass);
        c.add(t_pass);
        c.add(l_pass);
        c.add(t_pass);
        c.add(button);
        c.setLayout(new FlowLayout());
        c.setVisible(true);
        c.setSize(400,200);   
	}		
}
