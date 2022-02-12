package Saucedemo.Pages;

import Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
    private By price = By.xpath("//div[@id='cart_contents_container']/div/div/div[3]/div[2]/div[2]/div");
    private By price2 = By.xpath("//div[@id='cart_contents_container']/div/div/div[4]/div[2]/div[2]/div");
    private By remove = By.xpath("//button[@id='remove-sauce-labs-bike-light']");
    private By checkOut = By.xpath("//button[@id='checkout']");

    public void removeItem (){
        driver.findElement(remove).click();
    }
    public void goCheckOut(){
        driver.findElement(checkOut).click();
    }
}

