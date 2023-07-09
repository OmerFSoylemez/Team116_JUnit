package tests.day09_actions_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class test1 extends TestBase {

    //     Yeni Class olusturun ActionsClassHomeWork
    // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    @Test
    public void Test01() {
        driver.get("http://webdriveruniversity.com/Actions");

        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(driver);
        WebElement Hover = driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));

        actions.moveToElement(Hover).perform();
        bekle(3);
        // 3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        bekle(3);

        // 4- Popup mesajini yazdirin
        //Alert alert = driver.switchTo().alert();
        //String alertText = alert.getText();
        //System.out.println("Alert Metni: " + alertText);

        System.out.println(driver.switchTo().alert().getText());

        // 5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(3);


        // 6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.click(clickAndHold).keyDown(Keys.DOWN).perform();


        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHold.getText());



        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick= driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();

    }
}