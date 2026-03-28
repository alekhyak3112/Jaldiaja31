package org.Execution;

import org.Global.SeleniumBase;
import org.Pages.HomePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScript_Banking extends SeleniumBase{

	     
	@Parameters({"Browser","URL","firstname","lastname","postalcode"})
	@Test
	public void main(String Browsertype, String URL, String Firstname, String Lastname, String PostalCode) throws InterruptedException {
		
		System.out.println("Hello");
		
	getBrowser(Browsertype);
	getApplication(URL);
	
	HomePage homePage=new HomePage();
	
	Thread.sleep(2000);
	
	Assert.assertTrue(homePage.home().isDisplayed());
	System.out.println(" ======== XYZ Bank - Home Page========== ");
	
	Thread.sleep(2000);
	
	homePage.bankmangerlogin().click();
	
	Thread.sleep(2000);
	
	Assert.assertTrue(homePage.customersbutton().isDisplayed());
	System.out.println(" ======== Bank Manager Login ========== ");
	
	homePage.addcustomerbutton().click();
	
	Thread.sleep(2000);
	
	Assert.assertTrue(homePage.addcustomerbutton().isDisplayed());
	System.out.println(" ======== Add Customer Page ========== ");
	
	Thread.sleep(2000);
	
	homePage.addfirstname().sendKeys(Firstname);
	homePage.addlastname().sendKeys(Lastname);
	homePage.addPostalcode().sendKeys(PostalCode);
	
	Thread.sleep(2000);
	
	homePage.click_addcustomerbutton().click();
	
	screenCapture2();
	
	Thread.sleep(2000);   


	try {
	    driver.switchTo().alert().accept();
	} catch (Exception e) {
	   
	   }
	
	
	Thread.sleep(1000);
	
	homePage.openaccountbutton().click();
	
	Assert.assertTrue(homePage.openaccountbutton().isDisplayed());
	System.out.println(" ======= Your in open account page ============ ");
	
	Thread.sleep(1000);
	
	homePage.customerdropdown().click();
	
	Select select = new Select(homePage.customerdropdown());	
	select.selectByIndex(2);
	
	homePage.Currencydropdown().click();
	
	Select select1 = new Select(homePage.Currencydropdown());	
	select1.selectByValue("Rupee");
	
	Thread.sleep(2000);
	
	homePage.processbutton().click();
	
	screenCapture2();
	
	Thread.sleep(1000);
	
	try {
	    driver.switchTo().alert().accept();
	} catch (Exception e) {
	   
	   }
	
	homePage.customersbutton().click();
	
	Thread.sleep(1000);
	
	homePage.deletecustomers().click();
	
	homePage.homebutton().click();
	
	Thread.sleep(1000);
	
	homePage.customerloginbutton().click();
	
	Thread.sleep(3000);
	
//	System.out.println(driver.getCurrentUrl());
	
	Assert.assertTrue(driver.getCurrentUrl().contains("#/customer"));
	System.out.println(" ===========Your in customer Login Page=========== ");
	
	Thread.sleep(1000);
	
	homePage.yournamebutton().click();
	
	Select select2 = new Select(homePage.yournamebutton());	
	select2.selectByIndex(1);
	
	Thread.sleep(1000);
	
	homePage.Loginbutton().click();
	
	Thread.sleep(1000);
	
	Assert.assertTrue(homePage.welcomebutton().isDisplayed());
	System.out.println("========== Your in Customer Account Page========= ");
	
	homePage.depositbuttin().click();
	
	Thread.sleep(1000);
	
	homePage.amountotdeposit().sendKeys("10000");
	
	Thread.sleep(1000);
	
	homePage.clicktodeposit().click();
	
	Thread.sleep(2000);
	
	Assert.assertTrue(homePage.sucessmessage().isDisplayed());
	System.out.println(" ========== Yayyy amount deposited =========== ");
	
	Thread.sleep(1000);
	
	screenCapture2();
	
	Thread.sleep(1000);
	
	homePage.withdrawalbutton().click();
	
	Thread.sleep(1000);
	
	homePage.Amounttobewithdrwan().sendKeys("2000");
	
	Thread.sleep(1000);
	
	homePage.clickwithdraw().click();
	
	screenCapture2();
	
	Thread.sleep(1000);
	
	Assert.assertTrue(homePage.withdrawsuccesful().isDisplayed());
	System.out.println("======= Withdraw successful ======== ");
	
	homePage.transcationsbutton().click();
	
	Thread.sleep(1000);
	
	screenCapture2();
	
	homePage.logoutbutton().click();
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	String currentUrl = driver.getCurrentUrl();
		
//	Assert.assertTrue(currentUrl.contains("#/manager"));
//	System.out.println("--------- your in Bank manager Page --------- ");
	
	

	
	
	
	
	
	
	
	
	
	
	
		
		
		
	}
	
}
