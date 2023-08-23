package Lms_HomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task01 extends TestBase {

    @Test
    public void test01() {
//        - ebay sayfasına gidiniz
        driver.get("https://ebay.com");

//        - electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//a[@_sp='p4375194.m1380.l3250'])[1]")).click();

//        - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> pictures=driver.findElements(By.xpath("//img[@width='225' or height='225']"));
        for (int i = 0; i <pictures.size() ; i++) {
            bekle(2);
            pictures=driver.findElements(By.xpath("//img[@width='225' or height='225']"));
            pictures.get(i).click();
            bekle(1);
           // - Her sayfanın sayfa başlığını yazdıralım
            System.out.println((i+1)+ ". nin başlığı  =" + driver.getTitle());
            bekle(1);
            driver.navigate().back();
        }



    }
}
