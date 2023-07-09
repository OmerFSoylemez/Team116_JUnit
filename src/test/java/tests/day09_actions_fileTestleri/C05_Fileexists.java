package tests.day09_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C05_Fileexists {

    @Test
    public void test01 () {
        // C:\Users\asus\Downloads\avatar.png

        /*
            Bir dosyanın bilgisayarımızda olduğunu test etmek çok kolaydır
            Ancak testimizin dinamik olmasını sağlamak
            yani hangi bilgisayarda çalıştırılırsa çalıştırılsın
            testin doğru çalışabilmesi için
            dosya yoluna çalışmamız gerekir
         */

        // bir dosyanın bilgisayarımızda var olsuğunu test etmek istersek

        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\asus\\Downloads\\avatar.png")));
    }

    @Test
    public void dinamikTest() {

        //dosya yolunu dinamik yapalım

        // C:\Users\asus\Downloads\avatar.png

        //Java da dosya yolunu bize veren 2 adet kod var

        //1- çalıştığımız klasörün dosya yolunu almak isterseniz
        System.out.println(System.getProperty("user.dir"));


        //2-bilgisayarımızın ana dosya yolu

        System.out.println(System.getProperty("user.home"));
        //


        // bu bilgileri kullanarak
        // indirdiğimiz dosyanın dinamik dosya yolunu elde etmek istersek
        // iki parçada elde edebiliriz
        // System.getProperty("user.home") +herkeste ayni olan kısım

        String dinamikDosyaYolu = System.getProperty("user.home") + "/Dowloads/avatar.png";

        System.out.println(dinamikDosyaYolu);//C:\Users\asus/Dowloads/avatar.png

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));


    }

    }

