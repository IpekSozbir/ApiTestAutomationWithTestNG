package testDatalari;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceHolder {

    public static int basariliSorguStatusCode = 200;
    public static String contentType="application/json; charset=utf-8";
    public static String headerConnection="keep-alive";


    public static JSONObject responseBodyOlustur22() { // 22 nolu id icin
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expectedData;
    }

    public static JSONObject JsonBodyOlustur(int userId, int id, String title, String body) {
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body",body);

        return expectedData;
    }

    public static Map<String,Object> bodyOlusturMap () {
        Map<String,Object> bodyMap =  new HashMap<>();
        bodyMap.put("title","Ipek");
        bodyMap.put("body","S");
        bodyMap.put("userId",10.0);
        bodyMap.put("id",70.0);

        return bodyMap;
    }

}
