package AkashPackage;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;


public class demo1_GET_Req
{
    @Test
    public void getrequestvalidation()
    {
        String statusLine="HTTP/1.1 200 OK";
        int statusCode=200;

        //URl set
        RestAssured.baseURI="https://reqres.in";

        //create req object with URL
       RequestSpecification req=RestAssured.given();

       //send GET request and save response
        Response res=req.request(Method.GET,"/api/users?page=2");

        //validate response status code
        System.out.println("Response code:"+res.getStatusCode());
        Assert.assertEquals(statusCode,res.getStatusCode());

        //validate response status line
        System.out.println("status line:"+res.getStatusLine());
        Assert.assertEquals(statusLine,res.getStatusLine());

        //print response body
        System.out.println("Response body:"+res.getBody().asString());
    }

}
