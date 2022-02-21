import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test2 {
public static void main(String args[]) throws SQLException
{
	 Connection con;
	 con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","password");  
	con.setAutoCommit(false);

    String sql = "INSERT INTO covid VALUES (?,?,?)";
    PreparedStatement statement = con.prepareStatement(sql);
    int count=0;
    int batchSize = 20;
	try
	{
		//StringBuffer name=new StringBuffer();
		String name=" ";
		int empsalary=0;
		String date=" ";
		String path=("test2");
		//C:\Users\HP\Desktop\Employee.csv
		Scanner input=new Scanner(new File(path));
		
		while(input.hasNextLine())
		{
			
			String line;
			line=input.nextLine();
			
			Scanner data=new Scanner(line);	
			try {	
				while(data.hasNext())
				{
					name +=data.next()+" ";
				
				name=name.trim();
				
				if(data.hasNext())
				{
					empsalary=data.nextInt();
				}
				
				if(data.hasNext())
				{
					date=data.next();
				}
				
				}
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
		System.out.println(name);
		System.out.println(empsalary);
		System.out.println(date);
		
		 statement.setString(1,name );
         statement.setLong(2, empsalary);
         statement.setString(3, date);
         statement.addBatch();
         
         if (count % batchSize == 0) {
             statement.executeBatch();
             con.commit();  
         }
     }

     //statement.executeBatch();
	catch(Exception e)
	{
		System.out.println(e);
	}
}
}
