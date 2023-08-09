package test;
import java.sql.*;
public class DbCon16 {

	public static void main(String[] args) {
		Pooling ob=new Pooling("jdbc:oracle:thin:@localhost:1521:orcl", "system", "wahidur");
		ob.createConnections();
		System.out.println("*******user-1*********");
		System.out.println("pool size : "+ob.v.size());
		Connection c1=ob.useConnection();
		System.out.println(c1);
		System.out.println("pool size : "+ob.v.size());
		
		System.out.println("*******user-2*********");
		System.out.println("pool size : "+ob.v.size());
		Connection c2=ob.useConnection();
		System.out.println(c2);
		System.out.println("pool size : "+ob.v.size());
		
		ob.returnConnection(c1);
		System.out.println("user-1 return the connection");
		System.out.println("pool size : "+ob.v.size());
		
		ob.returnConnection(c2);
		System.out.println("user-2 return the connection");
		System.out.println("pool size : "+ob.v.size());
		
		System.out.println("======Dis connection =========");
		ob.v.forEach((k)->System.out.println(k));
		
		
	}

}
