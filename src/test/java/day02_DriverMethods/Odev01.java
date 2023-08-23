package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //ÖDEV
//        1.Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını doğrulayın (verify), eğer değilse doğru başlığı(Actual Title)
//        konsolda yazdirin.
        driver.get("https://youtube.com");
        Thread.sleep(3000);
        String youtubeTitle = driver.getTitle();

        if (youtubeTitle.contains("youtube")) {
            System.out.println("PASSED 1 ");
        } else System.out.println("Actual Title = " + youtubeTitle);


//2.Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String youtubeUrl = driver.getCurrentUrl();

        if (youtubeUrl.contains("youtube")) {
            System.out.println("PASSED 2 ");
        } else System.out.println("Current Url  = " + youtubeUrl);
//3.Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://amazon.com");
        Thread.sleep(3000);
//4.Youtube sayfasina geri donun
        driver.navigate().back();
        Thread.sleep(3000);
//5.Sayfayi yenileyin
        driver.navigate().refresh();
        Thread.sleep(3000);
//6.Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(3000);
//7.Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        Thread.sleep(3000);
//8.Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın, Yoksa doğru başlığı(Actual Title) yazdırın.
        String amazonTitle = driver.getTitle();

        if (amazonTitle.contains("Amazon")) {
            System.out.println("PASSED 3");
        } else System.out.println("Amazon Title = " + amazonTitle);
//9.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        String amazonUrl = driver.getCurrentUrl();

        if (amazonUrl.contains("https://www.amazon.com/")){
            System.out.println("PASSED 4");
        }else System.out.println("Amazon Url = " + amazonUrl);

//11.Sayfayi kapatin

        driver.close();

    }



        /*



         */
}
