package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.ReusableMethods;

public class PozitifLoginTesti {

    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

    @Then("account butonuna basar")
    public void account_butonuna_basar() {
       testOtomasyonuPage.accountLinki.click();
    }
    @Then("email olarak {string} girer")
    public void email_olarak_girer(String configdenAlinacakEmail) {

       testOtomasyonuPage.loginEmailKutusu.sendKeys(ConfigReader.getProperty(configdenAlinacakEmail));
    }
    @Then("password olarak {string} girer")
    public void password_olarak_girer(String configdenAlinacakPassword) {
        testOtomasyonuPage.loginPasswordKutusu.sendKeys(ConfigReader.getProperty(configdenAlinacakPassword));
    }
    @Then("signIn butonuna basar")
    public void sign_ın_butonuna_basar() {
        testOtomasyonuPage.loginSignInButonu.click();
    }
    @Then("basarili giris yapilabildigini test eder")
    public void basarili_giris_yapilabildigini_test_eder() {
        Assertions.assertTrue(testOtomasyonuPage.logoutButonu.isDisplayed());
    }
    @Then("{int} saniye bekler")
    public void saniye_bekler(Integer int1) {
        ReusableMethods.bekle(int1);
    }

}
