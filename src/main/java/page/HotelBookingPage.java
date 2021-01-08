package page;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class HotelBookingPage extends TestBase{
	
	//Locators

	@FindBy(name ="userName") WebElement username;
	@FindBy(name ="userPwd") WebElement password;
	@FindBy(xpath = "//input[@value= 'Login']") WebElement loginBtn;
	@FindBy(id ="txtFirstName") WebElement firstName;
	@FindBy(id ="txtLastName") WebElement lastName;
	@FindBy(id ="txtEmail") WebElement emailID;
	@FindBy(name ="Phone") WebElement phoneNumber;
	@FindBy(xpath = "//textarea[@rows= '5']") WebElement addressFirstLine;
	@FindBy(name ="city") WebElement cityName;
	@FindBy(name ="state") WebElement stateName;
	@FindBy(name ="persons") WebElement personsCount;
	@FindBy(id ="txtCardholderName") WebElement cardHolderName;
	@FindBy(id ="txtDebit") WebElement debitCardNumber;
	@FindBy(id ="txtCvv") WebElement cvvValue;
	@FindBy(id ="txtMonth") WebElement expMonth;
	@FindBy(name ="year") WebElement expYear;
	@FindBy(id ="btnPayment") WebElement confirmButton;
	@FindBy(id ="userErrMsg") WebElement usernameErrorMsg;
	@FindBy(id ="pwdErrMsg") WebElement pwdErrorMsg;
	@FindBy(xpath="//h1[@align='center']") WebElement successMsg;
	
	//Actions
	 
	public HotelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void LoginDetails(String uname, String pwd) {
	        username.sendKeys(uname);
	        password.sendKeys(pwd);
	        loginBtn.click();
	        if (uname.equals("")) {
	            System.out.println(usernameErrorMsg.getText());
	             boolean UsernameError = usernameErrorMsg.isDisplayed();
	             Assert.assertTrue(UsernameError);
	             System.out.println("Error message is displayed for empty username");
	             driver.close();
	        }else
	        if(pwd.equals("")) {
	            System.out.println(pwdErrorMsg.getText());
	            boolean PasswordError = pwdErrorMsg.isDisplayed();
	            Assert.assertTrue(PasswordError);
	            System.out.println("Error message is displayed for empty password");
	            driver.close();
	        }       
	    }
	
	
	public String getBookingPagetitle() {
		return driver.getTitle();
	}
	
	
	public void EnterFirstName(String firstNameValue) {
		firstName.sendKeys(firstNameValue);
		
		if(firstNameValue.equals("")) {
			confirmButton.click();
			Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the First Name", alert.getText()); 
            driver.close();
		}

	}
	
	
	public void EnterLastName(String lastNameValue) {
		lastName.sendKeys(lastNameValue);
		
		if(lastNameValue.equals("")) {
			confirmButton.click();
			Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the Last Name", alert.getText()); 
            driver.close();
		}

	}
	
	
	public void EnterEmail(String emailValue) {
		emailID.sendKeys(emailValue);
		
		Pattern emailPattern = Pattern.compile("[\\w]+[\\d\\w]*(@)[\\w]+[\\w\\d]*(\\.)[\\w]+");
        Matcher formatMatcher = emailPattern.matcher(emailValue);
		if(emailValue.equals("")) {
			confirmButton.click();
			Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the Email", alert.getText()); 
            driver.close();
		}
		else if(!formatMatcher.matches()) {
			confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please enter valid Email Id.", alert.getText());
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.close();
           
        }

	}
	
	
	public void EnterphoneNumber(String phoneNumberValue) {
		phoneNumber.clear();
		phoneNumber.sendKeys(phoneNumberValue);
		Pattern PhoneNumberPattern = Pattern.compile("^[789]\\d{9}$");
        Matcher PhoneformatMatcher = PhoneNumberPattern.matcher(phoneNumberValue);
		
        if(phoneNumberValue .equals("")) {
        	confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the Mobile No.", alert.getText());
            driver.close();
           
        }
        else {       
            if((phoneNumberValue.length() != 10 )) {
            confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please enter valid Contact no.", alert.getText());
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.close();
            }
    		else if(!PhoneformatMatcher.matches()) {
    			confirmButton.click();
                Alert alert = driver.switchTo().alert();
                System.out.println("Alert message : "+ alert.getText());
                Assert.assertEquals("Please enter valid Contact no.", alert.getText());
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                driver.close();
               
            }
        }
       
    }
	
	
	public void EnterAdress(){
		addressFirstLine.sendKeys(prop.getProperty("addressFirstLine"));
    }
	
	
	public void SelectCity(String cityValue) {
        Select selectedCity = new Select(cityName);
        selectedCity.selectByValue(cityValue);
        
        if (cityValue.equals("")) {
        	confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please select city", alert.getText());
            driver.close();
        }
	}
	
	
	public void SelectState(String stateValue) {
        Select selectedState = new Select(stateName);
        selectedState.selectByValue(stateValue);
        
        if (stateValue.equals("")) {
        	confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please select state", alert.getText()); 
            driver.close();
        }
	}
	
	
	public void SelectPersonsCount(String personsCountValue) {
        Select selectedState = new Select(personsCount);
        selectedState.selectByValue(personsCountValue);
	}
	
	
	public void EnterCardHolderName() {
		cardHolderName.sendKeys(prop.getProperty("cardHolderName")); 
		
		if (cardHolderName.equals("")) {
			confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the Card holder name", alert.getText()); 
            driver.close();
        }
    }
	
	
    public void EnterCardNumber() {
    	debitCardNumber.sendKeys(prop.getProperty("debitCardNumber")); 
    	
		if (debitCardNumber.equals("")) {
			confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the Debit card Number", alert.getText()); 
            driver.close();
        }
    }
    
    
    public void EnterCVV() {
    	cvvValue.sendKeys(prop.getProperty("cvvValue")); 
    	
		if (cvvValue.equals("")) {
			confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the CVV", alert.getText()); 
            driver.close();
        }
    }
    
    
    public void EnterExpMonth() {
    	expMonth.sendKeys(prop.getProperty("expMonth")); 
    	
		if (expMonth.equals("")) {
			confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill expiration month", alert.getText());
            driver.close();
        }
    }
    
    
    public void EnterExpYear() {
    	expYear.sendKeys(prop.getProperty("expYear"));  
		if (expYear.equals("")) {	
			confirmButton.click();
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert message : "+ alert.getText());
            Assert.assertEquals("Please fill the expiration year", alert.getText());  
            driver.close();
        }
    }
    
    
    public String SuccessMessage()
	{
    	confirmButton.click();
		return successMsg.getText();
	}

}
