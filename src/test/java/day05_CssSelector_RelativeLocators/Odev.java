package day05_CssSelector_RelativeLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Odev {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        ÖDEV:
//        https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

////        Add Element butonuna basin 100 kez basınız
        WebElement addElementButton = driver.findElement(By.xpath("(//button)[1]"));
        int i = 0;
        while (i < 100) {
            addElementButton.click();
            i++;
            Thread.sleep(1000);
        }
        Thread.sleep(3000);
        System.out.println("Add Butonuna  " + i + " kere basıldı");


////        Delete butonuna 90 kez basınız
////        Ve 90 kez basıldığını doğrulayınız
        WebElement deleteButton = driver.findElement(By.xpath("(//button[@class='added-manually'])[1]"));
        int w = 0;
        while (w < 90) {
            driver.findElement(By.xpath("(//button[@class='added-manually'])[1]")).click();
            w++;
            Thread.sleep(1000);
        }
        System.out.println("Delete Butonuna  " + w + "  kere basıldı");


    }
}


//        WebElement pressAddElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
//        for (int i = 0; i < 100; i++) {
//            pressAddElement.click();
//        }
//        //Delete tusuna basin
//        int count =0;
//        for (int i = 0; i <= 90 ; i++) {
//            driver.findElement(By.cssSelector("button[class='added-manually']")).click();
//            count++;
//        }
//
//        if (count==90){
//            System.out.println(count + " kere basildi");
//        }else System.out.println(count + "kere basilamadi");
