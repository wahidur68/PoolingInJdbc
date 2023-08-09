package test;
import java.util.*;
import java.sql.*;
public class Pooling {
	public String dbUrl,uName,pWord;

	public Pooling(String dbUrl, String uName, String pWord) {
		
		this.dbUrl = dbUrl;
		this.uName = uName;
		this.pWord = pWord;
	}
	Vector<Connection> v=new Vector<Connection>();
	public void createConnections() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			while(v.size()<5) {
				System.out.println("Pool is not full....");
				Connection con=DriverManager.getConnection(dbUrl,uName,pWord);
				v.addElement(con);
				System.out.println(con);
			}
			if(v.size()==5)System.out.println("Poll is ful");
		}catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	public synchronized Connection useConnection() {
		Connection con=v.elementAt(0);
		v.removeElementAt(0);
		return con;}
	public synchronized void returnConnection(Connection con) {
		v.addElement(con);
	}
	
}
