package Task_9;

import BrowserChrome.Base;
import Saucedemo.Pages.CartPage;
import Saucedemo.Pages.CheckOutPage;
import Saucedemo.Pages.LoginPage;
import Saucedemo.Pages.ShopPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task9 extends Base {

    @BeforeTest
    public void start(){
        driver.get("https://www.saucedemo.com/");

    }

    @Test(priority = 1)
    public void Login1() {
    get(LoginPage.class).LogIn();
    }

    @Test(priority = 2)
    public void ShopIn(){
        get(ShopPage.class).addToCart();
    }

    @Test(priority = 3)
    public void remove(){
        get(CartPage.class).removeItem();
        get(CartPage.class).goCheckOut();

    }
    @Test(priority = 4)
    public void CheckPay(){
        get(CheckOutPage.class).CheckOutPay();
    }

    @Test(priority = 5)
    public void Login2(){
        get(LoginPage.class).LogIn2();
    }



}






