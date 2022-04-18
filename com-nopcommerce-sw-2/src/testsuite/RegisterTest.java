package testsuite;


import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        //Verify the text ‘Register’
        String expectedOutput = "Register";

        WebElement actual = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        String actualMessage = actual.getText();

        Assert.assertEquals(expectedOutput, actualMessage);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        // click on the ‘Register’ link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        registerLink.click();

        //  Select gender radio button
        WebElement genderButton = driver.findElement(By.xpath("//input[@id='gender-female']"));
        genderButton.click();

        //Enter First name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("joan12");

        //Enter Last name
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Shaarmaa");

        // select birth
        WebElement birthDay = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']/option[10]"));
        birthDay.click();

        //Select month
        WebElement month = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"));
        month.sendKeys("April");

        //Select year
        WebElement year = driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"));
        year.sendKeys("2021");

        //Select Email
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("missjoana123@gmail.com");

        //Select password
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("abc1234");

        //Select confirm password
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("abc1234");

        //Select register
        WebElement regisLink = driver.findElement(By.xpath("//button[@id='register-button']"));
        regisLink.click();

        //Verifying
        String expectedResult = "Your registration completed";

        WebElement registration = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage = registration.getText();

        Assert.assertEquals(expectedResult, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
