package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountTest extends BaseTest{

    static WebDriver driver;

    @Test
    public void myAccountLogin(){
    driver.findElement(By.cssSelector(".carret")).click();

    driver.findElement(By.partialLinkText("login")).click();

    }
    @Test
    public void clientsBlocksAreVisible(){

        boolean NewCustomerBlockIsVisible = driver.findElement(By.cssSelector(("h2"))).isDisplayed();
        assertTrue(NewCustomerBlockIsVisible, "Naujo kliento blokas nematomas");

        boolean ReturnCustomerBlockIsVisible = driver.findElement(By.cssSelector(("h2"))).isDisplayed();
        assertTrue(ReturnCustomerBlockIsVisible, "Sugrįžusio kliento blokas nematomas");
    }

    @Test
    public void enterWrongDataAndPressLogin(){
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("jsdfhdshfsdkf@gmail.com");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("hsdfA_3432534");
    }

    @Test
    public void checkWarningText(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Warning: No match for E-Mail Address and/or Password.";
        assertEquals(actualTitle, expectedTitle, "Title was not the same as expected");
    }
}
