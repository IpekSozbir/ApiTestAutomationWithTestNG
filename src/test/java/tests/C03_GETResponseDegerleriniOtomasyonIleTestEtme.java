package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_GETResponseDegerleriniOtomasyonIleTestEtme {

    @Test
    public void test(){
        /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Heroku,
    ve status Line’in HTTP/1.1 200 OK
     otomasyonla assert ediniz.
         */

        // 1- Response body ve EndPoint hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected data hazirlama - soruda yok

        // 3- Request gonderip donen response'u kaydetme
        Response response = given().when().get(url);

        // 4- Assertion
        response
                .then()
                .assertThat().statusCode(200)
                             .contentType("application/json; charset=utf-8")
                             .header("Server", "Heroku")
                             .statusLine("HTTP/1.1 200 OK");
    }
}
