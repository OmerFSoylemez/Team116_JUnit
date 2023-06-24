package tests.day07_testBase_dropdown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseIlkTest extends TestBase {

    //Bir cclass'in test class'i olarak kullanabilmesi için
    //oncelikle WebDriver ayarlarinin yapıilması ve obje oluşturması gerekir
    //Java OOP consept çerçevesinde WebDriver objesinin illa da bu class'da olması şart değildir
    //Başka class'daki özellikleri sahiplenmenin en kolay yolu o class'i parent edilmektir

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        bekle(3);
    }
}
