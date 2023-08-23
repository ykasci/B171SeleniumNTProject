package day02_DriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Odev02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        //        ödev 1 :
//        1.Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get(" https://www.amazon.com/");


//        2.Sayfanin konumunu ve boyutlarini yazdirin
        Point konum = driver.manage().window().getPosition();
        System.out.println("konum = " + konum);
        Dimension boyut = driver.manage().window().getSize();
        System.out.println("boyut = " + boyut);

//        3.Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
         driver.manage().window().setPosition(new Point(11, 11));
        driver.manage().window().setSize(new Dimension(1000, 800));

//        4.Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        System.out.println("yeni Konum " + driver.manage().window().getPosition());
        System.out.println("yeni Boyut = " + driver.manage().window().getSize());


//        5.Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();


    }
}
