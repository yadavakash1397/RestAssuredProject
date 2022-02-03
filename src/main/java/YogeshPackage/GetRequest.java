package YogeshPackage;


import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequest
{
    @Test
    public void validateGetMethod()
    {
      //Specify base URL
      RestAssured.baseURI = "https://reqres.in/api/users/";

      //Create request Object
        RequestSpecification httpReq = RestAssured.given();

       //Create Response Object
        Response response = httpReq.request(Method.GET, "2");

        //Printing Response
        String resBody = response.getBody().asString();
        System.out.println("Response Body: "+ resBody);

        //Validating response code
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: "+ statusCode);
        Assert.assertEquals(statusCode, 200);

        //Validating status line
        String statusLine = response.getStatusLine();
        System.out.println("Status Line: "+ statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
