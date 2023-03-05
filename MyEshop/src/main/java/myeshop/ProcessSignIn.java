package myeshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProcessSignIn")
public class ProcessSignIn extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Database database;
       
    public ProcessSignIn() {
        super();
        database = new Database();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String signInPage = "";
		String[] data = {null,null,null}; // name,surname,password
		
		String email = request.getParameter("email");
		String passwordForm = request.getParameter("password");
		PageBuilder page = new PageBuilder();
		
		database.connectToDatabase();
		try {
			data = database.searchEmail(email);
			if(data != null) {
				System.out.println("Email found: correct password = " + data[2] + " password given = " + passwordForm);
			}
			else {
				signInPage = page.createFinalSignInPage("Email wasn't found!");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println(signInPage);
				out.flush();
				System.out.println("Email wasn't found.");
			}
			database.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(data != null && passwordForm != null) {
			if(data[2].equals(passwordForm)) {
				System.out.println("login successful");
				page.setUserMsg(data[0] + " " + data[1] + " signed in"); // name:data[0] surname:data[1]
				signInPage = page.createSignedInPage();
				
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println(signInPage);
				out.flush();
			}
			else {
				signInPage = page.createFinalSignInPage("Wrong password!");
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println(signInPage);
				out.flush();
				System.out.println("Wrong password.");
			}
		}
		else {
			if(data != null)
				System.out.println("Wrong password");
		}
		
		//getServletContext().getRequestDispatcher(url).forward(request,response);
	}

}
