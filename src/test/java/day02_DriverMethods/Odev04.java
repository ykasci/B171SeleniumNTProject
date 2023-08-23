package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1.Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://youtube.com");
        Thread.sleep(3000);
        String youtubeTitle = driver.getTitle();
        if (youtubeTitle.contains("youtube")) {
            System.out.println("PASSED");
        } else System.out.println("ActualTitle = " + youtubeTitle);

        //2.Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String youtubeUrl = driver.getCurrentUrl();
        if (youtubeUrl.contains("youtube")) {
            System.out.println("PASSED");
        } else System.out.println("youtubeUrl = " + youtubeUrl);

        //3.Daha sonra Google sayfasina gidin https://google.com
        driver.get("https://google.com");
        Thread.sleep(3000);

        //4.Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(3000);

        //5.Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(3000);

        //6.Google sayfasina donun
        driver.navigate().forward();
        Thread.sleep(3000);

        //7.Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        //8.Ardından sayfa başlığının "Google" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        String googleTitle = driver.getTitle();
        if (googleTitle.contains("Google")) {
            System.out.println("PASSED");
        } else System.out.println("googleTitle = " + googleTitle);


        //9.Sayfa URL'sinin https://google.com olup olmadığını doğrulayın, degilse doğru
        String googleUrl = driver.getCurrentUrl();
        if (googleUrl.contains("https://google.com")){
            System.out.println("PASSED");
        }else System.out.println("googleUrl = " + googleUrl);

        //  URL'yi yazdırın
        //11.Sayfayi kapatin
        driver.close();
    }
}
