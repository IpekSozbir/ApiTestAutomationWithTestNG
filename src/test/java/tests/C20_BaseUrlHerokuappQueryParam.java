package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class C20_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    @Test
    public void test() {
             /*

        "https://restful-booker.herokuapp.com"/booking endpointine
        gerekli Query parametrelerini yazarak
            “firstname” degeri “Susan” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde,
        donen response’un
            status code’unun 200 oldugunu
            ve “Susan” ismine sahip 1 booking oldugunu test edin

         */


        // 1- EndPoint ve Request body hazirlama
        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Susan");

        // 2- Expected data olusturma

        // 3- Request gonderme ve Response kaydetme
        Response response = given().when().spec(specHerokuapp).get("/{pp1}");

        // 4- Assertion islemleri
        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(greaterThanOrEqualTo(1)));
    }
}
