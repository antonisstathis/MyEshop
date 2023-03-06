package myeshop;

public class Model {
	
	private Database database;
	private String[] data = {null,null,null}; // name,surname,password
	
	public Model() {
		
		database = new Database();
	}
	
	public String processSignInData(String email,String passwordForm) {
		
		database.connectToDatabase();
		try {
			data = database.searchEmail(email);
			if(data != null) {
				System.out.println("Email found: correct password = " + data[2] + " password given = " + passwordForm);
			}
			else {
				return "Email wasn't found.";
			}
			database.closeConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if(data != null && passwordForm != null) {
			if(data[2].equals(passwordForm)) {
				return "login successful";
			}
			else {	
				return "Wrong password.";
			}
		}
		else {
			if(data != null)
				return "Wrong password";
		}
		
		return null;
	}
	
	public String processSignUpData(Customer customer) {
		
		Boolean checkEmail = false;
		
		database.connectToDatabase();
		try {
			checkEmail = database.insertCustomer(customer);
			database.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(checkEmail) {
			return "Email already given.";
		}
		else {
			return "Your account was successfully created.";
		}
		
	}
	
	public String getName() {
		
		return data[0];
	}
	
	public String getSurname() {
		
		return data[1];
	}
	
	public String getPassword() {
		
		return data[3];
	}

}
