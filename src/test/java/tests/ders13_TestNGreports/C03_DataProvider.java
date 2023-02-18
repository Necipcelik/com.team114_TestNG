package tests.ders13_TestNGreports;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {
    @DataProvider
    public static Object[][] kullaniciListesi() {

        Object[][] kullanicilar={{"ali","1234"},{"veli","543"},{"recep","432"},{"necip","974"},{"defne","045"}};

        return kullanicilar;
    }

    @Test (dataProvider = "kullaniciListesi")
    public void negatifLoginTesti(String username,String password) throws InterruptedException {
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        // cookies'i kabul edin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        // Login linkine tiklayin
        qualitydemyPage.ilkLoginLinki.click();
        // gecerli kullanici adi ve gecersiz password yazip
        Thread.sleep(2000);
        qualitydemyPage.emailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);
        Thread.sleep(2000);
        // login butonuna bastiginizda
        qualitydemyPage.loginButonu.click();
        // basarili olarak giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());
        // ve sayfayi kapatin
        Driver.closeDriver();
    }
}
