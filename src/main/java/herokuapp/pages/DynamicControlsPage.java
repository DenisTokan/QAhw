package herokuapp.pages;

import herokuapp.BasePageHero;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsPage extends BasePageHero {
    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }
    private By CheckBox = By.id("checkbox");
    private By clickRemove = By.cssSelector("#checkbox-example > button");
    private By clickEnable = By.xpath("//button[text()='Enable']");
    private By input = By.xpath("//*[@type='text']");
    private By itsGoneMessage = By.xpath("//*[@id='checkbox-example']/p[@id='message']");
    private By itsEnabledMessage = By.xpath("//*[@id='input-example']/p[@id='message']");
    private By LinkDyn = By.linkText("Dynamic Controls");

    public DynamicControlsPage ClickLink(){
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(LinkDyn).click();
        return this;
    }

    public DynamicControlsPage CheckBox (){
        Assert.assertTrue(driver.findElement(CheckBox).isDisplayed());
        driver.findElement(clickRemove).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(itsGoneMessage));
        Assert.assertEquals(driver.findElement(itsGoneMessage).getText(),"It's gone!");
        Assert.assertEquals(driver.findElements(CheckBox).size(),0);
        return this;
    }
    public DynamicControlsPage CheckInput(){
        Assert.assertFalse(driver.findElement(input).isEnabled());
        driver.findElement(clickEnable).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(itsEnabledMessage));
        Assert.assertEquals(driver.findElement(itsEnabledMessage).getText(), "It's enabled!");
        Assert.assertTrue(driver.findElement(input).isEnabled());
        return this;
    }
}
