package AkashPackage;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POST_Req
{
    @Test
    void Postreq()
    {
        //base uri
        RestAssured.baseURI="https://reqres.in/";
        //req object
        RequestSpecification reqobj=RestAssured.given();
        //header set
        reqobj.header("Content-Type","application/json");
        //json object for json req body
        JSONObject jsondata=new JSONObject();
        jsondata.put("Name","Yoga");
        jsondata.put("gender","male");
        jsondata.put("email","akash@gmail.com");
        //attaching body to req obj
        reqobj.body(jsondata.toJSONString());
        //send req and save response
        Response response=reqobj.request(Method.POST,"/api/users");
        //validate response
        //1.statusline
        Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 201 Created");
        //2.statuscode
        Assert.assertEquals(response.getStatusCode(),201);
        //3.response body
        System.out.println("response body is "+response.getBody().asString());
        String Name=response.jsonPath().get("Name");
        Assert.assertEquals(Name,"Yoga");
        //4.print all headers
        Headers headers=response.headers();
        System.out.println("Headers list : ");
        for(Header header:headers)
        {
           String headerName  =header.getName();
           String headervalue =header.getValue();
           System.out.println(headerName+":"+headervalue);
        }
        //5.validate header value
        String headervalue=response.header("Server");
        Assert.assertEquals(headervalue,"cloudflare");

        //6.pass aunthentication
//        PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
//        auth.setUserName("");
//        auth.setPassword("");
//        RestAssured.authentication=auth;








    }
}
