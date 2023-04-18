package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLogSuccessfullyWithValidCredentials() {
        //1 Enter "Allengrove" username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        //  Enter “SuperSecretPassword!” password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword");
        //Click on login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        //Verify the text "Dedicated Area".
        String expectedMessage = "Dedicated Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals("Dedicated Area not displayed", expectedMessage, actualMessage);

    }

    @Test
    public void verifyTheUsernameErrorMessage() {

        //2 enter “tomsmith” username
        WebElement usernamefield = driver.findElement(By.id("username"));
        usernamefield.sendKeys("tomsmith1");
        // Enter "SuperSecretPassword!" password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        //Click on Login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        //Verify the error message "username is invalid!"
        String expectedMessage = "Your username is invalid!\n" + "x";
        WebElement actualDisplayMessage = driver.findElement(By.id("flash"));
        String actualMessage = actualDisplayMessage.getText();
        Assert.assertEquals("Your password is invalid! not displayed", expectedMessage, actualMessage);

    }

    @Test

    public void verifyThePasswordErrorMessage(){
        //3 Enter "Tomsmith" username
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys("tomsmith");
        //Enter "SuperSecretPassword" password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(("SuperSecretPassword"));
        //Click on login button
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
        //Verify the error message "Your password is invalid!"
        String expectedMessage = "Your password is invalid!\n" + "x";
        WebElement actualDisplayMessage = driver.findElement(By.id("flash"));
        String actualMessage = actualDisplayMessage.getText();
        Assert.assertEquals("Your password is invalid! not displayed", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        closeBrowser();

    }
}