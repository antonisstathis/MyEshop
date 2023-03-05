package myeshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/ProcessData")
public class ProcessData extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Database database;   
    
    public ProcessData() {
        super();
        database = new Database();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean checkEmail = false;
		String htmlCode = "";
		String htmlCode1 = "";
		char htmlCode2 = '"';
		String htmlCode3 = "";
		char htmlCode4 = '"';
		String htmlCode5 = "";
		String jsCode = "";
		PageBuilder page = new PageBuilder();
		String htmlPage = "";
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String tel = request.getParameter("tel");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = new Customer(name,surname,tel,city,address,zipcode,email,password);
		
		database.connectToDatabase();
		try {
			checkEmail = database.insertCustomer(customer);
			database.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(checkEmail) {
			
			page.setMessage("Email already given.");
			htmlPage = page.createSignUpPage();
						
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println(htmlPage);
			out.flush();
		}
		else  {
			page.setMessage("Your account was successfully created.");
			htmlPage = page.createSignUpPage();
						
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println(htmlPage);
			out.flush();
		}
		
		//getServletContext().getRequestDispatcher(url).forward(request,response);
	}

}
