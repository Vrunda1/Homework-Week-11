package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.Zip;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
    openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //click on Register link
        WebElement loginLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        loginLink.click();

        String expectedMessage = "Signing up is easy!";
        WebElement actual = driver.findElement(By.xpath("//h1[@class='title']"));
        String actualMessage = actual.getText();

        //Verifying the text
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //click on Register link
        WebElement registerLink = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        registerLink.click();

        //Enter First name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='customer.firstName']"));
        firstName.sendKeys("PrimeMember123");

        //Enter Last name
        WebElement lastName = driver.findElement(By.xpath("//input[@name='customer.lastName']"));
        lastName.sendKeys("Testing");

       // Enter Address
        WebElement address = driver.findElement(By.xpath("//input[@id='customer.address.street']"));
        address.sendKeys("3,Isobel Street");

		//Enter City
        WebElement city = driver.findElement(By.xpath("//input[@id='customer.address.city']"));
        city.sendKeys("London");

        //Enter State
        WebElement state = driver.findElement(By.xpath("//input[@name='customer.address.state']"));
        state.sendKeys("Northwood");

        // Enter Zip Code
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zipCode.sendKeys("ha2 5rt");

        // Enter Phone
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@name='customer.phoneNumber']"));
        phoneNumber.sendKeys("0778812561");

        // Enter SSN
        WebElement ssn = driver.findElement(By.xpath("//input[@name='customer.ssn']"));
        ssn.sendKeys("12345");

        // Enter Username
        WebElement userName = driver.findElement(By.xpath("//input[@name='customer.username']"));
        userName.sendKeys("Prime123");

        // Enter Password
        WebElement password = driver.findElement(By.xpath("//input[@id='customer.password']"));
        password.sendKeys("abc123");

        // Enter Confirm
        WebElement confirmbtn = driver.findElement(By.xpath("//input[@id='repeatedPassword']"));
        confirmbtn.sendKeys("abc123");

        // Click on REGISTER button
        WebElement registerBtn = driver.findElement(By.xpath("//input[@class='button' and @value='Register']"));
        registerBtn.click();

       //Verify the text 'Your account was created successfully. You are now logged in.

        String expectedResult = "Your account was created successfully. You are now logged in.";
        WebElement actual = driver.findElement(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"));
       String actualMessage = actual.getText();

        Assert.assertEquals(expectedResult,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}



