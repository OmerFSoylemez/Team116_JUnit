package tests.day06_JUnit_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_YouTubeAssertion {

            // 2) https://www.youtube.com adresine gidin
            // 3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
            //      ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
            //      ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
            //      ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
            //      ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");

        // cookies kabul eder
        // driver.findElement....
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void TitleTesti(){
        //○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();YoutubeLogoTesti();

        Assert.assertEquals(expectedTitle,actualTitle);
    }


    @Test
    public void YoutubeLogoTesti(){
        //○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement YouTubeLogoElementi = driver.findElement(By.xpath("(//a[@id='logo'])[1]"));
        Assert.assertTrue(YouTubeLogoElementi.isDisplayed());
    }


    @Test
    public void searchBoxTesti(){
        //○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
        WebElement SearchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(SearchBox.isEnabled());


    }
    @Test
    public void wrongTitleTesti(){
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitle = "youtube" ;
        String actualTitle = driver.getTitle();

        Assert.assertFalse(unexpectedTitle.equals(actualTitle));

    }
}
