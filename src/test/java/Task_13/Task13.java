package Task_13;

import BrowserChrome.Base;
import herokuapp.pages.FramesPage;
import herokuapp.pages.JavaScriptAlertsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task13 extends Base {
    @BeforeTest
    public void start(){
        driver.get("http://the-internet.herokuapp.com/");
    }
    @Test(priority = 1)
    public void FrameTest(){
        get(FramesPage.class)
                .ClickLinks()
                .CheckTextInFrame();
    }
    @Test(priority = 2)
    public  void JSAlertTest(){
        get(JavaScriptAlertsPage.class)
                .ClickJSLink()
                .ClickJSConfirm()
                .ClickJSPrompt();
    }
}
