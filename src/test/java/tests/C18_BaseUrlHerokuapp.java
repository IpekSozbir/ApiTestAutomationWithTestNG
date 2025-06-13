package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C18_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    //1-  https://restful-booker.herokuapp.com/booking endpointine
    //    bir GET request gonderdigimizde
    //    donen response’un
    //          status code’unun 200 oldugunu
    //          ve Response’ta 1224 booking oldugunu test edin

    @Test
    public void test() {

        // 1- EndPoint ve Request body hazirlama
        specHerokuapp.pathParam("pp1","booking");

        // 2- Expected data olusturma

        // 3- Request gonderme ve Response kaydetme
        Response response = given().when().spec(specHerokuapp).get("/{pp1}");


        // 4- Assertion
        JsonPath responseJsonpath=response.jsonPath();
        System.out.println(responseJsonpath.getList("bookingid").size());

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(1224));

        // NOT : Her execute'da değer değişecegi icin test fail olacaktir

    }
}
