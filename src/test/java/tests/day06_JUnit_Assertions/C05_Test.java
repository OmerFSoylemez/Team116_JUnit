package tests.day06_JUnit_Assertions;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_Test extends TestBase {

        // 1. Bir Class olusturalim YanlisEmailTesti
        // 2. http://automationpractice.com/index.php sayfasina gidelim
        // 3. Sign in butonuna basalim
        // 4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
        //    email address” uyarisi ciktigini test edelim

    @Test
    public void Test01 () {

        // 2. http://automationpractice.com/index.php sayfasina gidelim
            driver.findElement(By.xpath("http://automationpractice.com/index.php")).click();

            //?????????????????????????????
            // SAYFAYA GİTMİYOR

        // 3. Sign in butonuna basalim


        // 4. Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid
        //    email address” uyarisi ciktigini test edelim
    }

}
