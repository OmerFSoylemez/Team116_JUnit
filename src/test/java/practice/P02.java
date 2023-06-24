package practice;

import org.junit.*;

public class P02 {

    @BeforeClass
    public static void beforeClass(){System.out.println("Before Class çalıştı");}

    @AfterClass
    public static void afterClass(){System.out.println("After Class çalıştı");}

    @Before
    public void before() {System.out.println("Yeni bir test çalışıyor");}

    @After
    public void after() {System.out.println("Test sonlandırıldı sıradaki testlere geçiliyor");}

    @Test
    public void test01 () {
        System.out.println("1 Numaralı test çalışıyor");
    }

    @Test
    public void test02 () {
        System.out.println("2 Numaralı test çalışıyor");
    }

}
