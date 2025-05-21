package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GETRequest_ResponseBodyYazdirma {

    @Test
    public void test(){
         /*
    https://restful-booker.herokuapp.com/booking/10 url’ine
     bir GET request gonderdigimizde donen Response’u yazdirin
     */

        // 1- EndPoint ve Request body hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected data hazirlama - soruda yok

        // 3- Response kaydi
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion islemleri - soruda yok
    }


}
