package day12_Upload_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Homework extends TestBase {
    @Test
    public void test01() {
        //3.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4.Remove butonuna basin.
        driver.findElement(By.xpath("(//button)[1]")).click();

        //5.“It’s gone!” mesajinin goruntulendigini dogrulayin. (//p)[2]
        WebElement itsGone = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p)[2]")));
        Assert.assertEquals("It's gone!",itsGone.getText());

        //6.Add buttonuna basin  //*[text()='Add']
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7.It's back! mesajinin gorundugunu test edin  //p[@id='message']
        WebElement itsBack = new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals("It's back!",itsBack.getText());

    }

    @Test
    public void test02() {

        //1.https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2.Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox1 = driver.findElement(By.xpath("//*[@type='text']"));
        if (textBox1.isEnabled()){
            textBox1.sendKeys("Textbox Etkin");
        }else System.out.println("Textbox etkin değil");


        //3.Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin  //*[text()='Enable']
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(200)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Enable']")));

        //4.“It’s enabled!” mesajinin goruntulendigini dogrulayın.  //*[@id='message']
        Assert.assertEquals("It's enabled!",driver.findElement(By.xpath("//*[@id='message']")).getText());

        //5.Textbox’in etkin oldugunu(enabled) dogrulayın.
        WebElement textBox2 = driver.findElement(By.xpath("//*[@type='text']"));
        if (textBox2.isEnabled()){
            textBox2.sendKeys("Textbox Etkin");
        }else System.out.println("Textbox etkin değil");
    }


}
