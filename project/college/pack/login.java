package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public  class login
{
	public login()
	{
   
	JFrame c=new JFrame("Login");
    JLabel l_name=new JLabel("Username");
	JLabel l_pass=new JLabel("Password");
    
      JTextField t_name=new JTextField(10);
      JPasswordField t_pass=new JPasswordField(10);
      JButton button=new JButton("Login");
	
 button.addActionListener(new ActionListener()
 {
        public void actionPerformed(ActionEvent e)
        {
				databaseClass mydbObj=new databaseClass();
 
                String pwd=new String(t_pass.getPassword());
                String user= new String(t_name.getText());
                if(mydbObj.checkLogin(user, pwd))
                {
					
                    
                    			 
					if(user.length()==5)
						new studentAccount(user);
					else if(user.length()==7)
						new teacherAccount(user);
					else 
						new adminAccount(user);
					c.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",JOptionPane.ERROR_MESSAGE);
                }
        }
 }
		);
		
		
		c.getContentPane().setBackground(Color.CYAN);
       	c.add(l_name);
        c.add(t_name);
        c.add(l_pass);
        c.add(t_pass);
        c.add(button);
        c.setLayout(new FlowLayout());
        c.setVisible(true);
        c.setSize(400,200);   
	}		
}
