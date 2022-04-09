package testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import baseRequest.BaseTest;
import baseRequest.RequestCalls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.PropertiesFile;

public class TC_Response_Code_405 extends BaseTest {

	// Made a post call with the wrong Http method ( used get())
	
	RequestCalls request;
	String endpoint;
	String token = PropertiesFile.getToken();
	String baseUri = PropertiesFile.getBaseUri();
	Response response;

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = baseUri;
	}

	@Test
	public void verifyUserCreatedWithWrongMethod() {
		test=extent.createTest("TC_ResponseCode_405");
		endpoint = "/v2/users";
		JSONObject body = new JSONObject();
		body.put("name", "Dnpralaa"+x);
		body.put("gender", "male");
		body.put("email", "Dnpralaa."+x+"@15ce.com");
		body.put("status", "active");

		request = new RequestCalls();
		response = request.postCallWrong(token, body, endpoint);
		Assert.assertEquals(response.statusCode(), 405," We are getting 404 instead of 405");
		;
	}
	
	
		
		
	
	
}

