package Saucedemo.Pages;

import Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BasePage {
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zip = By.id("postal-code");
    private By next = By.id("continue");
    private By ff = By.id("finish");

    public void CheckOutPay(){
    driver.findElement(firstName).sendKeys("Check");
    driver.findElement(lastName).sendKeys("Out");
    driver.findElement(zip).sendKeys("2312512");
    driver.findElement(next).click();
    driver.findElement(ff).click();
    }
}
