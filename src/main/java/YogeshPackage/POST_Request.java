package YogeshPackage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_Request
{
    @Test
    public void validatePostRequest()
    {
        //Creating Base URI
        RestAssured.baseURI = "https://reqres.in/api/";
        
        //Creating Request Object
        RequestSpecification httprequest = RestAssured.given();
        
        //Creating Payload
        JSONObject reqBody = new JSONObject();
        reqBody.put("name", "Akash");

        //Creating Header
        httprequest.header("Content-Type","application/json");

        //Adding Payload in request
        httprequest.body(reqBody.toJSONString());

        //Creating Response Object
        Response response = httprequest.request(Method.POST, "users");

        //Printing response body
        String resBody = response.getBody().asString();
        System.out.println("response body: "+ resBody);

        //Validating status code
        int statuscode = response.getStatusCode();
        System.out.println("Status code: "+ statuscode);
        Assert.assertEquals(statuscode, 201);

    }
}
