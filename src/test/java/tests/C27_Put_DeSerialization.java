package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Put_DeSerialization extends BaseUrlJsonPlaceHolder {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body
        {
            "title":"Ipek",
            "body":"S",
            "userId":10.0,
            "id":70.0
        }

        Expected Response Body:
        {
            "title":"Ipek",
            "body":"S",
            "userId":10.0,
            "id":70.0
        }
     */

    @Test
    public void test01(){

        // 1- EndPoint ve Request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        // Request body'i Map olarak olusturalim
        Map<String, Object> requestBodyMap = TestDataJsonPlaceHolder.bodyOlusturMap();

        // 2- Expected data olusturma
        Map<String,Object> expectedData = TestDataJsonPlaceHolder.bodyOlusturMap();

        // 3- Request gonderme ve Response'i kaydetme
        Response response = given().contentType(ContentType.JSON).spec(specJsonPlaceHolder)
                            .when().body(requestBodyMap)
                            .put("/{pp1}/{pp2}");

        // 4- Assertion islemleri
          // expected Response body'i Map olarak olusturduk
          // bize donecek actual response'in data turu iser Response
          // Assertion yapabilmemiz icin response'i Map'e cevirmemiz lazim (De-serialization)

        Map<String,Object> responseMap = response.as(HashMap.class);

        assertEquals(expectedData.get("title"),requestBodyMap.get("title"));
        assertEquals(expectedData.get("body"),requestBodyMap.get("body"));
        assertEquals(expectedData.get("id"),requestBodyMap.get("id"));
        assertEquals(expectedData.get("userId"),requestBodyMap.get("userId"));
    }
}
