
# 3 senaryo olusturup apple, samsung, ve headphone aratin ve urun bulunabildigini test edin

  Feature: US1003 kullanici parametre olarak istedigi kelimeyi aratir
    Background:
      Given kullanici toUrl adresine gider

    Scenario: TC07 kullanici apple arattiginda urun bulabilmeli
      When arama kutusuna "apple" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And bulunan sonuc sayisinin 2'den fazla oldugunu test eder
      #feature dosyasinda int bir deger yazilirsa cucumber parametre olarak kabul eder
      And sayfayi kapatir

    Scenario: TC08 kullanici samsung arattiginda urun bulabilmeli
      When arama kutusuna "samsung" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And bulunan sonuc sayisinin 2'den fazla oldugunu test eder
      And sayfayi kapatir

    Scenario: TC09 kullanici headphone arattiginda urun bulabilmeli
      When arama kutusuna "headphone" yazip aratir
      Then arama sonucunda urun bulunabildigini test eder
      And bulunan sonuc sayisinin 1'den fazla oldugunu test eder
      And sayfayi kapatir