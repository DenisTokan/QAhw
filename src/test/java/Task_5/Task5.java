package Task_5;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task5 {
    WebDriver driver = null;



    @BeforeTest
    public void setUP(){
        System.setProperty("webdriver.chrome.driver","/QAhw/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();



    }
    @Test(dataProvider = "data")
    public void smokeTest(String calcRoomw, String calcRoomh, String calcLamh, String calcLamw, String calcIn, String calcPr, String calcB, String calcW,
                          List<String>expectedData)  {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");

        WebElement calcRoomwidth = driver.findElement(By.name("calc_roomwidth"));
        WebElement calcRoomheight = driver.findElement(By.name("calc_roomheight"));
        WebElement calcLamwidth = driver.findElement(By.name("calc_lamwidth"));
        WebElement calcLamheight = driver.findElement(By.name("calc_lamheight"));
        WebElement calcInpack = driver.findElement(By.name("calc_inpack"));
        WebElement calcPrice = driver.findElement(By.name("calc_price"));
        WebElement calcDirect = driver.findElement(By.name("calc_direct"));
        Select selectDirect = new Select(calcDirect);
        WebElement calcBias = driver.findElement(By.name("calc_bias"));
        WebElement calcWalldist = driver.findElement(By.name("calc_walldist"));
        WebElement lamcalc = driver.findElement(By.cssSelector("[type = 'button']"));
        List<WebElement> results = driver.findElements(By.xpath("//form[@id='inputcalc']/div/div[4]/div"));



        calcRoomwidth.sendKeys(calcRoomw);
        calcRoomheight.sendKeys(calcRoomh);
        calcLamheight.sendKeys(calcLamh);
        calcLamwidth.sendKeys(calcLamw);
        calcInpack.sendKeys(calcIn);
        calcPrice.sendKeys(calcPr);
        selectDirect.selectByValue("tow");
        calcBias.sendKeys(calcB);
        calcWalldist.sendKeys(calcW);
        lamcalc.click();
        List<String> actualData = new ArrayList<String>() {{
            results.forEach((element) -> add(element.getText()));
        }};
        Assert.assertEquals(actualData, expectedData);



    }

        @DataProvider(name = "data")
        private Object[][] getData() {
            return new Object[][]{
                    {"7", "3", "100", "147", "52", "8200", "50", "2", new ArrayList<String>() {{
                        add("РЕЗУЛЬТАТ РАСЧЕТА:");
                        add("Площадь укладки: 145.04 м2.");
                        add("Кол-во панелей: 31 шт.");
                        add("Кол-во упаковок: 1 шт.");
                        add("Стоимость: 500000000 руб.");
                        add("Остатки: 69 шт.");
                        add("Отрезки: 7 шт.");
                    }}},
                    {"0", "0", "0", "0", "0", "0", "0", "0", new ArrayList<String>() {{
                        add("РЕЗУЛЬТАТ РАСЧЕТА:");
                        add("Площадь укладки: 145.04 м2.");
                        add("Кол-во панелей: 31 шт.");
                        add("Кол-во упаковок: 1 шт.");
                        add("Стоимость: 4250000 руб.");
                        add("Остатки: 69 шт.");
                        add("Отрезки: 7 шт.");
                    }}}
            };
        }
    @AfterTest
    public void close() {
        driver.quit();
    }
}
