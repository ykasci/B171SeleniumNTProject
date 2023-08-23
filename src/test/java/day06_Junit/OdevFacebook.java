package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OdevFacebook {
    WebDriver driver;

    //Not: Before methodda driver ayarlarını yapınız
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //https://www.facebook.com adresine gidin

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        Thread.sleep(2000);


        //Url'in facebook içerdiğini test(assertion ile)
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
        Thread.sleep(2000);

        //"Create an Account" button'una basin

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(2000);


        //Çıkan formu doldurunuz
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]")).sendKeys("Ali", Keys.TAB, "Cabbar");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[3]")).sendKeys("lahoyo4282@royalka.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[4]")).sendKeys("lahoyo4282@royalka.com", Keys.TAB, "Lahoyo.8242");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//select[@aria-label='Gün']")).sendKeys("10", Keys.TAB, "01", Keys.TAB, "1963");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='2']")).click();
        Thread.sleep(1000);

        //kaydol butonuna tıklayınız

        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(1000);
    }

    // After ile sayfayı kapatınız
    @After
    public void tearDown() throws Exception {
        driver.close();
    }

}
