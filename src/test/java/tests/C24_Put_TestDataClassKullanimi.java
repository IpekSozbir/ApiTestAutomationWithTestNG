package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Put_TestDataClassKullanimi extends BaseUrlJsonPlaceHolder {

    @Test
    public void test() {
          /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda
        donen response’in
            status kodunun 200,
            content type’inin “application/json; charset=utf-8”,
            Connection header degerinin “keep-alive”
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
         Request Body
            {
            "title":"Ipek",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
        Response body (Expected Data) :
            {
            "title":"Ipek",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
      */

        // 1- EndPoint ve Request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        JSONObject requestBody = TestDataJsonPlaceHolder.JsonBodyOlustur(10,70,"Ipek","Merhaba");

        // 2- Expected data hazirlama
        JSONObject expectedData = TestDataJsonPlaceHolder.JsonBodyOlustur(10,70,"Ipek","Merhaba");

        // 3- Request gonderme ve Response kaydetme
        Response response = given().contentType(ContentType.JSON).spec(specJsonPlaceHolder)
                            .when().body(requestBody.toString())
                            .put("/{pp1}/{pp2}");

        // 4- Assertion islemleri
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("Connection"));

        JsonPath responseJP = response.jsonPath();
        assertEquals(expectedData.getInt("id"),responseJP.getInt("id"));
        assertEquals(expectedData.getInt("userId"),responseJP.getInt("userId"));
        assertEquals(expectedData.getString("title"),responseJP.getString("title"));
        assertEquals(expectedData.getString("body"),responseJP.getString("body"));
    }
}
