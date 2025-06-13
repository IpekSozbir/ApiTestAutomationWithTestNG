package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp2 extends BaseUrlHerokuapp {

    /*
        2- https://restful-booker.herokuapp.com/booking endpointine
        asagidaki body’ye sahip bir POST request gonderdigimizde
        donen response’un
            status code’unun 200 oldugunu
            ve “firstname” degerinin “Ipek” oldugunu test edin

            {
            "firstname" : "Ipek",
            "lastname" : “S",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                   "checkin" : "2021-06-01",
                   "checkout" : "2021-06-10"
                      },
            "additionalneeds" : "wi-fi" }
         */


    @Test
    public void test() {

        // 1- EndPoint ve Request body hazirlama
        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleriJsonObj = new JSONObject();

        rezervasyonTarihleriJsonObj.put("checkin", "2021-06-01");
        rezervasyonTarihleriJsonObj.put("checkout", "2021-06-10");

        requestBody.put("firstname", "Ipek");
        requestBody.put("lastname", "S");
        requestBody.put("totalprice", 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates",rezervasyonTarihleriJsonObj);
        requestBody.put("additionalneeds", "wi-fi");

        // 2- Expected data olusturma

        // 3- Request gonderme ve Response'i kaydetme
        Response response = given().contentType(ContentType.JSON)
                            .when().spec(specHerokuapp).body(requestBody.toString())
                            .post("/{pp1}");

        // 4- Assertion islemleri
        response.then().assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Ipek"));



    }
}
