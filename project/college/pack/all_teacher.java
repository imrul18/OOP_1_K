
package college.pack;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class all_teacher
{	
    Connection con;
    Statement stat;
	
	public all_teacher()
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
 
	public void showinformation(int m, String user)
	 {	 
    JFrame f=new JFrame("Information");
	
	JLabel l_0=new JLabel("ID");
	l_0.setBounds(40,5,200,40);
	JLabel la_0=new JLabel("NAME");
	la_0.setBounds(180,5,200,40);
	JLabel lab_0=new JLabel("SUBJECT");
	lab_0.setBounds(300,5,200,40);

	JLabel l_1=new JLabel("1");
	l_1.setBounds(40,50,200,40);
	JLabel l_2=new JLabel("11");
	l_2.setBounds(40,100,200,40);
    JLabel l_3=new JLabel("111");
	l_3.setBounds(40,150,200,40);
	JLabel l_4=new JLabel("1111");
	l_4.setBounds(40,200,200,40);
	JLabel l_5=new JLabel("11111");
	l_5.setBounds(40,250,200,40);
	
	
	JLabel la_1=new JLabel("2");
	la_1.setBounds(180,50,200,40);
	JLabel la_2=new JLabel("22");
	la_2.setBounds(180,100,200,40);
    JLabel la_3=new JLabel("222");
	la_3.setBounds(180,150,200,40);
	JLabel la_4=new JLabel("2222");
	la_4.setBounds(180,200,200,40);
	JLabel la_5=new JLabel("22222");
	la_5.setBounds(180,250,200,40);

	JLabel lab_1=new JLabel("3");
	lab_1.setBounds(300,50,200,40);
	JLabel lab_2=new JLabel("33");
	lab_2.setBounds(300,100,200,40);
    JLabel lab_3=new JLabel("333");
	lab_3.setBounds(300,150,200,40);
	JLabel lab_4=new JLabel("3333");
	lab_4.setBounds(300,200,200,40);
	JLabel lab_5=new JLabel("33333");
	lab_5.setBounds(300,250,200,40);

	JButton b5=new JButton("More");
	b5.setBounds(50,320,100,40);

	JButton b4=new JButton("Home");
	b4.setBounds(150,320,100,40);
	try {

	int j=0;
	String[] s=new String[300];
	String sql="select * from teacher_info";
    ResultSet rs = stat.executeQuery(sql);
			while(rs.next()){ 
			s[j]=rs.getString(1);
			s[j+1]=rs.getString(2);
			s[j+2]=rs.getString(3);
			j=j+3;
			}
			
			l_1.setText(s[m]);
			la_1.setText(s[m+1]);
			lab_1.setText(s[m+2]);
			l_2.setText(s[m+3]);
			la_2.setText(s[m+4]);
			lab_2.setText(s[m+5]);
			l_3.setText(s[m+6]);
			la_3.setText(s[m+7]);
			lab_3.setText(s[m+8]);
			l_4.setText(s[m+9]);
			la_4.setText(s[m+10]);
			lab_4.setText(s[m+11]);
			l_5.setText(s[m+12]);			
			la_5.setText(s[m+13]);
			lab_5.setText(s[m+14]);
			
	
	}
	catch (Exception e)		{System.out.println(e);}


		b4.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
					new adminAccount(user);
					f.setVisible(false);
			
		}
	});

	b5.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e) 
		{
				all_teacher ob=new all_teacher();
				ob.showinformation(m+15,user);
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
		f.add(l_4);
		f.add(la_4);
		f.add(lab_4);
		f.add(l_5);
		f.add(la_5);
		f.add(lab_5);
		f.add(l_0);
		f.add(la_0);
		f.add(lab_0);
		
	f.add(b4);
	f.add(b5);
    f.setSize(600,550);
    f.setLayout(null);
    f.setVisible(true);
	
	}

}