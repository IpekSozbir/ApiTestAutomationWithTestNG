package tests;

import baseUrl.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlJsonPlaceHolderRestapi extends BaseUrlJsonPlaceHolder {

    //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin


    @Test
    public void test01() {
        //1-  https://jsonplaceholder.typicode.com/posts endpointine
        //    bir GET request gonderdigimizde donen response’un
        //    status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin

        // 1- EndPoint ve Request body hazirlama
        specJsonPlaceHolder.pathParam("pp1","posts");

        // 2- Expected data hazirlama

        // 3- Request gonderme ve Response'i kaydetme
        Response response = given().when().spec(specJsonPlaceHolder)
                .get("/{pp1}");

        // 4- Assertion islemleri

        response.then().assertThat()
                .statusCode(200)
                .body("title",Matchers.hasSize(100));
    }


    @Test
    public void test02() {
        //2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        //   bir GET request gonderdigimizde donen response’un
        //   status code’unun 200 oldugunu
        //   ve “title” degerinin “optio dolor molestias sit” oldugunu test edin

        // 1- EndPoint ve Request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);

        // 2- Expected data hazirlama

        // 3- Request gonderme ve Response'i kaydetme
        Response response= given().when().spec(specJsonPlaceHolder)
                            .get("/{pp1}/{pp2}");

        // 4- Assertion islemleri

        response.then().assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

    @Test
    public void test03() {
        //3- https://jsonplaceholder.typicode.com/posts/50 endpointine
        //   bir DELETE request gonderdigimizde donen response’un
        //      status code’unun 200 oldugunu
        //      ve response body’sinin null oldugunu test edin

        // 1- EndPoint ve Request body hazirlama
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",50);

        // 2- Expected data hazirlama

        // 3- Request gonderme ve Response'i kaydetme
        Response response = given().when().spec(specJsonPlaceHolder).delete("/{pp1}/{pp2}");

        // 4- Assertion islemleri
        response.then().assertThat()
                .statusCode(200)
                .body("title",Matchers.nullValue());
        // body'nin null oldugunu test edebilmek icin body icinde oldugunu bildigimiz bir key'i yazip Null Value methodunu kullabiliriz

    }

}
