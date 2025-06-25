package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Test;
import testDatalari.TestDataDummyExample;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Get_DeSerialization extends BaseUrlDummyExample {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
        Expected Response Body
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000.0,
                    "employee_age":66.0,
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void test01() {
        // 1- EndPoint ve request body olusturma
        specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2- Expected data hazirlama
        Map<String,Object> expectedData = TestDataDummyExample.bodyOlusturMap();

        // 3- Request gonderme ve Response'i kaydetme
        Response response = given().spec(specDummyExample).when().get("/{pp1}/{pp2}");

        // 4- Assertion islemleri
        Map<String,Object> responseMap = response.as(HashMap.class);
        assertEquals(TestDataDummyExample.contentType,response.contentType());
        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());

        assertEquals(expectedData.get("message"),responseMap.get("message"));
        assertEquals(expectedData.get("status"),responseMap.get("status"));

        assertEquals(((Map)expectedData.get("data")).get("profile_image")
                    ,((Map)responseMap.get("data")).get("profile_image"));
        assertEquals(((Map)expectedData.get("data")).get("employee_name")
                    ,((Map)responseMap.get("data")).get("employee_name"));
        assertEquals(((Map)expectedData.get("data")).get("employee_salary")
                    ,((Map)responseMap.get("data")).get("employee_salary"));
        assertEquals(((Map)expectedData.get("data")).get("employee_age")
                    ,((Map)responseMap.get("data")).get("employee_age"));
    }
}
