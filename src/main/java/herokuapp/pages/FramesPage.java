package herokuapp.pages;

import herokuapp.BasePageHero;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FramesPage extends BasePageHero {
    public FramesPage(WebDriver driver) {
        super(driver);
    }
    private By FramesLink = By.linkText("Frames");
    private By iFrameLink = By.linkText("iFrame");
    private By Frame = By.id("mce_0_ifr");
    private By textArea = By.id("tinymce");

    public FramesPage ClickLinks(){
        driver.findElement(FramesLink).click();
        driver.findElement(iFrameLink).click();
        return this;
    }
    public FramesPage CheckTextInFrame(){
        driver.switchTo().frame(driver.findElement(Frame));
        String textInFrame = ((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;",driver.findElement(By.tagName("p"))).toString();
        Assert.assertEquals(textInFrame, "Your content goes here.");
        return this;
    }

}
