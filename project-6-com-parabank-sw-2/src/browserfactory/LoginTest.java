package browserfactory;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        WebElement userName = driver.findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("Prima");

        //Enter valid password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("abc123");

        //Click on ‘LOGIN’ button
        WebElement loginText = driver.findElement(By.xpath("//input[@class='button' and @value='Log In']"));
        loginText.click();

        //Verify the ‘Accounts Overview’ text is display
        String expectedMsg = "Error!";

        WebElement actual = driver.findElement(By.xpath("//h1[@class = 'title']"));
        String actualMsg = actual.getText();
        Assert.assertEquals(expectedMsg, actualMsg);
    }

    @Test
    public void verifyTheErrorMessage() {
        // Enter invalid username
        WebElement invalidUser = driver.findElement(By.xpath("//input[@name='username']"));
        invalidUser.sendKeys("amm12");

        // Enter invalid password
        WebElement invalidpassword = driver.findElement(By.xpath("//input[@name='password']"));
        invalidpassword.sendKeys("aaa123");

        // Click on Login button
        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='button' and @value='Log In']"));
        loginBtn.click();

        // Verify the error message ‘The username and password could not be verified.’
        WebElement error = driver.findElement(By.xpath("//p[@class='error']"));
        String actualErrorMessage = error.getText();

        String expected = "The username and password could not be verified.";
        Assert.assertEquals(expected, actualErrorMessage);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Enter valid username

        WebElement validUser = driver.findElement(By.xpath("//input[@name='username']"));
        validUser.sendKeys("Prima");

        // Enter valid password
        WebElement validPassword = driver.findElement(By.xpath("//input[@name='password']"));
        validPassword.sendKeys("abc123");

        // Click on ‘LOGIN’ button
        WebElement login = driver.findElement(By.xpath("//input[@class='button' and @value='Log In']"));
        login.click();

        //  Click on ‘Log Out’ link
        WebElement logOut = driver.findElement(By.xpath("//a[text()='Log Out')]"));
        logOut.click();

        // Verify the text ‘Customer Login’
        WebElement customerLogin = driver.findElement(By.xpath("//h2[text()='Customer Login']"));
        String actualMsg = customerLogin.getText();

        String expectedMsg = "Customer Login";
        Assert.assertEquals(expectedMsg, actualMsg);
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
