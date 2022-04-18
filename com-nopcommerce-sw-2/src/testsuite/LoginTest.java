package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login linkk
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        String expectedMessage = "Welcome, Please Sign In!";

        //Find the welcome test element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();

        //Validate actual and expected message
        Assert.assertEquals("Not navigate to both page", expectedMessage, actualMessage);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find log in link and click on login link
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();

        //Enter valid username
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("nehasharma@gmail.com");

        //Enter valid password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("abc123");

        //Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();

        //log out


        String expectedMessage = "Log out";

        WebElement actualmessage = driver.findElement(By.linkText("Log out"));
        String actualResult = actualmessage.getText();
        //verify messages
        Assert.assertEquals(expectedMessage, actualResult);
        WebElement logOutElement = driver.findElement(By.linkText("Log out"));
        logOutElement.click();

    }

    @Test
    public void verifyTheErrorMessage() {
        // click on the ‘Login’ link
        WebElement loginbutton = driver.findElement(By.linkText("Log in"));
        loginbutton.click();

        //Enter Invalid username
        WebElement invalidUser = driver.findElement(By.xpath("//input[@id='Email']"));
        invalidUser.sendKeys("nehaahama@gmail.com");

        //Enter Invalid password
        WebElement password = driver.findElement(By.name("Password"));
        password.sendKeys("abc113");

        //Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        login.click();

        //verify messages
        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        WebElement actualElement = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]"));
        String actualResult = actualElement.getText();

        Assert.assertEquals(expectedMessage, actualResult);

    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}





