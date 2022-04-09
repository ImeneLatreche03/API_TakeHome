package testCases;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import baseRequest.BaseTest;
import baseRequest.RequestCalls;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import resources.PropertiesFile;

public class TC_SuccessResponseforEachCall extends BaseTest{
	String endpoint;
	String id = "";
	String body;
	Response response;
	RequestCalls request;
	String param;
	String token = PropertiesFile.getToken();
	String baseUri = PropertiesFile.getBaseUri();

	@BeforeTest
	public void setup() {
		RestAssured.baseURI = baseUri;
	}

	@Test(priority = 1)
	public void verifyUserCreated() {
		test=extent.createTest("TC_SuccessResponse_UserCreated");
		request = new RequestCalls();
		endpoint = "/v2/users";
		JSONObject body = new JSONObject();
		body.put("name", "imeneoo"+x);
		body.put("gender", "male");
		body.put("email", "imeneoo."+ x +"@gmail.com");
		body.put("status", "active");

		response = request.postCall(token, body, endpoint);
		System.out.println("After creating user:"+response.getBody().asString());

		Assert.assertEquals(response.statusCode(), 201);
		id = response.jsonPath().getString("id");
	}

	@Test(priority = 2)
	public void verifyResponseGetUserList() {
		test=extent.createTest("TC_SuccessResponse_GetUserList");

		endpoint = "/v2/users";
		request = new RequestCalls();
		response = request.getCall(endpoint);
		Assert.assertEquals(response.statusCode(), 200);

	}

	@Test(priority = 3)
	public void verifyResponseGetUserById() {

		test=extent.createTest("TC_SuccessResponse_GetUserById");
		endpoint = "/v2/users/" + id;
		request = new RequestCalls();
		response = request.getCallByInput(endpoint, token);
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("After getting user by Id"+response.getBody().asString());

	}

	@Test(priority = 4)
	public void verifyUserUpdated() {
		test=extent.createTest("TC_SuccessResponse_UserUpdated");
		endpoint = "/v2/users/" + id;
		JSONObject body = new JSONObject();
		body.put("name", "imenea"+x);
		request = new RequestCalls();
		response = request.patchCall(token, body, endpoint);
		Assert.assertEquals(response.statusCode(), 200);
		System.out.println("After updating" + response.getBody().asString());
	}

	@Test(priority = 5)
	public void verifyUserDeleted() {
		test=extent.createTest("TC_SuccessResponse_UserDeleted");
		request = new RequestCalls();
		endpoint = "/v2/users/" + id;
		response = request.deleteCall(token, endpoint);
		Assert.assertEquals(response.statusCode(), 204);
	}

	

}
