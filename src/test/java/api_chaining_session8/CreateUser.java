package api_chaining_session8;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.path.json.JsonPath;

public class CreateUser {

	
	@Test
	void test_createUser(ITestContext context)
	{
		Faker faker=new Faker();
		
		JSONObject json=new JSONObject();
		json.put("name", faker.name().fullName());
		json.put("gender", "Male");
		json .put("email",faker.internet().emailAddress());
		json.put("status","inactive");
		
		String bearertoken="f954babbdb0569b1874e61e61c3081e6a6386f77ebd9b5ff49a812e03e4f18b6";
		
		int id=given()
		
			.headers("Authorizataion","Bearer "+bearertoken)
			.contentType("application/json")
			.body(json.toString())
			
		//JsonPath js=new JsonPath(id);
			
		.when()
			.post("https://gorest.co.in/public/v2/users");
			.jsonPath().getInt("id");
			
			context.setAttribute("user_id",id);
		
		
		
		
		
	}
}
