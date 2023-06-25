package tests.day07_testBase_dropdown;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseQuit;

public class test2_dropdown extends TestBaseQuit {

    // 1. http://zero.webappsecurity.com/ Adresine gidin
    // 2. Sign in butonuna basin
    // 3. Login kutusuna “username” yazin
    // 4. Password kutusuna “password.” yazin
    // 5. Sign in tusuna basin
    // 6. Pay Bills sayfasina gidin
    // 7. “Purchase Foreign Currency” tusuna basin
    // 8. “Currency” drop down menusunden Eurozone’u secin
    // 9. “amount” kutusuna bir sayi girin
    // 10. “US Dollars” in secilmedigini test edin
    // 11. “Selected currency” butonunu secin
    // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
    // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
    //      kontrol edin.

    @Test
    public void Test01 () {

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


        // 2. Sign in butonuna basin
        bekle(2);
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        bekle(2);


        // 3. Login kutusuna “username” yazin
        bekle(2);
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("username");
        bekle(2);


        // 4. Password kutusuna “password.” yazin
        bekle(2);
        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("password");


        // 5. Sign in tusuna basin
        bekle(2);
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        bekle(4);


        // SORUDA SORUN VAR...

        // 6. Pay Bills sayfasina gidin
        // 7. “Purchase Foreign Currency” tusuna basin
        // 8. “Currency” drop down menusunden Eurozone’u secin
        // 9. “amount” kutusuna bir sayi girin
        // 10. “US Dollars” in secilmedigini test edin
        // 11. “Selected currency” butonunu secin
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //      kontrol edin.




    }
}
