package testsuite;

import browserfactory.BaseTest;
import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl=" https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void  userSholdLoginSuccessfullyWithValidCredentials(){
        // Enter  username

        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

       //Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement loginLink= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginLink.click();

        //Verify the text “PRODUCTS”
        WebElement textField = driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
        textField.click();

     WebElement actualedMsg= driver.findElement(By.xpath("//span[contains(text(),'Products')]"));
       String actualResult = actualedMsg.getText();

       String expectedResult = "PRODUCTS";

        Assert.assertEquals(expectedResult,actualResult);


    } @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Enter  username
        WebElement userName = driver.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        //Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        WebElement loginLink= driver.findElement(By.xpath("//input[@id='login-button']"));
        loginLink.click();

        //Verify that six products are displayed

        int expectedlist=6;

        List<WebElement> productName = driver.findElements(By.className("inventory_item"));
        int size = productName.size();
        System.out.println("Atual avilable products: "+size);//6

        //Validate expected and actual message
        Assert.assertEquals("unable to display 6 products",expectedlist, size);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }




}
