package tests.day11_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.WorkbookDocument;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        String dosyaYolu = "src/test/java/tests/day11_excelOtomasyonu/ulkeler.xlsx";
        // Eger excel dosyası proje içerisinde değilde
        // masaüstü dowload gbi başka bir klasörün içerisinde ise
        // dosya yolu dinamik hale getirilebilir.

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        /*
            oluşturduğumuz workbook bizim excelimizi canlı olarak kullanmaz.
            24.satir çalıştığında
            fis'deki yani verdiğimiz dosyaYolun da olan excel deki
            tüm bilgileri alıp bu class da oluşturduğumuz
            workbook objesine yükler

            YANI workbook objesi excel'deki bilgilerin bir kopyasına sahip olur

            workbook'da bir değişiklik yaparasak
            ana excel değişmez
            Eger ana excel'in değişmesini istiyorsak
            işlem bitikten sonra
            yani class ın en sonunda
            workbook'daki yeni hali excel'e kaydetmemiz gerekir.
         */

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3);
        Cell cell = row.getCell(2);

        System.out.println(cell);
        // excel de satir ve sutun numaralari index kullanır
        // yani sıfırdan başlar.

        //12. satirdaki Azerbaycan ın İngilizce başkent isminin Bakü olduğunu test edin.

        Row onikincisatir = sheet.getRow(11);
        Cell ingilizceBaskent = onikincisatir.getCell(1);

        String expectedBaskentIsmi = "Baku";
        String actualBaskentIsmi = ingilizceBaskent.toString();
        Assert.assertEquals(expectedBaskentIsmi, actualBaskentIsmi);



    }
}
