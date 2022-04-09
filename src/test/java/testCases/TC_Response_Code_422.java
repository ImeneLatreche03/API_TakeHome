package testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import baseRequest.BaseTest;
import baseRequest.RequestCalls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.PropertiesFile;

public class TC_Response_Code_422 extends BaseTest {

	RequestCalls request;
	String endpoint;
	Response response;
	String token = PropertiesFile.getToken();
	String baseUri = PropertiesFile.getBaseUri();

	
// repeated a post call with the same payload	
	@BeforeTest
	public void setup() {

		RestAssured.baseURI = baseUri;
	}

	@Test(priority = 1)
	public void verifyResponseGetUserById() {
		test=extent.createTest("getUserByID");
		request = new RequestCalls();
		endpoint = "/v2/users";
		JSONObject body = new JSONObject();
		body.put("name", "mimimi"+x);
		body.put("gender", "male");
		body.put("email", "mimimi."+ x+ "@15ce.com");
		body.put("status", "active");

		response = request.postCall(token, body, endpoint);

		Assert.assertEquals(response.statusCode(), 201);
	}

	@Test(priority = 2)
	public void repeatSameAction() {
		test=extent.createTest("TC_ResponseCode_422");
		request = new RequestCalls();
		endpoint = "/v2/users";
		JSONObject body = new JSONObject();
		body.put("name", "mimimi"+x);
		body.put("gender", "male");
		body.put("email", "mimimi."+ x+ "@15ce.com");
		body.put("status", "active");

		response = request.postCall(token, body, endpoint);

		Assert.assertEquals(response.statusCode(), 422);
		System.out.println(response.getBody().asString());
	}
}
