package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class TestotomasyonuStepdefinitions {

    TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

    @Given("kullanici toUrl adresine gider")
    public void kullanici_to_url_adresine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
    }
    @Then("arama kutusuna phone yazip aratir")
    public void arama_kutusuna_phone_yazip_aratir() {
       testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("toAranacakKelime")+ Keys.ENTER);
    }
    @Then("arama sonucunda urun bulunabildigini test eder")
    public void arama_sonucunda_urun_bulunabildigini_test_eder() {
        Assertions.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>0);

    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
       Driver.quitDriver();
    }

    @Then("arama kutusuna dress yazip aratir")
    public void aramaKutusunaDressYazipAratir() {
        testOtomasyonuPage.aramaKutusu.sendKeys("dress", Keys.ENTER);
    }

    @Then("arama kutusuna nutella yazip aratir")
    public void aramaKutusunaNutellaYazipAratir() {
        testOtomasyonuPage.aramaKutusu.sendKeys("nutella", Keys.ENTER);
    }

    @And("arama sonucunda urun bulunamadigini test eder")
    public void aramaSonucundaUrunBulunamadiginiTestEder() {

        String expectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = testOtomasyonuPage.aramaSonucuElementi.getText();

        Assertions.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @When("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String istenenKelime) {
        testOtomasyonuPage.aramaKutusu.sendKeys(istenenKelime + Keys.ENTER);
    }

    @And("bulunan sonuc sayisinin {int}'den fazla oldugunu test eder")
    public void bulunanSonucSayisininDenFazlaOldugunuTestEder(int minSonucSayisi) {
      Assertions.assertTrue(testOtomasyonuPage.bulunanUrunElementleriList.size()>minSonucSayisi);
    }
}
