package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com/");
        Thread.sleep(2500);

        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String medunnaTitle = driver.getTitle();
        System.out.println("medunnaTitle = " + medunnaTitle);

        String medunnaUrl = driver.getCurrentUrl();
        System.out.println("medunnaUrl = " + medunnaUrl);


        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.
        if (medunnaTitle.contains("MEDUNNA")){
            System.out.println("içerir");
        }else System.out.println("içermez");

        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz
        if (medunnaUrl.contains("medunna")){
            System.out.println("içerir");
        }else System.out.println("içermez");

        // medunna adresine geri donunuz
        driver.get("https://google.com");
        Thread.sleep(2500);

        driver.navigate().back();
        Thread.sleep(2500);

        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(2500);


        // medunna adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(2500);

        // Sayfayı yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(2500);
        // pencereyi kapat
       // driver.close();

        System.out.println();
    }
}
