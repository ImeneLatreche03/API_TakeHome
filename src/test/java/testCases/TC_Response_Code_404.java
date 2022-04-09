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

public class TC_Response_Code_404 extends BaseTest {

	//update data that is already deleted
	
		RequestCalls request;
		String endpoint;
		String token = PropertiesFile.getToken();
		String baseUri=PropertiesFile.getBaseUri();
		String id="";
		Response response;
		String param;
		
		@BeforeTest
		public void setup() {
			RestAssured.baseURI = baseUri;
		}
		
		@Test(priority=1)
		public void verifyUserCreated() {
			request = new RequestCalls();
			endpoint = "/v2/users";
			JSONObject body = new JSONObject();
			body.put("name", "lilina"+x);
			body.put("gender", "male");
			body.put("email", "lilina"+ x+"@15ce.com");
			body.put("status", "active");
			
			response = request.postCall(token, body , endpoint);
			
			Assert.assertEquals(response.statusCode(),201);
			 id=response.jsonPath().getString("id");
			 
		}
		
		@Test(priority=2)
		public void verifyUserDeleted() {

			request = new RequestCalls();
			endpoint="/v2/users/"+id;
			response= request.deleteCall(token, endpoint);
			Assert.assertEquals(response.statusCode(),204);
		}
		
		@Test(priority=3)
		public void verifyUserUpdated() {
			test=extent.createTest("TC_ResponseCode_404");
			endpoint="/v2/users/"+id;
			JSONObject body = new JSONObject();
			body.put("name", "lilyanaza"+x);
		request = new RequestCalls();
		response= request.patchCall(token, body, endpoint);
		Assert.assertEquals(response.statusCode(),404);
		System.out.println(response.getBody().asString());
		
		}
}
