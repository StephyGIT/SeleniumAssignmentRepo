package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;

import base.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.HotelBookingPage;

public class HotelBookingStepDef extends TestBase {
	
	HotelBookingPage bookingPage;
	
	@Given("^User is on Hotel Booking login page$")
	public void user_is_on_Hotel_Booking_login_page() throws Throwable {
		TestBase.initialize();
	}
	
	@Given("^Title of Hotel Booking Login page$")
	public void title_of_Hotel_Booking_Login_page() throws Throwable {
		String heading=driver.findElement(By.xpath("//h1[contains(text(),' Hotel Booking Application ')]")).getText();
        Assert.assertEquals("Hotel Booking Application", heading);
        System.out.println("Heading validated");
	}
	 
	@When("^User enter login credential$")
	public void user_enter_login_credential() throws Throwable {
		bookingPage = new HotelBookingPage();
		bookingPage.LoginDetails(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^user is on Hotel booking page$")
	public void user_is_on_Hotel_booking_page() throws Throwable {
		String pageTitle = driver.getTitle();
	    Assert.assertEquals("Hotel Booking" , pageTitle);
	    System.out.println("Page title is " + pageTitle);
	    
	}


	@Then("^User enter input details on Hotel booking page and submit$")
	public void user_enter_input_details_on_Hotel_booking_page_and_submit() throws Throwable {
		bookingPage.EnterFirstName(prop.getProperty("firstName"));
		bookingPage.EnterLastName(prop.getProperty("lastName"));
		bookingPage.EnterEmail(prop.getProperty("emailID"));
		bookingPage.EnterphoneNumber(prop.getProperty("phoneNumber"));
		bookingPage.EnterAdress();
		bookingPage.SelectCity(prop.getProperty("cityName"));
		bookingPage.SelectState(prop.getProperty("stateName"));
		bookingPage.SelectPersonsCount(prop.getProperty("personsCount"));
		bookingPage.EnterCardHolderName();
		bookingPage.EnterCardNumber();
		bookingPage.EnterCVV();
		bookingPage.EnterExpMonth();
		bookingPage.EnterExpYear();
	}

	@Then("^User is on success page$")
	public void user_is_on_success_page() throws Throwable {		    
	    
	    Assert.assertEquals("Booking Completed!",bookingPage.SuccessMessage());
	    System.out.println("Success message validated");
	    
	    
	}
	
	@Then("^quit the browser$")
	public void quit_the_browser() throws Throwable {
	    driver.close();
	}



}
