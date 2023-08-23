package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //        ödev:
        //1.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook”
        //oldugunu dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://facebook.com");
        Thread.sleep(2500);
        String facebookTitle = driver.getTitle();
        if (facebookTitle.contains("facebook")) {
            System.out.println("PASSED");
        } else System.out.println("facebookTitle = " + facebookTitle);

        //3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i
        //yazdirin.
        String facebookUrl = driver.getCurrentUrl();
        if (facebookUrl.contains("facebook")) {
            System.out.println("PASSED");
        } else System.out.println("facebookUrl = " + facebookUrl);

        //4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/ ");
        Thread.sleep(2500);


        //5.Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String walmartTitle = driver.getTitle();
        if (walmartTitle.contains("Walmart.com")){
            System.out.println("PASSED");
        }else System.out.println("FAILED");

        //6.Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        Thread.sleep(2500);

        //7.Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(2500);

        //8.Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        Thread.sleep(2500);

        // 9.Browser’i kapatin
        driver.close();




    }
}
