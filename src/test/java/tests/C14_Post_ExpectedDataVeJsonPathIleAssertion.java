package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test(){
          /*
        https://restful-booker.herokuapp.com/booking url’ine
        asagidaki body'ye sahip bir POST request gonderdigimizde
        donen response’un id haric asagidaki gibi oldugunu test edin.

        Request body
        {
        "firstname" : "Ipek",
        "lastname" : "Sozbir",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            },
        "additionalneeds" : "wi-fi"
        }

        Expected Response Body
        {
        "bookingid":24,
        "booking":{
            "firstname":"Ipek",
            "lastname":"Sozbir",
            "totalprice":500,
            "depositpaid":false,
            "bookingdates":{
                "checkin":"2021-06-01",
                "checkout":"2021-06-10"
                },
        "additionalneeds":"wi-fi"
        }
        }
         */


        // 1- EndPoint ve Request body olusturma
        String url = "https://restful-booker.herokuapp.com/booking";
        JSONObject requestBody = new JSONObject();
        JSONObject rezervasyonTarihleriJson = new JSONObject();

        rezervasyonTarihleriJson.put("checkin","2021-06-01");
        rezervasyonTarihleriJson.put("checkout","2021-06-10");

        requestBody.put("firstname","Ipek");
        requestBody.put("lastname","Sozbir");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid", false);
        requestBody.put("bookingdates",rezervasyonTarihleriJson);
        requestBody.put("additionalneeds", "wi-fi");

        // 2- Expected data olusturma
        JSONObject expectedData = new JSONObject();
        expectedData.put("bookingId",24);
        expectedData.put("booking",requestBody);

        // 3- Request gonderme ve Respponse'i kaydetme
        Response response = given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString())
                            .post(url);

        // 4- Assertion islemleri
        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                responseJsonPath.get("booking.additionalneeds"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));

        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));

    }
}
