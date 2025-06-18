package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import testDatalari.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C23_Get_TestDataClassKullanimiDinamik extends BaseUrlJsonPlaceHolder {

    @Test
    public void test() {
          /*
        https://jsonplaceholder.typicode.com/posts/40 url'ine
        bir GET request yolladigimizda
        donen response’in
            status kodunun 200
            ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Response body :
        {
            "userId":4,
            "id":40,
            "title":"enim quo cumque",
            "body":"ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
        }
     */


        // 1- Endpoint ve Request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","40");

        // 2- Expected data olusturma
        JSONObject expectedData = TestDataJsonPlaceHolder.JsonBodyOlustur(4,40,"enim quo cumque","ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam");

        // 3- Request gonderme ve Response kaydetme
        Response response = given().when().spec(specJsonPlaceHolder).get("/{pp1}/{pp2}");

        // 4- Assertion islemleri
        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());

        JsonPath responseJsonPath = response.jsonPath();
        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));

    }
}
