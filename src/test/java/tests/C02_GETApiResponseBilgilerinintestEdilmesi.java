package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GETApiResponseBilgilerinintestEdilmesi {

    @Test
    public void test() {
        /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
    bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

        // 1- Response body ve EndPoint hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";
        // Get request'in body'e ihtiyaci olmadigi icin request body olusturmuyoruz

        // 2- Expected data hazirlama
        // soruda donen response'un body'sinin söyle oldugunu test et demiyorsa gerek yok

        // 3- Request gonderip donen response'u kaydetme
        Response response = given().when().get(url);
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Content Type: " + response.getContentType());
        System.out.println("Server Isimli Header Degeri: " + response.getHeader("Server"));
        System.out.println("Status Line Degeri: " + response.getStatusLine());
        System.out.println("Response Suresi Degeri: " + response.getTime());


        // 4- Assertion

    }
}
