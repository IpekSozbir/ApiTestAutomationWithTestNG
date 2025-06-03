package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_POST_JsonPathIleBodyTesti {

    @Test
    public void test(){
         /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
            {
            "firstname" : "Ipek",
            "lastname" : “S",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2023-01-10",
                "checkout" : "2023-01-20"},
            "additionalneeds" : "wi-fi"
            }

         donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ipek",
                ve "lastname“in, "S",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2023-01-10
                ve "checkout" tarihinin 2023-01-20
                ve "additionalneeds“in,"wi-fi"
             oldugunu test edin

         */

        // 1- EndPoint ve Request body hazirlama
        String url = " https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleriJson = new JSONObject();

        rezervasyonTarihleriJson.put("checkin","2023-01-10");
        rezervasyonTarihleriJson.put("checkout","2023-01-20");

        requestBody.put("firstname","Ipek");
        requestBody.put("lastname","S");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates",rezervasyonTarihleriJson);
        requestBody.put("additionalneeds", "wi-fi");

        // 2- Expected data olusturma - soruda yok

        // 3- Request gonderme ve Response kaydetme
        Response response = given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString())
                            .post(url);

        // 4- Assertion islemleri
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("booking.firstname", equalTo("Ipek"),
                        "booking.lastname",equalTo("S"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(false),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"),
                        "booking.bookingdates.checkout",equalTo("2023-01-20"),
                        "booking.additionalneeds",equalTo("wi-fi"));
    }
}
