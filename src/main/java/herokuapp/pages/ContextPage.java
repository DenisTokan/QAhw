package herokuapp.pages;

import herokuapp.BasePageHero;
import org.openqa.selenium.*;
import org.testng.Assert;


public class ContextPage extends BasePageHero {
    public ContextPage(WebDriver driver) {
        super(driver);
    }
    private By contextLink = By.linkText("Context Menu");
    private By hotbox = By.id("hot-spot");
    public ContextPage clickContextLink(){
        driver.findElement(contextLink).click();
        return this;
    }
    public ContextPage clickHotbox(){
    actions.contextClick(driver.findElement(hotbox)).perform();
        Alert alert = driver.switchTo().alert();
        String alertTxt = alert.getText();
        Assert.assertEquals(alertTxt, "You selected a context menu");
        alert.accept();
    return this;
    }
}
