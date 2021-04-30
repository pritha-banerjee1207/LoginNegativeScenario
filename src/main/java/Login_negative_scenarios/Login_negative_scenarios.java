package Login_negative_scenarios;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;


import Reusable_functions.Generic_functions;
import io.cucumber.java.en.*;

public class Login_negative_scenarios extends Generic_functions  {
	public static String str;
    public static String valid_msg;
	/* Application Launch*/
	@Given("App is open")
	public void app_launch() {
		try {
			App_Launch();
			click("welcome_login");
			page_wait(20);
		} catch (IOException e) {
			e.getMessage();
		}
		}	
	
	
	/*TC_001 - Validate that the user is not allowed to login when 'Phone number' and 'Password' fields are blank*/
	@Then("User clicks on Login button")
	public static void login_negative_tc_001() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			click("login");
			page_wait(20);
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","login_validate"))).getAttribute("oninvalid"); 
			valid_msg=str.substring(24,49);
			Assert.assertEquals(valid_msg,"Please fill in this field");
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_001");
		}
	}
	/*TC_002 - Validate that the user should get a validation message on entering invalid credentials in the 'Login' Page*/
	@When("user enter invalid phone no and password")
	public static void login_negative_tc_002() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator", "Phone_number"))).sendKeys(td_reader("login_phone_number",1,0));
			driver.findElement(By.xpath(OR_reader("Object_Locator", "Password"))).sendKeys(td_reader("login_password",1,0));
			click("login");
			page_wait(60);
			}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_002");
		}
	}
	/*TC_003 - Validate that user is not allowed to enter more than 10 digits in the 'Phone number' field */
	@Then("validation messages should be displayed")
	public static void signup_negative_tc_003() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","Phone_number"))).sendKeys(td_reader("login_phone_number",1,1));
			driver.findElement(By.xpath(OR_reader("Object_Locator","Password"))).sendKeys(td_reader("login_password",1,1));
			click("login");
			page_wait(60);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_003");
		}
	}
	/* Validation messages should be displayed when user enters invalid details  */
	@When("User enters phone number with more than ten digits")
	public static void user_enters_phone_number_with_more_than_ten_digits() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			str= driver.findElement(By.xpath(OR_reader("Object_Locator","login_negative_valid_msg"))).getText();
			Assert.assertEquals(str,"Invalid username or password, please try again.");
			page_wait(60);	
			} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("login_validation_msg");
		}
	}
	/*TC_005 - Validate that the user is not allowed to login with invalid 'Phone number' and valid 'Password' */ 
	@When("user enters invalid Phone number and valid Password")
	public static void login_negative_tc_005() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","Phone_number"))).sendKeys(td_reader("login_phone_number",1,2));
			driver.findElement(By.xpath(OR_reader("Object_Locator","Password"))).sendKeys(td_reader("login_password",1,2));
			click("login");
			page_wait(60);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_005");
		}
	}
	/*TC_006 - Validate that the user is not allowed to login with invalid Password and valid phone number */
	@When("user enters invalid Password and valid phone number")
	public static void login_negative_tc_006() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","Phone_number"))).sendKeys(td_reader("login_phone_number",1,3));
			driver.findElement(By.xpath(OR_reader("Object_Locator","Password"))).sendKeys(td_reader("login_password",1,3));
			click("login");
			page_wait(60);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_006");
			}
	}
	/*TC_007 - Validate that user is not able to login on leaving 'Phone number' field blank and only giving valid 'Password' */
	@When("user leavs Phone number field blank")
	public static void login_negative_tc_007() throws InterruptedException, IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","Password"))).sendKeys(td_reader("login_password",1,4));
			click("login");
			page_wait(60);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_007");
		}
	}
	/*TC_008 - Validate that user is not able to login on leaving 'Password' field blank and only giving valid 'Phone number' */ 
	@When("user leavs Password field blank")
	public static void login_negative_tc_008() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		try {
			driver.findElement(By.xpath(OR_reader("Object_Locator","Phone_number"))).sendKeys(td_reader("login_phone_number",1,4));
			click("login");
			page_wait(60);
		}catch(Exception e) {
			e.printStackTrace();
			takeScreenShot("login_negative_tc_008");
		}
	}


}
