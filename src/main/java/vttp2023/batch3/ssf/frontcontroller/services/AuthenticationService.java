package vttp2023.batch3.ssf.frontcontroller.services;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp2023.batch3.ssf.frontcontroller.Model.User;

@Service
public class AuthenticationService {

	// TODO: Task 2
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write the authentication method in here
	public String authenticate(String username, String password) throws Exception {

		User user = new User(username, password);
		// JsonObject userJson = user.toJson();

		RestTemplate template = new RestTemplate();

		String apiUrl = "https://authservice-production-e8b2.up.railway.app/api/authenticate";

		ResponseEntity<String> response = template.postForEntity(apiUrl, user, String.class);

		// JsonReader jsonReader = Json.createReader(new StringReader(response.getBody()));
		// JsonObject responseJsonObject = jsonReader.readObject();


		// String responseString = responseJsonObject.getString("message");
		// System.out.println(responseString);

		InputStream is = new ByteArrayInputStream(response.getBody().getBytes());
		JsonReader jr = Json.createReader(is);
		JsonObject responseJsonObject = jr.readObject();

		String responseString = responseJsonObject.getString("message");
		System.out.println(responseString);
		


		if (responseString.contains("Authenticated")) {

			return "view1";

		} 
		else {

			return "view0.1";

		}

	}





	// TODO: Task 3
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write an implementation to disable a user account for 30 mins
	public void disableUser(String username) {
	}

	// TODO: Task 5
	// DO NOT CHANGE THE METHOD'S SIGNATURE
	// Write an implementation to check if a given user's login has been disabled
	public boolean isLocked(String username) {
		return false;
	}
}
