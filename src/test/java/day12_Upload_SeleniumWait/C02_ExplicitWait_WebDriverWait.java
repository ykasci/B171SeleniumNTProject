package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait_WebDriverWait extends TestBase {
    @Test
    public void test01() {
        /*
        SELENIUM WAIT:
            IMPLICITLY WAIT --> Driver'i oluşturtuktan sonra sayfadaki tüm webelementlerin etkileşime girebilmesi için
        belirtmiş olduğumuz max. süre kadar driver'i bekletir(Duration.ofSecond(15))

            EXPLICT WAIT/WebDriverWait --> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için
        max. belirtmiş olduğumuz süre kadar default olarak yarım saniyelik araliklar ile bekler. Örneğin bir
        webelemente tıkladıktan son çıkan bir webelement yada bir alert'ün çıkması testimizi her çalıştırdığımızda
        farklı sürelerde oluşabilir. Dolayısıyla bunu süreyi kestiremediğimizden dolayı Thread.Sleep ile yapmamız
        çok mantıklı ve profesyonelce olmaz. Bu gibi durumlarda WebDriverWait ile bir webelementin oluşmasını
        bekletmek daha profesyonelce ve daha dinamik olur. Bunun için WebDriverWait class'ından bir obje oluşturup
        parametre olarak driver'i ve max. süreyi belirtiriz.

            EXPLICT WAIT/FluentWait --> Bir webelementin sayfa yüklendikten sonra etkileşime girebilmesi için max.
        belirtmiş olduğumuz süre kadar bizim belirttiğimiz aralıklarda bekler
         */

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = driver.findElement(By.xpath("(//h4)[2]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorldWE));
        Assert.assertEquals("Hello World!",helloWorldWE.getText());



    }

    @Test
    public void test02() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldWE = new WebDriverWait(driver,Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        /*
        Locate ini aldığımız webelementi görünür olana kadar bekle dedik ve bunu bir webelemente assign ettik.
         */

        Assert.assertEquals("Hello World!",helloWorldWE.getText());


    }

    @Test
    public void test03() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et



        /*
        bir web butona tikladigimizda kisa sureli ekranda duran ve kaybolan bir webelementin locate'ni nasil aliriz.
        Web sayfasinda sag tus incele dedikten sonra, 'source'(Kaynaklar) kismina basar ve butona tikladigimizda
        sagdaki pause isaretiyle web elementlerin yuklenmesini durudurabiliriz. Bu sekilde de kaybolan yazi veya elementin
        locateni rahatlikla alabiliriz.
         */
    }
}