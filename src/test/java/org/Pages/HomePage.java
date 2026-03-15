	package org.Pages;
	
	import org.Global.SeleniumBase;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
	public class HomePage extends SeleniumBase{
	
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//strong[@class=\"mainHeading\"]")
		private WebElement XYZbank;
		
		public WebElement home() {
			
			return XYZbank;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"manager()\"]")
		private WebElement bankmangerloginbtn;
		
		public WebElement bankmangerlogin() {
			
			return bankmangerloginbtn;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"showCust()\"]")
		private WebElement customers;
		
		public WebElement customersbutton() {
			
			return customers;
		
		}
		
		@FindBy(xpath = "//button[@ng-click=\"addCust()\"]")
		private WebElement addCustomer;
		
		public WebElement addcustomerbutton() {
			
			return addCustomer;
		}
		
		@FindBy(xpath = "//input[@placeholder=\"First Name\"]")
		private WebElement firstName;
		
		public WebElement addfirstname() {
			
			return firstName;
		}
		
		@FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
		private WebElement lastname;
		
		public WebElement addlastname() {
			
			return lastname;
		}
		
		@FindBy(xpath = "//input[@placeholder=\"Post Code\"]")
		private WebElement postalcode;
		
		public WebElement addPostalcode() {
			
			return postalcode;
		}
		
		@FindBy(xpath = "//button[@type=\"submit\"]")
		private WebElement addcustomerbutton;
		
		public WebElement click_addcustomerbutton() {
			
		    return addcustomerbutton;
		}
				
		@FindBy(xpath = "//button[@ng-click=\"openAccount()\"]")
		private WebElement openAccount;
		
		public WebElement openaccountbutton() {
			
			return openAccount;
		}
		
		@FindBy(xpath = "//select[@id=\"userSelect\"]")
		private WebElement customer;
		
		public WebElement customerdropdown() {
			
			return customer;
		}
		
		@FindBy(xpath = "//select[@id=\"currency\"]")
		private WebElement currency;
		
		public WebElement Currencydropdown() {
			
			return currency;
		}
		
		@FindBy(xpath = "//button[@type=\"submit\"]")
		private WebElement process;
		
		public WebElement processbutton() {
			
			return process;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"deleteCust(cust)\"]")
		private WebElement deletecustomer;
		
		public WebElement deletecustomers() {
			
			return deletecustomer;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"home()\"]")
		private WebElement homebutton;
		
		public WebElement homebutton() {
			
			return homebutton;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"customer()\"]")
		private WebElement Customerlogin;
		
		public WebElement customerloginbutton() {
		
			return Customerlogin;
		}
		
		@FindBy(xpath = "//select[@id=\"userSelect\"]")
		private WebElement yourname;
		
		public WebElement yournamebutton() {
			
			return yourname;
		}
		
		@FindBy(xpath = "//button[@ng-show=\"custId != ''\"]")
		private WebElement Login;
		
		public WebElement Loginbutton() {
			
			return Login;
		}
		
		@FindBy(xpath = "//strong[contains(text(),' Welcome ')]")
		private WebElement Welcome;
		
		public WebElement welcomebutton() {
			
			return Welcome;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"deposit()\"]")
		private WebElement deposit;
		
		public WebElement depositbuttin() {
		
			return deposit;
		}
		
		@FindBy(xpath = "//input[@type=\"number\"]")
		private WebElement amttodeposit;
		
		public WebElement amountotdeposit() {
			
			return amttodeposit;
		}
		
		@FindBy(xpath = "//button[@type=\"submit\"]")
		private WebElement todeposit;
		
		public WebElement clicktodeposit() {
		
			return todeposit;
		}
		
		@FindBy(xpath = "//span[@ng-show=\"message\"]")
		private WebElement message;
		
		public WebElement sucessmessage() {
			
			return message;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"withdrawl()\"]")
		private WebElement withdrawal;
		
		public WebElement withdrawalbutton() {
			
			return withdrawal;
		}
		
		@FindBy(xpath = "//input[@placeholder=\"amount\"]")
		private WebElement towithdraW;
		
		public WebElement Amounttobewithdrwan() {
			
			return towithdraW;
		}
		
		
		@FindBy(xpath = "//button[@type=\"submit\"]")
		private WebElement withdraw;
		
		public WebElement clickwithdraw() {
			
			return withdraw;
		}
		
		@FindBy(xpath = "//span[@ng-show=\"message\"]")
		private WebElement withdawmesage;
		
		public WebElement withdrawsuccesful() {
			
			return withdawmesage;
		}
		
		@FindBy(xpath = "//button[@ng-click=\"transactions()\"]")
		private WebElement transcations;
		
		public WebElement transcationsbutton() {
			
			return transcations;
		}
		
		@FindBy(xpath = "//button[@ng-show=\"logout\"]")
		private WebElement logout;
		
		public WebElement logoutbutton() {
			
			return logout;
		}
		
		
		
		
	}
