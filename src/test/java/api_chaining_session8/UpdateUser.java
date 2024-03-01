package api_chaining_session8;

import org.json.JSONObject;

import com.github.javafaker.Faker;

public class UpdateUser {

	
	
	
	void test_updateUser()
	{
		Faker faker=new Faker();
		
		JSONObject js=new JSONObject();
		
		js.put("name",faker.name().fullName());
		js.put("gender","Male");
		js.put("email",faker.internet().emailAddress());
		js.put("status","active");
		
	}
}
