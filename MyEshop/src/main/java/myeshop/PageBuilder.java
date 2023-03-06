package myeshop;

public class PageBuilder {
	
	private String signUpPage = "";
	private String signInPage = "";
	private String signedInPage = "";
	private char dqm = '"';
	private String message = "";
	private String userMsg = "";
	
	public PageBuilder() {
		
	}
	
	public void setMessage(String message) {
		
		this.message = message;
	}
	
	public void setUserMsg(String msg) {
		
		this.userMsg = msg;
	}
	
	public String createSignInPage() {
		
		signInPage = "<html>" +
				"	<head>" +
				"		<title> MyEshop </title>" +
				"			<link rel='stylesheet' href='style.css'>" +
				"				<body>" +
				"					<div class='menu-bar'>"	+
				"					<ul>" +
				"						<li><a href='#'>PC</a>" +
				"							<div class='sub-menu-1'>" +
				"								<ul>" +
				"									<li><a href='http://localhost:8080/MyEshop/Products/PC/Desktops/desktops.html'>Desktops</a></li>" +
				"									<li><a href='http://localhost:8080/MyEshop/Products/PC/Laptops/laptops.html'>Laptops</a></li>" +
				"									<li><a href='http://localhost:8080/MyEshop/Products/PC/Tablets/tablets.html'>Tablets</a></li>" +
				"								</ul>" +
				"							</div>" +
				"						</li>" +
				"						<li><a href='#'>Screens</a>" +
				"							<div class='sub-menu-1'>" +
				"								<ul>" +
				"									<li><a href='#'>17 inches</a></li>" +
				"									<li><a href=''#'>19 inches</a></li>" +
				"									<li><a href='#'>20 inches</a></li>" +
				"								</ul>" +
                "							</div>" +
				"						</li>" +
				"						<li><a href='#'>Mices</a>" +
				"							<div class='sub-menu-1'>" +
				"								<ul>" +
				"									<li><a href='#'>Wired</a></li>" +
				"									<li><a href='#'>Wireless</a></li>" +
				"								</ul>" +
				"							</div>" +
				"						</li>" +
				"						<li><a href='#'>Keyboards</a>" +
				"							<div class='sub-menu-1'>" +
				"								<ul>" +
				"									<li><a href='#'>Wired</a></li>" +
				"									<li><a href='#'>Wireless</a></li>" +
				"								</ul>" +
				"							</div>" +
				"						</li>" +
				"						<li><a href='#'>Web cameras</a>" +
				"							<div class='sub-menu-1'>" +
				"								<ul>" +
				"									<li><a href='#'>3 Megapixels</a></li>" +
				"									<li><a href='#'>4 Megapixels</a></li>" +
				"									<li><a href='#'>5 Megapixels</a></li>" +
				"								</ul>" +
				"							</div>" +
				"						</li>" +
				"						<li><a href='#'>Hard Disks</a>" +
				"							<div class='sub-menu-1'>" +
				"								<ul>" +
				"									<li><a href='#'>Ssd</a></li>" +
				"									<li><a href='#'>Hdd</a></li>" +
				"								</ul>" +
				"							</div>" +
				"						</li>" +
				"						<li><a href='#'>Sticks</a>" +
				"							<div class='sub-menu-1'>" +
				"								<ul>" +
				"									<li><a href='#'>8 GB</a></li>" +
				"									<li><a href='#'>16 GB</a></li>" +
				"									<li><a href='#'>32 GB</a></li>" +
				"									<li><a href='#'>64 GB</a></li>" +
				"								</ul>" +
				"							</div>" +
				"						</li>" +
				"					</ul>" +
				"					</div>";
		
		return signInPage;
	}
	
	public String createFinalSignInPage(String msg) {
		
		String page = this.createSignInPage() +
		"			<div class='form-box'>" +
		"			<h1 id='title' class='h1-tag'>Sign In</h1>" +
		"			<form action='ProcessSignIn' method='post'>" +
		"				<div class='input-group'>" +
		"					<div class='input-field'>" +
		"						<input name='email' type='text' placeholder='Email'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='password' type='password' placeholder='Password'>" +
		"					</div>" +
		"				</div>" +
		"				<div class='btn-field'>" +
		"					<button type='submit' id='signinBtn'>Sign In</button>" +
		"					<button type='button' id='signupBtn' class='disable' onclick=" + dqm + "location.href='http://192.168.1.250:8080/MyEshop/SignUp'" + dqm + ">Sign up</button>" +
		"				</div>" +
		"			</form>" +
		"			<h2 class='msg'>" + msg + "</h2>" +
		"		</div>" +
		"		</body>" +
		"		</head>" +
		"		</html>";
		
		return page;
	}
	
	public String createSignedInPage() {
		
		signedInPage = this.createSignInPage() +
					"					<h4 style='color:red'>" + userMsg + "</h4>" +			
					"				</body>" +
					"			</head>" +
					"		</html>";
		
		return signedInPage;
	}
	
	public String createSignUpPage() {
		
		signUpPage = "<html>" +
		"<head>" +
		"	<title> MyEshop </title>" +
		"	<link rel='stylesheet' href='style.css'>" +
		"	<body>" +
		"		<div class='form-box1'>" +
		"			<form action='ProcessData' method='post'>" +
		"				<div class='input-group'>" +
		"					<div class='input-field'>" +
		"						<input name='name' type='text' placeholder='Name'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='surname' type='text' placeholder='Surname'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='tel' type='text' placeholder='tel'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='city' type='text' placeholder='City'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='address' type='text' placeholder='Address'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='zipcode' type='text' placeholder='Zipcode'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='email' type='text' placeholder='Email'>" +
		"					</div>" +
		"					<div class='input-field'>" +
		"						<input name='password' type='password' placeholder='Password'>" +
		"					</div>" +
		"					<div class='btn-field1'>" +
		"						<button type='button' id='backBtn' onclick=" + dqm + "location.href='http://192.168.1.250:8080/MyEshop/home'" + dqm + ">Back</button>" +
		"						<button type='submit' id='submitBtn'>Submit</button>" +
		"					</div>" +
		"				</div>" +
		"			</form>" +
		"			<h2 id='h' style='color:red'>" + message + "</h2>" +
		"		</div>" +
		"	</body>" +
		"</head>" +
		"</html>";
		
		return signUpPage;
	}

}
