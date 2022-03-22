package Task_12;

import BrowserChrome.Base;
import herokuapp.pages.ContextPage;
import herokuapp.pages.DynamicControlsPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task12 extends Base {
    @BeforeTest
    public void start(){
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test(priority = 1)
    public void ContextTest (){
        get(ContextPage.class)
                .clickContextLink()
                .clickHotbox();
    }
    @Test(priority = 2)
    public void DynamicControlsTest (){
        get(DynamicControlsPage.class)
                .ClickLink()
                .CheckBox()
                .CheckInput();

    }

}
