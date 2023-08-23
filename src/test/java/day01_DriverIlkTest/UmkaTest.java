package day01_DriverIlkTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class UmkaTest extends TestBase {

    @Test
    public void umka() {
        driver.get("https://google.com");
        bekle(2);
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Umit SYDYK", Keys.ENTER);
        bekle(3);
        driver.findElement(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
        bekle(3);
        driver.findElement(By.xpath("((//img[@alt='Umit Sydyk'])[1]")).click();


    }
}
