package myeshop;

import java.sql.*;

public class Database {
	
	private String url = "jdbc:mysql://localhost:3306/myeshop";
	private String username = "";
	private String password = "";
	private Connection conn;
	
	public Database() {
		
	}
	
	public void connectToDatabase() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public Boolean insertCustomer(Customer c) throws Exception {
		
		String[] ps = null;
		
		Statement stm = conn.createStatement();
		ps = searchEmail(c.getEmail());
		if(ps == null) {
			String query = "INSERT INTO Customers(name,surname,tel,city,address,zipcode,email,password) VALUES(" + "'" + 
						c.getName() + "'" + "," + "'" + c.getSurname() + "'"  + "," + "'" + c.getTel() + "'" + "," + "'" + c.getCity()
						+ "'"  + "," + "'" + c.getAddress() + "'"  + "," + "'" + c.getZipcode() + "'" + "," + "'" + c.getEmail() + "'"
						+ "," + "'" + c.getPassword() + "')";
			//System.out.println(query);
			stm.executeUpdate(query);
			
			return false;
		}
		else {
			System.out.println("Email already exists.");
			return true;
		}
		
	}
	
	public String[] searchEmail(String email) throws Exception {
		
		String[] data = new String[3];
		Statement stm = conn.createStatement();
		String query = "select * from Customers where email=" + "'" + email + "'";
		ResultSet result = stm.executeQuery(query);
		if(result.next()) {
			data[0] = (String) result.getString("name");
			data[1] = (String) result.getString("surname");
			data[2] = (String) result.getString("password");
			result.close();
			
			return data;
		}
		else {
			return null;
		}
		
	}
	
	public void closeConnection() throws SQLException {
		
		conn.close();
	}

}
