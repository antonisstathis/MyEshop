package myeshop;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/home")
public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public MyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String signInPage = "";
		
		PageBuilder page = new PageBuilder();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		signInPage = page.createFinalSignInPage("");
		out.println(signInPage);
		out.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}