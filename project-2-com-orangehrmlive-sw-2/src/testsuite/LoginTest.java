package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter “Admin” username
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");

        // Enter “admin123 password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passwordField.sendKeys("admin123");

        //Click on ‘LOGIN’ button
        WebElement loginLink = driver.findElement(By.id("btnLogin"));
        loginLink.click();

        String expectedMessage = "Welcome";
        WebElement actualMessage = driver.findElement(By.xpath("//a[@id='welcome']"));
        String actualResult = actualMessage.getText();
        System.out.println(actualMessage.getText());
        String substr = actualResult.substring(0,7);

        //Verifying the ‘Welcome’ text is display
       Assert.assertEquals(expectedMessage, substr);
    }
    @After
    public void tearDown() {
       closeBrowser();
    }
}
