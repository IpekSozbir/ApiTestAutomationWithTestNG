# 🌐 ApiTestAutomationWithTestNG

Bu repository, **Java** dili kullanılarak geliştirilmiş, **Rest-Assured + TestNG** tabanlı **REST API test otomasyonu** örneklerini içermektedir.  
Proje; farklı HTTP metodları, JSON doğrulamaları, POJO modelleme ve TestNG yapısı ile uçtan uca API test senaryolarının nasıl kurgulanacağını öğretmeyi amaçlayan kapsamlı bir eğitim ve pratik çalışmasıdır.

Testler; gerçek servisler üzerinde GET, POST, PUT ve DELETE işlemleri ile response doğrulamaları yapacak şekilde senaryolaştırılmıştır.

---

## 🎯 Projenin Amacı

- REST API servislerini otomasyon ile test etmek  
- HTTP metodlarının (GET, POST, PUT, DELETE) kullanımını öğrenmek  
- Response body ve status code doğrulamaları yapmak  
- JSONPath ile alan bazlı doğrulama gerçekleştirmek  
- POJO classları ile serialization & deserialization işlemlerini kavramak  
- TestNG ile organize edilmiş test yapısı oluşturmak  

---

## 🛠️ Kullanılan Teknolojiler ve Araçlar

| Teknoloji | Açıklama |
|----------|----------|
| **Java 17** | Test otomasyon dili |
| **Rest-Assured** | REST API test otomasyonu |
| **TestNG** | Test yönetimi ve assertion yapısı |
| **Gson** | JSON ↔ Java dönüşümleri |
| **org.json** | JSON objesi oluşturma ve işleme |
| **Maven** | Proje bağımlılık yönetimi |
| **IntelliJ IDEA** | Geliştirme ortamı (IDE) |

---

## 📦 Bağımlılıklar (pom.xml)

Projede kullanılan temel kütüphaneler:

- Rest-Assured → API testlerini gerçekleştirmek için  
- TestNG → Test senaryolarını çalıştırmak ve organize etmek için  
- Gson → Serialization & Deserialization işlemleri için  
- org.json → JSON objesi oluşturma ve yönetme işlemleri için  
- JUnit → Yardımcı test anotasyonları (test scope)  

---

## 📁 Proje Yapısı

```ApiTestAutomationWithTestNG/
├── .idea/
├── src/
│ └── test/
│     └── java/
│         ├── baseUrl/                # API endpoint base URL yapılandırmaları
│         │   ├── BaseUrlDummyExample.java
│         │   ├── BaseUrlHerokuapp.java
│         │   └── BaseUrlJsonPlaceholder.java
│         │
│         ├── pojos/                  # Request/Response body için POJO classları
│         │   ├── pojosHavaDurumu/
│         │   ├── PojoDummyExampleData.java
│         │   ├── PojoDummyExampleResponse.java
│         │   ├── PojoHerokuappBookingdates.java
│         │   ├── PojoHerokuappRequestBody.java
│         │   ├── PojoHerokuappResponseBody.java
│         │   └── PojoJsonPlaceholder.java
│         │
│         ├── testDatalari/           # Testlerde kullanılan statik/dinamik test verileri
│         │   ├── TestDataDummyExample.java
│         │   ├── TestDataHerokuapp.java
│         │   └── TestDataJsonPlaceholder.java
│         │
│         └── tests/                  # Tüm API test senaryoları
│             ├── C01_GETRequest_ResponseBodyYazdirma.java
│             ├── C02_GETApiResponseBilgilerinintestEdilmesi.java
│             ├── C03_GET_ResponseDegerleriniOtomasyonIleTestEtme.java
│             ├── C04_JsonObjesiOlusturma.java
│             ├── C05_JsonObjesiOlusturma.java
│             ├── C06_PUT_ResponseBilgileriAssertion.java
│             ├── C07_GET_ResponseBodyTesti.java
│             ├── C08_POST_ResponseBodyTesti.java
│             ├── C09_GET_BodyTekrarlardanKurtulma.java
│             ├── C10_JsonPathKullanimi.java
│             ├── C11_POST_JsonPathIleBodyTesti.java
│             ├── C12_GET_ResponseBodyTestiListKullanimi.java
│             ├── C13_ExpectedDataOlusturma.java
│             ├── C14_Post_ExpectedDataVeJsonPathIleAssertion.java
│             ├── C15_Get_SoftAssertIleExpectedDataTesti.java
│             ├── C16_Put_SoftAssertIleExpectedDataTesti.java
│             ├── C17_BaseUrlJsonPlaceHolderRestapi.java
│             ├── C18_BaseUrlHerokuapp.java
│             ├── C19_BaseUrlHerokuapp2.java
│             ├── C20_BaseUrlHerokuappQueryParam.java
│             ├── C21_BaseUrlHerokuappQueryParam.java
│             ├── C22_Get_TestDataClassKullanimi.java
│             ├── C23_Get_TestDataClassKullanimiDinamik.java
│             ├── C24_Put_TestDataClassKullanimi.java
│             ├── C25_Get_TestDataClassKullanimi.java
│             ├── C26_Post_TestDataClassKullanimi.java
│             ├── C27_Put_DeSerialization.java
│             ├── C28_Get_DeSerialization.java
│             ├── C29_Post_Deserialization.java
│             ├── C30_Put_PojoClass.java
│             ├── C31_Post_Pojo.java
│             ├── C32_Get_Pojo.java
│             └── C33_Post_Pojo.java
│
├── pom.xml
├── .gitignore
└── README.md

```
---

## 🧪 Test Yapısı ve Mantığı

* Testler Rest-Assured + TestNG kullanılarak yazılmıştır
* Her sınıf belirli bir endpoint veya test senaryosuna odaklanır
* JSON response'lar:
   * JSONPath
   * POJO deserialization
   * SoftAssert / HardAssert kullanılarak doğrulanır
* Projede uygulanan başlıca senaryolar:
* GET request ile veri çekme ve doğrulama
* POST request ile veri oluşturma testleri
* PUT request ile güncelleme testleri
* JSON objesi oluşturma ve gönderme
* TestData class kullanarak dinamik veri üretimi
* Serialization & Deserialization işlemleri
* SoftAssert ile çoklu doğrulamalar

---

  ## ▶️ Projeyi Çalıştırma Adımları

1. Repository'i klonlayın:
```
git clone https://github.com/IpekSozbir/ApiTestAutomationWithTestNG.git
```
2. IntelliJ IDEA ile projeyi açın

3. Maven bağımlılıklarını yükleyin:
```
mvn clean install
```
4. Tüm testleri çalıştırmak için:
```
mvn test
```
5. İsterseniz belirli bir test sınıfını IDE üzerinden çalıştırabilirsiniz.

---

## 📝 Lisans
Bu proje kişisel eğitim ve portföy amaçlıdır.
API test otomasyonu üzerine edindiğim bilgileri uygulamalı olarak pekiştirdiğim bir çalışmadır.
