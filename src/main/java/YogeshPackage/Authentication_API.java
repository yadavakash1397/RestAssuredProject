package YogeshPackage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
// Authentication API example using Bearer token
public class Authentication_API
{
    @Test
    public void createUser()
    {
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";

        RequestSpecification httprequest = RestAssured.given();

        JSONObject jsonbody = new JSONObject();
        jsonbody.put("name", "Yogi");
        jsonbody.put("gender", "male");
        jsonbody.put("email", "Yogi123@gmail.com");
        jsonbody.put("status", "active");

        //Adding Headers for content type and authentication
        httprequest.header("Content-Type", "application/json");
        httprequest.header("Authorization","Bearer efb442b668c11d57b234abdcc3b7047a4f3b7db5fcd9961fcbc7dc2c55aa8b03");

        //Adding body
        httprequest.body(jsonbody.toJSONString());

        Response responseobj = httprequest.request(Method.POST, "users");

        //Printing result
        int statuscode = responseobj.getStatusCode();
        System.out.println("Status code: "+ statuscode);
        //validating body
        String resBody = responseobj.getBody().asString();
        System.out.println("response Body: "+ resBody);

       // Validating StatusCode
        Assert.assertEquals(statuscode, 201);

        //validating response body
        Assert.assertEquals(resBody.contains("Yogi123@gmail.com"), true);
    }
}
