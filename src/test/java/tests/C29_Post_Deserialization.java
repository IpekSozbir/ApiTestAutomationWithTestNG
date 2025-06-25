package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testDatalari.TestDataHerokuapp;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Post_Deserialization extends BaseUrlHerokuapp {

    /*
       https://restful-booker.herokuapp.com/booking url’ine
       asagidaki body'ye sahip bir POST request gonderdigimizde
       donen response’un id haric asagidaki gibi oldugunu test edin.
                           Request body
                      {
                           "firstname" : "Ipek",
                           "lastname" : “Sozbir",
                           "totalprice" : 500,
                           "depositpaid" : false,
                           "bookingdates" : {
                                    "checkin" : "2021-06-01",
                                    "checkout" : "2021-06-10"
                                             },
                           "additionalneeds" : "wi-fi"
                       }
                           Response Body // expected data
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
                           ,
                           "additionalneeds":"wi-fi"
                       }
        */
    @Test
    public void test(){

        // 1- EndPoint ve Request body olusturma
        specHerokuapp.pathParam("pp1","booking");

        Map<String,Object> requestBodyMap = TestDataHerokuapp.requestBodyOlusturMap();

        // 2- Expected data olusturma
        Map<String,Object> expectedData = TestDataHerokuapp.responseBodyOlusturMap();

        // 3- Request gonderme ve Response'i kaydetme
        Response response = given().contentType(ContentType.JSON).spec(specHerokuapp)
                            .when().body(requestBodyMap).post("/{pp1}");

        // 4- Assertion islemleri
        Map<String,Object> responseMap = response.as(HashMap.class);
        assertEquals(((Map)expectedData.get("booking")).get("firstname")
                            ,((Map)responseMap.get("booking")).get("firstname"));
        assertEquals(((Map)expectedData.get("booking")).get("lastname")
                ,((Map)responseMap.get("booking")).get("lastname"));
        assertEquals(((Map)expectedData.get("booking")).get("additionalneeds")
                ,((Map)responseMap.get("booking")).get("additionalneeds"));
        assertEquals(((Map)expectedData.get("booking")).get("totalprice")
                ,((Map)responseMap.get("booking")).get("totalprice"));
        assertEquals(((Map)expectedData.get("booking")).get("depositpaid")
                ,((Map)responseMap.get("booking")).get("depositpaid"));

        assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkin")
                    ,((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(((Map)((Map)expectedData.get("booking")).get("bookingdates")).get("checkout")
                ,((Map)((Map)responseMap.get("booking")).get("bookingdates")).get("checkout"));




    }
}
