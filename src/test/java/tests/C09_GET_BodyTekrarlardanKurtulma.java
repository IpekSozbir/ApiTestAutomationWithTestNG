package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_GET_BodyTekrarlardanKurtulma {

    @Test
    public void test(){
        /*
    https://restful-booker.herokuapp.com/booking/10 url'ine
    bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application-json,
        ve response body'sindeki
           "firstname"in, "Marry",
        ve "lastname"in, "Jones",
        ve "totalprice"in, 1000'den kucuk oldugunu
        ve "depositpaid"in, true,
        ve "additionalneeds"in, bos olmadigini test edin
         */


        // 1- EndPoint ve Request body hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Expected body hazirlama - soruda yok

        // 3- Request gonderme ve Response kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion islemleri
        /* Bu ilk yontem:
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mary"))
                .body("lastname",Matchers.equalTo("Jones"))
                .body("totalprice",Matchers.lessThan(1000))
                .body("depositpaid",Matchers.equalTo(true))
                .body("additionalneeds",Matchers.notNullValue());
         */

        // Bu tekrarlardan arinmis yontem:
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Mary"),
                        "lastname", equalTo("Jones"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(true),
                        "additinonalneeds",notNullValue()
                );
    }
}
