package tests.ders11_testNGFramework;

import org.testng.annotations.Test;

public class C02_dependsOnMethods {
    @Test(priority = 5)
    public void amazontest() {

        System.out.println("amazon");
    }

    @Test(priority = -1,dependsOnMethods = "amazontest")
    public void youtubetest() {
        System.out.println("youtube");

    }

    @Test
    public void wisequartertest() {

        System.out.println("wise quarter");
    }

    @Test(priority = 4)
    public void bestbuytest() {


        System.out.println("bestbuy");


    }
}
