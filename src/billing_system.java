import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class billing_system {

	public static String url="jdbc:postgresql://localhost:5432/test2";
    public static String user="postgres";
    public static String password="12345678";
    
    Scanner scnr = new Scanner(System.in);
    
    public static void main(String[] argv) {

        boolean login=false;
    	Scanner scnr = new Scanner(System.in);
    	System.out.print(" Enter the Username: ");
        String userName=scnr.nextLine();
        
        System.out.print(" Enter the password: ");
        String password=scnr.nextLine();
        
    	if(userName.equals("user") && password.equals("12345678")) {
    		System.out.println("logged in");
            login=true;
    	} else {
    		System.out.print(" Invalid ");
    	}
    if(login==true) {    
    try {
    		Connection connection = DriverManager.getConnection(url, user, password);
    		Statement stmt= connection.createStatement();
                	
    		boolean log = true;
        	while(log) {
        		Scanner scnr1 = new Scanner(System.in);
        		Connection conn1 = DriverManager.getConnection(url,user,password);
                PreparedStatement stmt1 = conn1.prepareStatement("INSERT INTO test2 (Pid, Pname, Price) VALUES (?, ?, ?)");
                  
        		System.out.println("Enter the 6 digit product id : ");
        		stmt1.setInt(1, scnr1.nextInt());
               
                Scanner scnr2 = new Scanner(System.in);
                System.out.println("Enter the product name : ");
                stmt1.setString(2, scnr2.nextLine());

                System.out.println("Enter the product price : ");
                stmt1.setInt(3, scnr1.nextInt());
                
                stmt1.executeUpdate();
                stmt1.close();
                
                System.out.println("Insert 1 to add products \nPress other key to exit ");
                int temp=scnr1.nextInt();
                
                if(temp!=1)
                {
                	log = false;
                }
        	}
        } catch (Exception exc) {
            System.out.println(exc);
        }
    try
    {
  	  Connection conn4=DriverManager.getConnection(url, user, password);
  	  Statement stmt5=conn4.createStatement();
  	  stmt5.execute("select * from test2");
  	  ResultSet rs=stmt5.getResultSet();
  	  int sum=0;
  	  System.out.println("Pid\tPname\tPrice");
  	  while(rs.next())
  	  {
  		  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
  		  sum=sum+rs.getInt(3);
  	  }
  	System.out.println("Total Price \t "+ sum);
    }
    catch(Exception ex)
    {
  	  System.out.println(ex);
    }
    }
   }
}


