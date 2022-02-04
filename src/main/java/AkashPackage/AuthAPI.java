package AkashPackage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthAPI
{
    @Test
    void authenticationAPI()
    {
        RestAssured.baseURI= "https://gorest.co.in/public/v2/";
        RequestSpecification reqobj=RestAssured.given();
        reqobj.header("Content-Type","application/json");
        reqobj.header("Authorization","Bearer efb442b668c11d57b234abdcc3b7047a4f3b7db5fcd9961fcbc7dc2c55aa8b03");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name", "ak");
        jsonObject.put("gender", "male");
        jsonObject.put("email", "ak134@gmail.com");
        jsonObject.put("status", "active");
        reqobj.body(jsonObject.toJSONString());

        Response response=reqobj.request(Method.POST,"users");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(),201);

    }
}
