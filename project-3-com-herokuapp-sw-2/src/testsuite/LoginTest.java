package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void openUrl() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        //Enter  username

        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith");

        //Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");

        //Click on ‘LOGIN’ button
        WebElement loginClick = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginClick.click();

        //Verify the text “Secure Area”
        String expectedAreaResult = "Secure Area";

        WebElement area = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualAreaResult = area.getText();

        Assert.assertEquals(expectedAreaResult, actualAreaResult);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        //Enter  username incorrect
        WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("tomsmith1");

        //Enter password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='username']"));
        passwordField.sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        WebElement loginClick = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginClick.click();

        //Verify the error message

        String expectedAreaResult = "Your username is invalid!\n" +
                "×";
        WebElement actual = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actual.getText();

        Assert.assertEquals(expectedAreaResult, actualMessage);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Enter  username
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
        userNameField.sendKeys("tomsmith");

        //Enter password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.sendKeys("SuperSecretPassword");

        //Click on ‘LOGIN’ button
        WebElement loginClick = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginClick.click();

        //Verify the error message
        String expectedResult = "Your password is invalid!\n" +
                "×";

        WebElement actualMsg = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage = actualMsg.getText();

        Assert.assertEquals(expectedResult, actualMessage);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
