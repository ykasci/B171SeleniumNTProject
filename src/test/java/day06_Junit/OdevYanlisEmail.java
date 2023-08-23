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

public class OdevYanlisEmail {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() throws InterruptedException {
        //1.https://pinterest.com/ sayfasina gidelim
        driver.get("https://pinterest.com/");
        Thread.sleep(2000);

        //2.Sign in butonuna basalim
        driver.findElement(By.xpath("//div[@class='tBJ dyH iFc sAJ O2T tg7 H2s']")).click();
        Thread.sleep(2000);

        //3.Email kutusuna @isareti olmayan bir mail
        // yazip enter’a bastigimizda “Hmm...that doesn't look like an email address” uyarisi ciktigini test edelim
        driver.findElement(By.xpath("//input[@autocomplete='email']")).sendKeys("alicabbargmail.com", Keys.ENTER);
        Thread.sleep(3000);

        WebElement falseMessage = driver.findElement(By.xpath("(//div[@class='xuA'])[8]"));
        Assert.assertTrue(falseMessage.isDisplayed());

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
