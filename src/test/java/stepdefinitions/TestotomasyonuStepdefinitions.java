package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

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

        String unExpectedSonuc = "0 Products Found";
        String actualSonuc = testOtomasyonuPage.aramaSonucuElementi.getText();
        Assertions.assertNotEquals(actualSonuc,unExpectedSonuc);

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

    @Then("sisteme giris yapamadigini test eder")
    public void sistemeGirisYapilamadiginiTestEder() {

        try {
            // sisteme giris yapilamadigini email kutusunun hala gorunur olmasi ile test edelim
            Assertions.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());

        } catch (NoSuchElementException e) {
            // eger NoSuchElementException olustu ise
            // giris yapilamamasi gerektigi halde GIRIS YAPILDI demektir
            // Bu durumda TEST FAILED olmali ancak calismaya devam etmesini de saglamaliyiz

            // once giris yaptiysa logout olalim
            testOtomasyonuPage.logoutButonu.click();
            // sonra testin failed olmasini saglayalim
            Assertions.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());
        }

    }

    @Then("bulunan urunlerden ilkini tiklar")
    public void bulunanUrunlerdenIlkiniTiklar() {
        testOtomasyonuPage.bulunanUrunElementleriList.get(0).click();
    }

    @And("acilan sayfadaki urun isminde case sensitive olmadan {string} bulundugunu test eder")
    public void acilanSayfadakiUrunIsmindeCaseSensitiveOlmadanBulundugunuTestEder(String expectedIsimIcerik) {

        String actualIsim = testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText();

        Assertions.assertTrue(actualIsim.toLowerCase().contains(expectedIsimIcerik));
    }

    @And("acilan ilk urun sayfasindaki urun ismini yazdirir")
    public void acilanIlkUrunSayfasindakiUrunIsminiYazdirir() {
        System.out.println(testOtomasyonuPage.ilkUrunSayfasiIsimElementi.getText());
    }

    @When("email olarak diret verilen {string} girer")
    public void emailOlarakDiretVerilenGirer(String direktVerilenEmail) {
        testOtomasyonuPage.loginEmailKutusu.sendKeys(direktVerilenEmail);
    }

    @And("password olarak direkt verilen {string} girer")
    public void passwordOlarakDirektVerilenGirer(String direktVerilenPassword) {
        testOtomasyonuPage.loginPasswordKutusu.sendKeys(direktVerilenPassword);
    }


}
