package day08_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Homework_Iframe extends TestBase {
    @Test
    public void iframe() {


        //1-https://html.com/tags/iframe/ sayfaya gidiniz.
        driver.get("https://html.com/tags/iframe/");
        bekle(3);

        // 2- Youtube videosunda play butonuna basınız
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("button[class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();
    }
}
