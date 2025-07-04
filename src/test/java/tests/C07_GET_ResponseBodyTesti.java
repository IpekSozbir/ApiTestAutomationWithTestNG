package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_GET_ResponseBodyTesti {

    @Test
    public void test(){
         /*
    https://jsonplaceholder.typicode.com/posts/44 url'ine
    bir GET request yolladigimizda
    donen Response'in
    status code'unun 200,
    ve content type'inin application/json,
    ve response body'sinde bulunan userId'nin 5,
    ve response body'sinde bulunan title'in "optio dolor molestias sit"
    oldugunu test edin
            */


        // 1- EndPoint ve Request body hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Expected body hazirlama
        // Donen responseda bir/birkac degeri test etmekle, butun response'i tek bir deger olarak test etmek farkli seyler
        // Bu soruda response'i degil icindeki degerleri test ediyoruz dolayısıyla expected body olusturmayacagiz

        // 3- Request gonderme ve donen response'ı kaydetme
        Response response = given().when().get(url);

        // 4- Assetion islemleri
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId",Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
