package Saucedemo.Pages;

import Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By login = By.id("user-name");
    private By pass = By.id("password");
    private By sub = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void LogIn (){
        driver.findElement(login).sendKeys("standard_user");
        driver.findElement(pass).sendKeys("secret_sauce");
        driver.findElement(sub).click();
    }

    public void LogIn2(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(login).sendKeys("locked_out_user");
        driver.findElement(pass).sendKeys("secret_sauce");
        driver.findElement(sub).click();
    }
}
