package Saucedemo.Pages;

import Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {
    private By addBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By addBtn2 = By.id("add-to-cart-sauce-labs-bike-light");
    private By price = By.xpath("//div[@id='inventory_container']/div/div/div[2]/div[2]/div");
    private By cart = By.xpath("//div[@id='shopping_cart_container']/a");


    public ShopPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart (){
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(addBtn).click();
        driver.findElement(addBtn2).click();
        driver.findElement(cart).click();



    }


}
