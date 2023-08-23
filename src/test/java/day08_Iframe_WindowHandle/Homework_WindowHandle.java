package day08_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Homework_WindowHandle extends TestBase {
    @Test
    public void test01() {
        // 1-https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows");
        bekle(3);

        // 2-Elemental Selenium linkine tıklayıp
        driver.findElement(By.xpath("(//a[@target='_blank'])[2]")).click();
        // Sayfa başlığının Elemental Selenium içerdiğini test edin
        String birinciSayfaHandle = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();
        for (String i : windows) {
            driver.switchTo().window(i);
            // if (!i.equals(birinciSayfaHandle)) {
            //   driver.switchTo().window(i);}

        }

        bekle(3);
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));


    }


}
