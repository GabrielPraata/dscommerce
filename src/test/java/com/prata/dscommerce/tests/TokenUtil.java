package com.prata.dscommerce.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static io.restassured.RestAssured.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Component
public class TokenUtil {

	@Value("${security.client-id}")
	private String clientId;

	@Value("${security.client-secret}")
	private String clientSecret;
	
	public String obtainAccessToken(MockMvc mockMvc, String username, String password) throws Exception {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "password");
		params.add("client_id", clientId);
		params.add("username", username);
		params.add("password", password);

		ResultActions result = mockMvc
				.perform(post("/oauth2/token")
						.params(params)
						.with(httpBasic(clientId, clientSecret))
						.accept("application/json;charset=UTF-8"))
						.andExpect(status().isOk())
						.andExpect(content().contentType("application/json;charset=UTF-8"));

		String resultString = result.andReturn().getResponse().getContentAsString();

		JacksonJsonParser jsonParser = new JacksonJsonParser();
		return jsonParser.parseMap(resultString).get("access_token").toString();
	}

	public static String obtainAccessToken(String username, String password) throws JSONException {
		Response response = authRequest(username, password);
		JsonPath jsonBody = response.jsonPath();
		return jsonBody.getString("access_token");
	}

	private static Response authRequest(String username, String password) {
		return given()
				.auth()
				.preemptive()
				.basic("myclientid", "myclientsecret")
				.contentType("application/x-www-form-urlencoded")
				.formParam("grant_type", "password")
				.formParam("username", username)
				.formParam("password", password)
				.when()
				.post("/oauth2/token");
	}
}
