package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Put_SoftAssertIleExpectedDataTesti {

    @Test
    public void test() {
     /*
            http://dummy.restapiexample.com/api/v1/update/21 url’ine
            asagidaki body’ye sahip bir PUT request gonderdigimizde
            donen response’un asagidaki gibi oldugunu test edin.
            Request Body
                    {
                    "status": "success",
                    "data": {
                        "name": "Ipek",
                        "salary": "1230",
                        "age": "32",
                        "id": 40
                            }
                   }
            Response Body
                    {
                    "status": "success",
                    "data": {
                        "status": "success",
                        "data": {
                            "name": "Ipek",
                            "salary": "1230",
                            "age": "32",
                            "id": 40
                        }
                    },
                    "message": "Successfully! Record has been updated."
                }
      */

        // 1- EndPoint ve Request body hazirlama
        String url = "http://dummy.restapiexample.com/api/v1/update/21";
        JSONObject requestBody = new JSONObject();
        JSONObject dataBilgileriJsonObj = new JSONObject();

        dataBilgileriJsonObj.put("name","Ipek");
        dataBilgileriJsonObj.put("salary","1230");
        dataBilgileriJsonObj.put("age","32");
        dataBilgileriJsonObj.put("id",40);

        requestBody.put("status","success");
        requestBody.put("data",dataBilgileriJsonObj);

        // 2- Expected body hazirlama
        JSONObject expectedData = new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",requestBody);
        expectedData.put("message","Successfully! Record has been updated.");

        // 3- Request gonderme ve Response kaydetme
        Response response = given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString())
                            .put(url);

        // 4- Assertion islemleri
        JsonPath responseJsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(responseJsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedData.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.status"),expectedData.getJSONObject("data").get("status"));
        softAssert.assertEquals(responseJsonPath.get("data.data.name"),expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(responseJsonPath.get("data.data.id"),expectedData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.data.salary"),expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(responseJsonPath.get("data.data.age"),expectedData.getJSONObject("data").getJSONObject("data").get("age"));
        
        softAssert.assertAll();

    }
}
