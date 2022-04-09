package baseRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import io.restassured.response.Response;

public class RequestCalls {
	Response response;

	public Response getCall(String endpoint) {
		response = given().header("Content-type", "application/json").when().get(endpoint).then().extract().response();
		return response;
	}

	public Response getCallByInput(String endpoint, String token) {
		response = given().header("Authorization", "Bearer " + token).header("Content-type", "application/json").when()
				.get(endpoint).then().extract().response();
		return response;
	}

	public Response postCall(String token, JSONObject body, String endpoint) {
		response = given().header("Authorization", "Bearer " + token).header("Content-type", "application/json").and()
				.body(body.toJSONString()).when().post(endpoint).then().extract().response();
		return response;
	}

	public Response patchCall(String token, JSONObject body, String endpoint) {
		response = given().header("Authorization", "Bearer " + token).header("Content-type", "application/json").and()
				.body(body.toJSONString()).when().patch(endpoint).then().extract().response();
		return response;
	}

	public Response deleteCall(String token, String endpoint) {
		response = given().header("Authorization", "Bearer " + token).header("Content-type", "application/json").when()
				.delete(endpoint).then().extract().response();
		return response;
	}

	public Response postCallWrong(String token, JSONObject body, String endpoint) {
		response = given().header("Authorization", "Bearer " + token).header("Content-type", "application/json").and()
				.body(body.toJSONString()).when().delete(endpoint).then().extract().response();
		return response;
	}

}
