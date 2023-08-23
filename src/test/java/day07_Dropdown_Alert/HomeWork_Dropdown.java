package day07_Dropdown_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class HomeWork_Dropdown extends TestBase {
    @Test
    public void test01() {


        //    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        bekle(2);

        //            1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement option1Locate = driver.findElement(By.id("dropdown"));
        Select options = new Select(option1Locate);
        options.selectByIndex(1);
        System.out.println("Option 1 Text  'Index'  = " + options.getFirstSelectedOption().getText());


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        options.selectByValue("2");
        System.out.println("Option 2 Text  'Value' = " + options.getFirstSelectedOption().getText());
        bekle(3);

        //            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        options.selectByVisibleText("Option 1");
        System.out.println("Option 1 Text 'Visible' = " + options.getFirstSelectedOption().getText());
        bekle(3);

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> dropdownMenu = options.getOptions();
        for (WebElement i : dropdownMenu) {
            System.out.println(i.getText() + "'nin Texti == " + i.getText());
        }
        bekle(3);

        //2.yol Lambda
        //dropdownMenu.stream().forEach(t -> System.out.println(t.getText()));

        //5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //    False yazdırın.
        if (dropdownMenu.size() == 4) {
            System.out.println("True");
        } else System.out.println("False");


    }

    @Test
    public void test02() {
        //    1.http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //            2.Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        bekle(2);


        //3.Login kutusuna “username” yazin
        //4.Password kutusuna “password.” yazin
        //5.Sign in tusuna basin(not: navigate.Back yapınız)
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username", Keys.TAB, "password", Keys.TAB, Keys.TAB, Keys.ENTER);
        bekle(3);
        driver.navigate().back();


        //6.Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        bekle(3);
        driver.findElement(By.cssSelector("span[id='pay_bills_link']")).click();


        //7.“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[@href='#ui-tabs-3']")).click();
        bekle(3);

        //8.“Currency” drop down menusunden Eurozone’u secin
        WebElement ddm = driver.findElement(By.id("pc_currency"));
        Select options = new Select(ddm);
        options.selectByValue("EUR");
        bekle(3);

        //9.“amount” kutusuna bir sayi girin
        ddm.sendKeys(Keys.TAB, "500");

        //10.“US Dollars” in secilmedigini test edin
        WebElement USDollarsButton = driver.findElement(By.xpath("(//label[@class='radio inline'])[2]"));
        Assert.assertFalse(USDollarsButton.isSelected());

        //11.“Selected currency” butonunu secin
        WebElement selectedCurrencyButton = driver.findElement(By.xpath("(//label[@class='radio inline'])[3]"));
        selectedCurrencyButton.click();
        bekle(3);

        //12.“Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        selectedCurrencyButton.sendKeys(Keys.TAB,Keys.ENTER,Keys.TAB,Keys.ENTER);

        //13.“Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='alert_content']")).getText(),"Foreign currency cash was successfully purchased.");

    }


}
