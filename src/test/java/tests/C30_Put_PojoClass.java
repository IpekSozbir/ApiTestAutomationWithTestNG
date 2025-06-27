package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoJsonPlaceholder;
import testDatalari.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Put_PojoClass extends BaseUrlJsonPlaceHolder {
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
            "body":"S",
            "userId":10,
            "id":70
            }
        Response body : // expected data
            {
            "title":"Ipek",
            "body":"S",
            "userId":10,
            "id":70
            }
     */


    @Test
    public void test() {

        // 1- EndPoint ve Request body olusturma
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        PojoJsonPlaceholder requestBodyPojo = new PojoJsonPlaceholder("Ipek","S",10,70);

        // 2- Expected data hazirlama
        PojoJsonPlaceholder expectedDataPojo = new PojoJsonPlaceholder("Ipek","S",10,70);

        // 3- Request gonderme ve Response'i kaydetme
        Response response = given().contentType(ContentType.JSON).spec(specJsonPlaceHolder)
                            .when().body(requestBodyPojo)
                            .put("/{pp1}/{pp2}");

        // 4- Assertion islemleri
         // expected data'yi pojo olarak hazirladik
         // ama response'in data turu Response
         // Bu ikisini karsilastirmak icin response'i da pojo yapalim
        PojoJsonPlaceholder responsePojo = response.as(PojoJsonPlaceholder.class);

        assertEquals(TestDataJsonPlaceHolder.basariliSorguStatusCode,response.statusCode());
        assertEquals(TestDataJsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestDataJsonPlaceHolder.headerConnection,response.header("Connection"));

        assertEquals(expectedDataPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedDataPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedDataPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedDataPojo.getId(),responsePojo.getId());

    }
}
