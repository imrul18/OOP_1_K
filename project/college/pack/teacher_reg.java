package college.pack;

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

public  class teacher_reg 
{
	public teacher_reg(String user)
	{
	JFrame c=new JFrame("Registration");
	
    JLabel l_name=new JLabel("Name");
	JLabel l_pass=new JLabel("Password");
	JLabel ss=new JLabel("        ");
	JLabel l_subject=new JLabel("Subject");
	
      JTextField t_name=new JTextField(20);
      JPasswordField t_pass=new JPasswordField(20);
	  
	String subjectList[]={"BANGLA","ENGLISH","MATH"};        
     JComboBox CB_subject=new JComboBox(subjectList);    
	CB_subject.setSelectedIndex(0);
	
		
      JButton button=new JButton("Register");

 button.addActionListener(new ActionListener()
 {
        public void actionPerformed(ActionEvent e)
        {
             databaseClass ob=new databaseClass();
			 
	
                String pwd=new String(t_pass.getPassword());
	if (isNullOrEmpty(t_name.getText())||isNullOrEmpty(CB_subject.getSelectedItem().toString())||isNullOrEmpty(pwd))
	 { 
   JOptionPane.showMessageDialog(null, "Please Enter All Values","OK",JOptionPane.INFORMATION_MESSAGE);
	 }
	else
	{	
	ob.teacher_reg(t_name.getText(), CB_subject.getSelectedItem().toString(),pwd);
	 JOptionPane.showMessageDialog(null, "Registration Successful","OK",JOptionPane.INFORMATION_MESSAGE);
	c.dispose();
	
		new adminAccount(user);
	}

        }
 }		);
		
		c.getContentPane().setBackground(Color.CYAN);
	
		c.add(l_name);
		c.add(t_name);
		c.add(l_subject);
		c.add(CB_subject);
		c.add(ss);
        c.add(l_pass);
        c.add(t_pass);
        c.add(button);
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.setVisible(true);
        c.setSize(220,600);   
	}
    public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }	
}
