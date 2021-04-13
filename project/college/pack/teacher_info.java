
package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class teacher_info
{
    Connection con;
    Statement stat;
	public teacher_info()
    {
		
        try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","afnan1821");
               stat=con.createStatement();
           }
        catch (Exception ae) 
        {
            System.out.println("error while connecting: "+ae);
        }
    }
    public void showinformation(String ID, String user)
	 {	 
    JFrame f=new JFrame("Information");
	
	JLabel l_Name=new JLabel("Name:");
	l_Name.setBounds(40,50,200,40);
	JLabel l_fname=new JLabel("Subject Name:");
	l_fname.setBounds(40,100,200,40);
    
	
	
	JLabel la_Name=new JLabel("Invalid");
	la_Name.setBounds(180,50,200,40);
	JLabel la_fname=new JLabel("Invalid");
	la_fname.setBounds(180,100,200,40);
    

	
	JButton b4=new JButton("Home");
	b4.setBounds(150,320,200,40);
	
	try {        
			 
			String sql= "select  * from teacher_info where t_id='"+ID+"'"; 
			
            ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){
			String s1=rs.getString("tname");
			String s2=rs.getString("cname");
			
			la_Name.setText(s1);
			la_fname.setText(s2);
			}
            
        } catch (Exception e)		{System.out.println(e);}

		b4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
			
					if(user.length()==5)
						new studentAccount(user);
					else if(user.length()==7)
						new teacherAccount(user);
					else 
						new adminAccount(user);
					f.setVisible(false);
			
		}
	});

	f.getContentPane().setBackground(Color.CYAN);
		f.add(l_Name);
		f.add(la_Name);
		f.add(l_fname);
		f.add(la_fname);
		
	f.add(b4);
    f.setSize(500,600);
    f.setLayout(null);
    f.setVisible(true);
	
	}

}