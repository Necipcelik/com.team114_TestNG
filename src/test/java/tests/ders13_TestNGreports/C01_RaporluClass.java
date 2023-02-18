package tests.ders13_TestNGreports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluClass extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("nutella testi","kullanici aradigi sonuclara ait icerik göruyor mu");
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasina gidildi");
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusuElementi.sendKeys("nutella"+ Keys.ENTER);

        String exeptedIcerik="nutella";
        String actualIcerik=amazonPage.aramaSonucYaziElementi.getText();
        Assert.assertTrue(actualIcerik.contains(exeptedIcerik));
        extentTest.pass("test gecti");
    Driver.closeDriver();
    }
}
