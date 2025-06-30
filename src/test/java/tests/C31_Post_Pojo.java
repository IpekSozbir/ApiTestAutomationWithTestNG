package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoHerokuappBookingdates;
import pojos.PojoHerokuappRequestBody;
import pojos.PojoHerokuappResponseBody;

import static org.junit.Assert.assertEquals;

import static io.restassured.RestAssured.given;

public class C31_Post_Pojo extends BaseUrlHerokuapp {

     /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
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
    public void test() {
        // 1- EndPoint ve Request boy olusturma
        specHerokuapp.pathParam("pp1","booking");

        PojoHerokuappBookingdates bookingdatesPojo = new PojoHerokuappBookingdates("2021-06-01","2021-06-10");
        PojoHerokuappRequestBody requestBodyPojo = new PojoHerokuappRequestBody("Ipek","wi-fi",bookingdatesPojo,false,500,"Sozbir");

        // 2- Expected data hazirlama
        bookingdatesPojo = new PojoHerokuappBookingdates("2021-06-01","2021-06-10");
        PojoHerokuappRequestBody bookingPojo = new PojoHerokuappRequestBody("Ipek","wi-fi",bookingdatesPojo,false,500,"Sozbir");

        PojoHerokuappResponseBody expectedResponseBodyPojo = new PojoHerokuappResponseBody(24,bookingPojo);

        // 3- Request gonderme ve Response kaydetme
        Response response = given().contentType(ContentType.JSON).spec(specHerokuapp)
                            .when().body(requestBodyPojo)
                            .post("/{pp1}");

        // 4- Assertion islemleri
        PojoHerokuappResponseBody responsePojo = response.as(PojoHerokuappResponseBody.class);

        assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),responsePojo.getBooking().getLastname());
        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());
        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds()   );
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());



    }

}
