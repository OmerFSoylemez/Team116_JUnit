package tests.day12_ScreenShot_jsExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_jsExecutor extends TestBase {

    @Test
    public void test01() {

        // wisequarter ana sayfaya gidelim
        driver.get("https://www.wisequarter.com");

        //jsExecutor kulllanarak Contact linkini tıklayın
        WebElement contactLınkElementi = driver.findElement(By.xpath("//a[text()='Contact']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",contactLınkElementi);

        bekle(5);

        // anasayfaya geri dönün
        // aşağıda bulunan "Go to career page" butonuna kadar aşağıya inin ve bu butona click yapın.

        driver.navigate().back();
        bekle(15);

        WebElement goToCareerButonu = driver.findElement(By.xpath("//i[@class='fas fa-paper-plane']"));

        jse.executeScript("arguments[0].scrollIntoView();",goToCareerButonu);

        bekle(15);

        goToCareerButonu.click();

        jse.executeScript("alert('yasasinnnn');");





    }
}
