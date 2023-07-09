package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P08 {

    //https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/ adresine gidin
    //Ülke menüsünü locate edin
    //Türkiye Seçeneğini seçin
    //Go to website butonuna tıklayın

    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

/*
    @After
    public void tearDown() {
        driver.close();
    }

 */
    @Test
    public void AmazonCountryTest () {
        driver.get("https://www.amazon.com/customer-preferences/country?ref_=icp_lop_mop_chg_ais&preferencesReturnUrl=/");



    //Ülke menüsünü locate edin
    WebElement ulkeManusu = driver.findElement(By.xpath("//*[@class='a-dropdown-prompt']"));
    ulkeManusu.click();


    //Türkiye Seçeneğini seçin
    WebElement turkiyeElementi = driver.findElement(By.xpath("//li[@aria-labelledby='icp-dropdown_18']"));
    turkiyeElementi.click();

    //Go to website butonuna tıklayın
    //WebElement GoToWebSiteElementi = driver.findElement(By.xpath("//span[@id='icp-save-button-announce']"));
    //GoToWebSiteElementi.click();



}
}