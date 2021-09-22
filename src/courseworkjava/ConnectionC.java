package courseworkjava;
																					

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException																				;
import java.sql.Statement																					;

public class ConnectionC 																					{
	
	public Statement connection()																			{
		Connection con;
		Statement stmt=null																					;
		try 																								{
			con = DriverManager.getConnection( "jdbc:mysql://127.0.0.1:3306/java_final","root","wi-fi6@Support")			;
			stmt = con.createStatement()																	;
																											} 
		catch (SQLException e1) 																			{
				
			e1.printStackTrace()																			;
																											}
		return stmt																							;
		
																											}

																											}
