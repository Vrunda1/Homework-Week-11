package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl=" https://courses.ultimateqa.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link

        WebElement signIn= driver.findElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));
        signIn.click();

        //Verify the text ‘Welcome Back!
        WebElement actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualResult = actualMessage.getText();

        String expectedResult = "Welcome Back!";

        Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void verifyTheErrorMessage(){
        //Click on ‘sign’ button
        WebElement signInLink=driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        //Enter  username incorrect
        WebElement invalidUserName=driver.findElement(By.name("user[email]"));
        invalidUserName.sendKeys("123456@gmail.com");

        //Enter password
        WebElement invalidPassword=driver.findElement(By.id("user[password]"));
        invalidPassword.sendKeys("abcdefg");

        ////Click on ‘LOGIN’ butto
        WebElement loginButton = driver.findElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));
        loginButton.click();

        //Verify the error message
        WebElement actualMessage=driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualResult=actualMessage.getText();
        String expectedMessage= "Invalid email or password.";

        Assert.assertEquals("Unable to log in",actualResult,expectedMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

    }



