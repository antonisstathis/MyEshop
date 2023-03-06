package myeshop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/ProcessData")
public class ProcessData extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public ProcessData() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Model model = new Model();
		String htmlPage = "";
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// The data are here
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String tel = request.getParameter("tel");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Customer customer = new Customer(name,surname,tel,city,address,zipcode,email,password);
		
		// Ask model to process the data and take the conclusion
		PageBuilder page = new PageBuilder();
		String conclusion = model.processSignUpData(customer);
		
		switch(conclusion) {	
			case("Email already given."): 
				page.setMessage("Email already given.");
				htmlPage = page.createSignUpPage();		
				response.setContentType("text/html");
				break;
		
			case("Your account was successfully created."):
				page.setMessage("Your account was successfully created.");
				htmlPage = page.createSignUpPage();		
				response.setContentType("text/html");
				break;
		}
		
		out.println(htmlPage);
		out.flush();
		
		//getServletContext().getRequestDispatcher(url).forward(request,response);
	}

}