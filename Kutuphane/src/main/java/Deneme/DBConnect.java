package Deneme;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DBConnect extends HttpServlet {
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

			// String sql="CREATE TABLE CALISAN (ID INT PRIMARY KEY NOT NULL,"
			// + "AD TEXT NOT NULL, SOYAD TEXT NOT NULL,YAS INT NOT NULL, ADRES char(50) ,
			// UCRET REAL)";

			String id = req.getParameter("Id");
			String ad = req.getParameter("Ad");
			String soyad = req.getParameter("Soyad");
			int yas = Integer.parseInt(req.getParameter("Yas"));
			String adres = req.getParameter("Adres");
			int ucret = Integer.parseInt(req.getParameter("Ucret"));

			String sql = " INSERT INTO public.calisan("
			 + "Id, Ad, Soyad, Yas, Adres, Ucret)" 
			 + "VALUES (" + id + ", '" + ad + "', '" + soyad + "', " + yas + ", '" + adres + "'," + ucret + ")";
			
			
 
		
			  stmt.executeUpdate(sql);


			
			
			c.commit();
			c.close(); 

		} catch (Exception e) {

			System.out.println(e.getClass().getName() + " " + e.getMessage());
		}
		
		
     
		
	}
	
	
}
