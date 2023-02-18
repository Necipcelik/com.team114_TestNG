package tests.ders12_assertions_POMGelistirmeler;

import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTest {
    @Test
    public void test01() throws InterruptedException {
        // Bir test methodu olusturun
        // qualitydemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        Thread.sleep(2000);
        // gecerli kullanici adi ve gecerli password yazip
        QualitydemyPage qualitydemyPage=new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        // login butonuna bastiginizda
        qualitydemyPage.loginButonu.click();
        // basarili olarak giris yapildigini test edin

        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
