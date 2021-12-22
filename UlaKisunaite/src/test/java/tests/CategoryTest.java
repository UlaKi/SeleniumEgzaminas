package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class CategoryTest extends BaseTest{

    @DataProvider(name = "category")
    public static Object[][] productData(){
            return new Object[][] {
                    {"iPod Classic"},
                    {"iPod Nano"},
                    {"iPod Shuffle"},
                    {"iPod Touch"}
            };
    }

    @Test
    public void categoryTest(){
        WebElement mainCategory = driver.findElement(By.xpath("//a[contains(@class, 'dropdown-toggle')]"));
        WebElement secondCategory = driver.findElement(By.xpath("//a[contains(@class, 'see-all')]"));

        Actions action = new Actions(driver);
        action.moveToElement((mainCategory)).build().perform();
        mainCategory.findElement(By.partialLinkText("MP3 Players"));
        secondCategory.findElement(By.partialLinkText("Show All Mp3 Players")).click();

        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains("Mp3 Players"), "Not expected Title was shown");

        driver.findElement(By.id("list-view")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement slider = driver.findElement();

        String actualTitleS = driver.getTitle();
        String expectedTitleS = "Success: You have added iPod Classic to your shopping cart!";
        assertEquals(actualTitleS, expectedTitleS, "Title was not the same as expected");

        driver.findElement(By.id("cart-total")).click();

        String actualTitleP = driver.getTitle();

    }

}
