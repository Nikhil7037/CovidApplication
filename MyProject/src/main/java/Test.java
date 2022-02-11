import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String args[]) throws SQLException, ClassNotFoundException, IOException,FileNotFoundException
	{
			
	//Class.forName("com.mysql.jdbc.Driver");
 Connection con;
	 con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","Temp@123");  
	con.setAutoCommit(false);

    String sql = "INSERT INTO covid VALUES (?,?,?)";
    PreparedStatement statement = con.prepareStatement(sql);
    
 

	
	String path=("Employee.csv");
	//C:\Users\HP\Desktop\Employee.csv
	BufferedReader lineReader = new BufferedReader(new FileReader(path));
	String lineText = null;
	 int batchSize = 20;
	 int count=0;
	 
     lineReader.readLine();
     while ((lineText = lineReader.readLine()) != null) {
    	 //System.out.println("Hi");
         String[] data = lineText.split(",");
         String EmployeeID = data[0];
         String FirstName = data[1];
         String LastName = data[2];
         
        
       
 
         
         //String sql = "INSERT INTO Employee (EmployeeID, FirstName, LastName) VALUES (?, ?, ?)";
         //PreparedStatement statement = con.prepareStatement(sql);

         statement.setString(1,EmployeeID );
         statement.setString(2, FirstName);
         statement.setString(3, LastName);
         statement.addBatch();
         
         if (count % batchSize == 0) {
             statement.executeBatch();
         }
     }
     lineReader.close();
     //statement.executeBatch();
     con.commit();  
		
		 Statement stmt=con.createStatement(); ResultSet
		  rs=stmt.executeQuery("select * from covid"); 
		 while(rs.next())
		  //System.out.println(rs.getInt(1));
		 System.out.println(rs.getString(2)+"  "+rs.getString(1)+" "+rs.getString(3));
		  try { con.close(); }catch(Exception e)
		  { 
			  e.printStackTrace(); }
		  con.close();
		  
		  

	}
	
	public void read()
     {
    	// List list =new ArrayList();
    	 //list.add(EmployeeID);
		
    	 
     }
}
