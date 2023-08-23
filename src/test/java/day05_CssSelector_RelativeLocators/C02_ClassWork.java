package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //        1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        driver.findElement(By.cssSelector("button[type='button']")).click();
        //Bu locate i xpath ile //button olarak alabilirim

        //3.Login alanine “username” yazdirin
        //4.Password alanine “password” yazdirin
        //5.Sign in buttonuna tiklayin
        WebElement login = driver.findElement(By.cssSelector("input[type='text']"));
        login.sendKeys("username", Keys.TAB,"password",Keys.ENTER);
        Thread.sleep(3000);
        driver.navigate().back();//--> sayfaya giriş yapabilmek için back kullandık


        //Xpath ile dinamik locate
       // WebElement login = driver.findElement(By.xpath("//input[1]"));

        //Online Banking altındaki Pay Bills sayfasina gidin
        driver.findElement(By.cssSelector("li[id='onlineBankingMenu']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span)[4]")).click();
        Thread.sleep(2000);

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        //tarih kismina "2020-09-10" yazdirin
        //Pay buttonuna tiklayin
        WebElement amount = driver.findElement(By.cssSelector("input[name='amount']"));
        amount.sendKeys("500",Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);



        //"The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("(//span)[1]"));
        String actualMesaj = mesaj.getText();
        String expectedMesaj = "The payment was successfully submitted.";
        if (actualMesaj.equals(expectedMesaj)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        driver.close();

        //div#alert_content






    }
}
