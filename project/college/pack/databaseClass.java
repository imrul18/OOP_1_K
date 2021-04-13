
   
package college.pack;

import java.sql.*;

public class databaseClass
{ 
    Connection con;
    Statement stat;
    ResultSet rs;
	public databaseClass()
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

   	public void uploadresult(String ID,String number, String user)
    {
        try {    

			String fnumber="update student_course set c_result='"+number+"' where st_id='"+ID+"' and t_id='"+user+"'";
			stat.executeUpdate(fnumber);
			
        } catch (Exception e) {
            System.out.println("error while insrting: "+e);           
        }
}

    public void student_reg(String name,String fname,String mname,String tname, String tyear, String pass)
    {
        try {        
			 String sql="begin student_reg('"+name+"','"+fname+"','"+mname+"','"+tname+"','"+tyear+"','"+pass+"'); end;";		
            stat.executeUpdate(sql);
			
        } catch (Exception e) {
            System.out.println("error while insrting: "+e);       
        }
}

    public void teacher_reg(String name,String sub, String pass)
    {
        try {        
			 String sql="begin teacher_reg('"+name+"','"+sub+"','"+pass+"'); end;";		
            stat.executeUpdate(sql);
			
        } catch (Exception e) {
            System.out.println("error while insrting: "+e);       
        }
}

    public void bonus(String user)
    {
        try {    
            

			String knumber="begin BONUS('"+user+"'); end;";
			stat.executeUpdate(knumber);
			
        } catch (Exception e) {
            System.out.println("error while insrting: "+e);           
        }
}

    public void changepassword(String ID,String Pass)
    {
        try {      
			String sqld= "update login set password='"+Pass+"' where user_id='"+ID+"'";		
            stat.executeUpdate(sqld);
        } catch (Exception e) {
            System.out.println("error while insrting: "+e);           
        }
}
    public void deleteaccount(String ID)
    {
        try {      
			String sqld= "update login set STATUS='DEACTIVE' where user_id='"+ID+"'";		
            stat.executeUpdate(sqld);
        } catch (Exception e) {
            System.out.println("error while insrting: "+e);           
        }
}

    public Boolean checkLogin(String uname,String pwd)
    {
        try {        
			 
            
			String sqllogin= "select * from login where USER_ID='"+uname+"' and PASSWORD='"+pwd+"' and STATUS='ACTIVE'"; 	

            rs=stat.executeQuery(sqllogin);
            if(rs.next())
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            System.out.println("error while validating: "+e);
            return false;
        }
    }
}