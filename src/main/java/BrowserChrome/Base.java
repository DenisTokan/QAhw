package BrowserChrome;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.InvocationTargetException;

import static BrowserChrome.DriverCreation.closeDriver;
import static BrowserChrome.DriverCreation.getDriver;

public class Base {
    protected WebDriver driver;
    protected ITestContext context;
    private String browserName;

    @BeforeTest
    public void precondition(ITestContext context) {
        this.context = context;
        this.browserName = context.getSuite().getParameter("browser") == null ? System.getProperty("browser") : context.getSuite().getParameter("browser");
        this.driver = getDriver(browserName == null ? "CHROME" : browserName);
    }

    protected <T> T get(Class<T> page) {
        return get(page,this.driver);
    }
    protected <T> T get(Class<T> page, WebDriver driver) {
        T instance=null;
        try {
            instance = page.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchElementException | NoSuchMethodException e){
            e.printStackTrace();
        }
        return instance;
    }
    @AfterTest
    public void postcondition() {
        closeDriver(browserName == null ? "CHROME" : browserName);
    }


}