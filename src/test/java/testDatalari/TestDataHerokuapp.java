package testDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataHerokuapp {

    public static int basariliSorguStatusCode;
    public static String contentType= "application/json";

    public static JSONObject jsonRequestBodyOlustur () {

        JSONObject requestBody = new JSONObject();
        JSONObject bookingdatesBody = new JSONObject();

        bookingdatesBody.put("checkin","2021-06-01");
        bookingdatesBody.put("checkout","2021-06-10");

        requestBody.put("firstname","Ipek");
        requestBody.put("lastname","S");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingdatesBody);
        requestBody.put("additionalneeds","wi-fi");

        return requestBody;
    }

    public static JSONObject JsonResponseBodyOlustur (){
        JSONObject responseBody = new JSONObject();
        JSONObject bookingBody = jsonRequestBodyOlustur();

        responseBody.put("bookingId",24);
        responseBody.put("booking",bookingBody);

        return responseBody;
    }


    public static Map<String,Object> requestBodyOlusturMap() {
        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("firstname","Ipek");
        requestBodyMap.put("lastname","Sozbir");
        requestBodyMap.put("totalprice",500.0);
        requestBodyMap.put("depositpaid",false);
        requestBodyMap.put("bookingdates",bookingdatesOlusturMap());
        requestBodyMap.put("additionalneeds","wi-fi");

        return requestBodyMap;
    }

    public static Map<String,String> bookingdatesOlusturMap() {

        Map<String,String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin","2021-06-01");
        bookingdatesMap.put("checkout","2021-06-10");

        return bookingdatesMap;
    }

    public static Map<String,Object> responseBodyOlusturMap () {

        Map<String,Object> responseBodyMap = new HashMap<>();
        responseBodyMap.put("bookingId",24);
        responseBodyMap.put("booking",requestBodyOlusturMap());

        return responseBodyMap;
    }


}
