package tests.day05_maven_JUnitFramework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class test3 extends TestBase {

    // 1. “https://www.saucedemo.com” Adresine gidin
    // 2. Username kutusuna “standard_user” yazdirin
    // 3. Password kutusuna “secret_sauce” yazdirin
    // 4. Login tusuna basin
    // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
    // 6. Add to Cart butonuna basin
    // 7. Alisveris sepetine tiklayin
    // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
    // 9. Sayfayi kapatin

    @Test
    public void Test01 () {

        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        bekle(5);

        // 2. Username kutusuna “standard_user” yazdirin
        bekle(3);
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[1]")).sendKeys("standard_user");
        bekle(3);

        // 3. Password kutusuna “secret_sauce” yazdirin
        bekle(3);
        driver.findElement(By.xpath("(//input[@class='input_error form_input'])[2]")).sendKeys("secret_sauce");
        bekle(3);

        // 4. Login tusuna basin
        bekle(2);
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        bekle(2);


        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        bekle(2);
        String urunIsmi = driver.findElement(By.xpath("//a[@id='item_4_title_link']")).getText();
        driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
        bekle(2);


        // 6. Add to Cart butonuna basin
        bekle(2);
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
        bekle(2);


        // 7. Alisveris sepetine tiklayin
        bekle(2);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        bekle(2);


        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        // ??????????????????????????????


        // 9. Sayfayi kapatin
        driver.close();

    }
}
