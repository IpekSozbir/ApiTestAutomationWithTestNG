package tests;

import baseUrl.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatalari.TestDataDummyExample;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Get_TestDataClassKullanimi extends BaseUrlDummyExample {

    @Test
    public void test01() {
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
                        "employee_salary":86000,
                        "employee_age":66,
                        "profile_image":""
                        },
                "message":"Successfully! Record has been fetched."
            }
         */

        // 1- EndPoint ve Request body olusturma
        specDummyExample.pathParams("pp1","employee","pp2","3");

        // 2- Expected data olusturma
        JSONObject expectedData = TestDataDummyExample.jsonResponseBodyOlustur(3,"Ashton Cox",86000,66,"");

        // 3 - Request gonderme ve Response kaydetme
        Response response = given().when().spec(specDummyExample).get("/{pp1}/{pp2}");

        // 4- Assertion islemleri
        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(TestDataDummyExample.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataDummyExample.contentType,response.contentType());
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),responseJsonPath.getString("data.profile_image"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),responseJsonPath.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"),responseJsonPath.getInt("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),responseJsonPath.getInt("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getInt("id"),responseJsonPath.getInt("data.id"));

    }

}
