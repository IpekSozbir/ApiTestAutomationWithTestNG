package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class P10_POST_ExpectedDataJsonPathAssertion {

    /*

https://restful-booker.herokuapp.com/booking url'ine
asagidaki body'ye sahip bir POST request gonderdigimizde
donen response'un id haric asagidaki gibi oldugunu test edin.

Request body
      {
        "firstname": "Ipek",
        "lastname": "S",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }

Response Body - Expected Data
 {
    "bookingid": 24,
    "booking": {
        "firstname": "Ipek",
        "lastname": "S",
        "totalprice": 500,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        additionalneeds": "wi-fi"
    }
}

 */

    @Test
    public void test() {

        // 1- EndPoint ve reqBody hazirlama
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject innerData = new JSONObject();
        innerData.put("checkin", "2021-06-01");
        innerData.put("checkout", "2021-06-10");


        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Ipek");
        reqBody.put("lastname","S");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",true);
        reqBody.put("bookingdates",innerData);
        reqBody.put("additionalneeds","wi-fi");


        // 2- Expected Data olusturma
        JSONObject expBody = new JSONObject();
        expBody.put("bookingid",499);
        expBody.put("booking",reqBody);


        // 3- Response kaydi
        Response response = given().contentType(ContentType.JSON).body(reqBody.toString()).post(url);


        // 4- Assertion islemleri
        // Donen cevabi JsonPath formatina cevirelim
        JsonPath resJP = response.jsonPath();

       assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
       assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
       assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
       assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
       assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));
       assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
               resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                resJP.get("booking.bookingdates.checkout"));
    }
}
