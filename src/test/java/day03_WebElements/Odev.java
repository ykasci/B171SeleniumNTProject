package day03_WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Odev {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //a.web sayfasına gidin. https://www.amazon.com/
        driver.get("https://amazon.com");

        //b.Search(ara) “city bike”
        WebElement arama = driver.findElement(By.id("twotabsearchtextbox"));
        arama.sendKeys("city bike", Keys.ENTER);
        Thread.sleep(3000);


        //c.Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
        WebElement result = driver.findElement(By.xpath("//span[.='1-16 of 598 results for']"));
        String[] resultText = result.getText().split(" ");
        System.out.println("Sonuç sayısı = " + resultText[2]);


        //d.Sonra karşınıza çıkan ilk sonucun resmine tıklayın.
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();




    }


}
