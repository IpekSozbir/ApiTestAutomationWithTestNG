package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_PUT_ResponseBilgileriAssertion {

    @Test
    public void test() {

         /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile bir PUT request gonderdigimizde
    {
        "title":"Ipek",
        "body":"Merhaba",
        "userId":10,
        "id":70
    }
        donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin cloudflare,
        ve status Line’in HTTP/1.1 200 OK oldugunu assert edin.

     */

        // 1- EndPoint ve request body hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject requestBody = new JSONObject();
        requestBody.put("title","Ipek");
        requestBody.put("body","Merhaba");
        requestBody.put("userId",10);
        requestBody.put("id",70);

        // 2- Expected body hazirlama

        // 3- Request gonderme ve donen response'i kaydetme
        Response response = given()
                            .contentType(ContentType.JSON)
                            .when()
                            .body(requestBody.toString())
                            .put(url);


        // 4- Assertion islemleri
        response.then().assertThat()
                        .statusCode(200)
                        .contentType("application/json; charset=utf-8")
                        .header("Server","cloudflare")
                        .statusLine("HTTP/1.1 200 OK");

    }
}
