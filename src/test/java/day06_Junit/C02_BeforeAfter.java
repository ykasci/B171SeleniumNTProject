package day06_Junit;

import org.junit.*;

public class C02_BeforeAfter {
    @BeforeClass
    public static void beforeClass() throws Exception {  // 1
        //Sadece Before classta static keyword var.
        System.out.println("Class'dan önce 1 kez çalışır");
    }

    @Before
    public void setUp() throws Exception {  //  2
        System.out.println("Her test methodundan önce bir kez @Before methodu çalışır");
    }

    @Test
    public void test01() {
        System.out.println("Test01 çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("Test02 çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("Test03 çalıştı");
    }

    @Test
    public void test04() {
        System.out.println("Test04 çalıştı");
    }

    @After //tearDown()
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kez @After çalışır");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'dan sonra 1 kez çalışır");
    }

    /*
    Bir class a 4 tane test methodu 1 tane before 1 tane after method varsa class'da toplam kaç method çalışmış olur?
     */

    /*
    Junit framework unde testlerimizi istediğimiz sıralamada çalıştırmak isterseniz alfabetik ve numerik olarak
    test methodlarımızı isimlendirmemiz gerekmektedir.
     */
}
