package Deneme;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Connection c = null;
	Statement stmt = null;

	try {
		Class.forName("org.postgresql.Driver");
		c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test_db", "postgres", "123");
		c.setAutoCommit(false);
		System.out.println("Baðlantý Baþarýlý");
		stmt = c.createStatement();

		

		String ids = req.getParameter("Ids");
		 String dlt="DELETE FROM public.calisan WHERE Id=" + ids + ";";
		  
		  stmt.executeUpdate(dlt);
		


		
		
		c.commit();
		c.close(); 

	} catch (Exception e) {

		System.out.println(e.getClass().getName() + " " + e.getMessage());
	}
}
}
