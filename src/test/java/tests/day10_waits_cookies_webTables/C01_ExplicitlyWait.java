package tests.day10_waits_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {


        // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
        //     Iki metod icin de asagidaki adimlari test edin.
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        // 4. Remove butonuna basin.
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        // 6. Add buttonuna basin
        // 7. It’s back mesajinin gorundugunu test edin

    @Test
    public void implicitlyWaitTest () {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");


        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();


        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement Itsgone = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(Itsgone.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();


        // 7. It’s back mesajinin gorundugunu test edin
        WebElement ItsBackElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(ItsBackElementi.isDisplayed());
        driver.close();

    }
    @Test
    public void explicitlyWaitTesti() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();


        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));

        /*
            visibilityOf() method'u bize 2 seçenek sunuyor
           - Eger webelementi locate edebiliyorsak, önce locate edip
             sonra o elementi istenen condation için beklemesini isteyebiliriz
           - Eger kullanacağımız elementi locate EDEMİYORSAK
             o zaman locate islemi ile bekleme işlemini birlikte yapabiliriz
         */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));
        WebElement itsGoneElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();


        // 7. It’s back mesajinin gorundugunu test edin
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement ItsBackElementi = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(ItsBackElementi.isDisplayed());
        driver.close();

    }

}
