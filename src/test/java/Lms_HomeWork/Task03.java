package Lms_HomeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.*;

public class Task03 extends TestBase {

    @Test
    public void test01() {

        //*** Aşağıdaki task'i Junit framework'ü ile yapınız

        //-https://the-internet.herokuapp.com/windows sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/windows");

        //-Sayfada Elemental Selenium webelementinin görünür olduğunu test ediniz
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).isDisplayed());


        //-Elemental Selenium linkine tıklayınız
        driver.findElement(By.xpath("(//*[@target='_blank'])[2]")).click();

        //-Açılan pencerede sayfa başlığının Elemental Selenium içerdiğini test ediniz
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Elemental Selenium"));

        //-Url'in https://elementalselenium.com/ olduğunu doğrulayınız
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().equals("https://elementalselenium.com/"));

        //A free weekly email of tips to help make
        //Selenium one of the most robust browser
        //automation tools out there.
        //"
        //-Yukarıdaki text'in altındaki email bölümüne email'inizi yazınız
        driver.findElement(By.xpath("//*[@id='email']")).
                sendKeys("alicabbar@gmail.com");

        //-Language dropdown menuden java seçiniz
        WebElement courseMenu = driver.findElement(By.xpath("//*[@class='dropdown-language']"));
        Select options = new Select(courseMenu);
        options.selectByIndex(3);


        //-Join the mailing list buttonuna tıklayınız
        courseMenu.sendKeys(Keys.TAB,Keys.ENTER);


        //-Sayfada Thank you! yazısının çıktığını doğrulayınız
       Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
    }
}
