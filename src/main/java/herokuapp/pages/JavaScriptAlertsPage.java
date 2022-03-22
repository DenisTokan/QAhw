package herokuapp.pages;

import herokuapp.BasePageHero;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JavaScriptAlertsPage extends BasePageHero {
    public JavaScriptAlertsPage(WebDriver driver) {
        super(driver);
    }
    private By ClickJSPage = By.linkText("JavaScript Alerts");
    private By buttonJsConfirm = By.xpath("(//li//button)[2]");
    private By buttonJsPrompt = By.xpath("(//li//button)[3]");
    private By result = By.id("result");
    public JavaScriptAlertsPage ClickJSLink(){
        driver.get("http://the-internet.herokuapp.com/");
        driver.findElement(ClickJSPage).click();
        return this;
    }
    public JavaScriptAlertsPage ClickJSConfirm(){
        driver.findElement(buttonJsConfirm).click();
        Alert alert = driver.switchTo().alert();
        String JSConfirmAlertTxt = alert.getText();
        Assert.assertEquals(JSConfirmAlertTxt, "I am a JS Confirm");
        alert.accept();
        Assert.assertEquals(getText(result), "You clicked: Ok");
        return this;
    }
    public JavaScriptAlertsPage ClickJSPrompt(){
        driver.findElement(buttonJsPrompt).click();
        Alert alert = driver.switchTo().alert();
        String JSPromptAlertTxt = alert.getText();
        Assert.assertEquals(JSPromptAlertTxt, "I am a JS prompt");
        alert.sendKeys("123");
        alert.accept();
        Assert.assertEquals(getText(result), "You entered: 123");
        return this;
    }
}
