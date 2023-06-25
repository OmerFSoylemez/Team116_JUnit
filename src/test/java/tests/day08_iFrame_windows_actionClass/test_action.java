package tests.day08_iFrame_windows_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class test_action extends TestBase {

        // Yeni bir class olusturalim: MouseActions3
        // 1- https://www.amazon.com/ adresine gidin
        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //    mouse’u bu menunun ustune getirin
        // 3- “Create a list” butonuna basin
        // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edin

    @Test
    public void Test01 () {

        // 1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        bekle(2);

        // 2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        //    mouse’u bu menunun ustune getirin
        bekle(2);
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("(//a[@data-nav-role='signin'])[1]"));
        actions.moveToElement(element).perform();
        bekle(2);


        // 3- “Create a list” butonuna basin
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
        bekle(2);


        // 4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement YourList = driver.findElement(By.xpath("//div[@role='heading']"));

        String expectedYazi = "Your Lists";
        String actualYazi = YourList.getText();

        Assert.assertTrue(actualYazi.contains(expectedYazi));

    }

}
