package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class C10_JsonPathKullanimi {

    @Test
    public void method01(){

        JSONObject kisiBilgileriJsonObj= new JSONObject();
        JSONObject adresJsonObj = new JSONObject();
        JSONArray telefonBilgileriArr = new JSONArray();
        JSONObject cepTelefonuJsonObj = new JSONObject();
        JSONObject evTelefonuJsonObj = new JSONObject();

        adresJsonObj.put("streetAddress","naist street");
        adresJsonObj.put("city","Nara");
        adresJsonObj.put("pstalCode", "630-0192");

        cepTelefonuJsonObj.put("type","iphone");
        cepTelefonuJsonObj.put("number","0123-4567-8888");

        evTelefonuJsonObj.put("type","home");
        evTelefonuJsonObj.put("number","0123-4567-8910");

        telefonBilgileriArr.put(cepTelefonuJsonObj);
        telefonBilgileriArr.put(evTelefonuJsonObj);

        kisiBilgileriJsonObj.put("firstname","John");
        kisiBilgileriJsonObj.put("lastname","doe");
        kisiBilgileriJsonObj.put("age",26);
        kisiBilgileriJsonObj.put("address",adresJsonObj);
        kisiBilgileriJsonObj.put("phoneNumbers",telefonBilgileriArr);

        System.out.println(kisiBilgileriJsonObj);

        System.out.println("firstname: " + kisiBilgileriJsonObj.get("firstname"));
        // JsonPath'le kompleks Json objesinin icindeki spesifik bilgilere ulasabilecegimiz gibi
        // intelliJ üzerinden boyle yazdirarak da o spresifik bilgiye ulasabiliriz

        System.out.println("Street: " + kisiBilgileriJsonObj.getJSONObject("address").get("streetAddress"));
        // inner bi objenin bilgisine ulasmak icin

        System.out.println("city: " + kisiBilgileriJsonObj.getJSONObject("address").get("city"));

        System.out.println("cep telefon no: " + kisiBilgileriJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        // Array varsa once array'e sonra icindeki objeye ulasip sonra icindeki bilgiyi istiyoruz

    }
}
