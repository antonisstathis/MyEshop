package myeshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProcessSignIn")
public class SignInServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public SignInServlet () {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Model model = new Model();
		String signInPage = "";
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		// The data are here
		String email = request.getParameter("email");
		String passwordForm = request.getParameter("password");
		
		// Ask model to process the data and take the conclusion
		PageBuilder page = new PageBuilder();
		String conclusion = model.processSignInData(email, passwordForm);
		
		switch (conclusion) {
			case "login successful":
				page.setUserMsg(model.getName() + " " + model.getSurname() + " signed in"); // name:data[0] surname:data[1]
				signInPage = page.createSignedInPage();
				break;
			case "Email wasn't found.":
				signInPage = page.createFinalSignInPage("Email wasn't found!");
				response.setContentType("text/html");
				break;
			case "Wrong password.":
				signInPage = page.createFinalSignInPage("Wrong password!");
				break;
 		}
		
		out.println(signInPage);
		out.flush();
	}

}
