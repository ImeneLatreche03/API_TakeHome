package testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

import baseRequest.BaseTest;
import baseRequest.RequestCalls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.PropertiesFile;

public class TC_Response_Code_401 extends BaseTest {

	// make call request with an empty token
	
	RequestCalls request;
	String endpoint;
	String token = "";
	Response response;
	String baseUri = PropertiesFile.getBaseUri();

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = baseUri;
	}

	@Test
	public void unAuthorizedResponse() {

		test=extent.createTest("TC_ResponseCode_401");
		request = new RequestCalls();
		endpoint = "/v2/users";
		JSONObject body = new JSONObject();
		body.put("name", "Imeneuuu"+x);
		body.put("gender", "male");
		body.put("email", "danipsoonaas"+ x+"@15ce.com");
		body.put("status", "active");

		response = request.postCall(token, body, endpoint);
		Assert.assertEquals(response.statusCode(), 401);

	}
}
