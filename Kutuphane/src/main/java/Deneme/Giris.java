package Deneme;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Giris extends HttpServlet{
	String adlari;
	String sayilari;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String ad = req.getParameter("Ad");
	String soyad = req.getParameter("Soyad");


	
	String tip = req.getParameter("tip");

	if (tip.equals("yonetici")) {

		if (ad.equals("admin") && soyad.equals("123")) {
			req.getSession().setAttribute("login", "true");
			resp.sendRedirect("kayit.html");
						
		} else {

			req.getSession().setAttribute("login", "false");
			resp.sendRedirect("index.html");
		}
	}
	
	
	if (tip.equals("kullanici")) {

		if (ad.equals("admin") && soyad.equals("123")) {
			req.getSession().setAttribute("login", "true");
			resp.sendRedirect("kullanici.jsp");

		} else {

			req.getSession().setAttribute("login", "false");
			resp.sendRedirect("index.html");
		}
	}
	

}
}
