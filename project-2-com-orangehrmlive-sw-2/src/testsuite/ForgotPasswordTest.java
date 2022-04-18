package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        WebElement userName = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        userName.sendKeys("Admin");

        // Enter “admin123 password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        passwordField.sendKeys("admin122");

        //click on the ‘Forgot your password’ link
        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotPassword.click();

        //Verify the text ‘Forgot Your Password?’
        String expectedResult = "Forgot Your Password?";

        WebElement actual = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualMsg = actual.getText();

        Assert.assertEquals(expectedResult, actualMsg);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
