package Task_6;

import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;

public class Task6 {

    WebDriver driver = null;


    @BeforeTest
    public void setUP() {
        System.setProperty("webdriver.chrome.driver", "/QAhw/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void Login() {

        WebElement login = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        login.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();
    }

    @Test(priority = 2)
    public void CartAdd() {
        WebElement add = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        WebElement cart = driver.findElement(By.id("shopping_cart_container"));
        add.click();
        cart.click();
    }

    @Test(priority = 3, dataProvider = "data")
    public void CheckPrice(List<String>expectedData) {
        List<WebElement> results = driver.findElements(By.xpath("//div[@id='cart_contents_container']/div/div/div[3]//div[2]"));


        System.out.println(driver.findElement(By.id("inventory_item_price")).getText());

        List<String> actualData = new ArrayList<String>() {{
            results.forEach((element) -> add(element.getText()));
        }};
        Assert.assertEquals(actualData, expectedData);
    }

    @DataProvider(name = "data")
    public static Object[][] getData() {
        return new Object[][]{
                {new ArrayList<String>() {
                    {
                        add("Sauce Labs Backpack");
                        add("$29.99");
                    }
                }}};
    }
                    @AfterTest
                    public void close() {
                        driver.quit();
                    }

                }




