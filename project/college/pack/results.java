
package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class results
{	
    Connection con;
    Statement stat;
	
	public results()
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
 
	public void result(String ID,String user)
	 {	 
    JFrame f=new JFrame("Result");
	
	JLabel l_0=new JLabel("Course");
	l_0.setBounds(40,5,200,40);
	JLabel la_0=new JLabel("Teacher ID");
	la_0.setBounds(180,5,200,40);
	JLabel lab_0=new JLabel("Number");
	lab_0.setBounds(300,5,200,40);

	JLabel l_1=new JLabel("1");
	l_1.setBounds(40,50,200,40);
	JLabel l_2=new JLabel("11");
	l_2.setBounds(40,100,200,40);
    JLabel l_3=new JLabel("111");
	l_3.setBounds(40,150,200,40);
	
	
	JLabel la_1=new JLabel("2");
	la_1.setBounds(180,50,200,40);
	JLabel la_2=new JLabel("22");
	la_2.setBounds(180,100,200,40);
    JLabel la_3=new JLabel("222");
	la_3.setBounds(180,150,200,40);

	JLabel lab_1=new JLabel("3");
	lab_1.setBounds(300,50,200,40);
	JLabel lab_2=new JLabel("33");
	lab_2.setBounds(300,100,200,40);
    JLabel lab_3=new JLabel("333");
	lab_3.setBounds(300,150,200,40);


	JButton b4=new JButton("Home");
	b4.setBounds(150,320,100,40);
	try {

	int j=0;
	String[] s=new String[300];
	String sql="select * from student_course where st_id='"+ID+"'";
    ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){ 
			s[j]=rs.getString(2);
			s[j+1]=rs.getString(3);
			s[j+2]=rs.getString(4);
			j=j+3;
			}
			
			l_1.setText(s[0]);
			la_1.setText(s[1]);
			lab_1.setText(s[2]);
			l_2.setText(s[3]);
			la_2.setText(s[4]);
			lab_2.setText(s[5]);
			l_3.setText(s[6]);
			la_3.setText(s[7]);
			lab_3.setText(s[8]);
			
	
	}
	catch (Exception e)		{System.out.println(e);}
	

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
		f.add(l_1);
		f.add(la_1);
		f.add(lab_1);
		f.add(l_2);
		f.add(la_2);
		f.add(lab_2);
		f.add(l_3);
		f.add(la_3);
		f.add(lab_3);
		f.add(l_0);
		f.add(la_0);
		f.add(lab_0);
		
	f.add(b4);
    f.setSize(600,550);
    f.setLayout(null);
    f.setVisible(true);
	
	}

}