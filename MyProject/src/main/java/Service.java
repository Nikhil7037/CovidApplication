import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class Service {	
	public void getdata() throws SQLException
	{
		List list=new ArrayList();
			 Connection con;
			 con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/test?useSSL=false","root","Temp@123");  
			con.setAutoCommit(false);	
			 Statement stmt=con.createStatement(); ResultSet
			  rs=stmt.executeQuery("select * from Employee where EmployeeID=2"); 
			 String s=null;
			 String s2,s3=null;
			while(rs.next())
			{
				s=rs.getString("EmployeeID");
			   s2=rs.getString("FirstName");
			   s3=rs.getString("LastName");
			   //s3=rs.getString(s3);
		/*
		 * list.add(s); list.add(s2); list.add(s3);
		 */
			   System.out.println(s);
			   System.out.println(s2);
			   System.out.println(s3);
			}
			//System.out.println(s);
			  //System.out.println(rs.getInt(1));
				 
			 //System.out.println(rs.getString(2)+"  "+rs.getString(1)+" "+rs.getString(3));
			  try { con.close(); }catch(Exception e)
			  { 
				  e.printStackTrace(); }
			  con.close();
			  
	}	
	}

