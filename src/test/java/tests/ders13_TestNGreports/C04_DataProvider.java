package tests.ders13_TestNGreports;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProvider {
    @DataProvider
    public static Object[][] aranacaklarListesi() {

      Object [][] urunList={{"Nutella"},{"Samsung"},{"oyuncak"},{"dolap"},{"cucumber"}};


        return urunList;
    }

    @Test (dataProvider = "aranacaklarListesi")
    public void test01(String urunIsmi){



        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage=new AmazonPage();

        amazonPage.aramaKutusuElementi.sendKeys(urunIsmi+ Keys.ENTER);

    }
}
