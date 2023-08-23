package Lms_HomeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Task02 extends TestBase {

    @Test
    public void test01() {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        bekle(2);

        //-Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select options = new Select(ddm);
        List<WebElement> dropdownMenu = options.getOptions();
        int counter=1;
        for(WebElement i: dropdownMenu){
            System.out.println(counter +" . Menu  =  " + i.getText());
            counter++;
        }




    }

    @Test
    public void test02() {
        //-Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        bekle(2);

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım


        for (int i = 1; i <6 ; i++) {
            WebElement ddm = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
            Select options = new Select(ddm);
            List<WebElement> dropdownMenu = options.getOptions();
            dropdownMenu.get(i).click();
            bekle(2);
            driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
            System.out.println(i+ " . Menu Başlığı = " + driver.getTitle());
        }


    }


}
