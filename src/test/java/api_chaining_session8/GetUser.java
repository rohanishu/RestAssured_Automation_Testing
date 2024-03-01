package api_chaining_session8;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;


public class GetUser {

	
	
	void test_getUser(ITestContext context)
	{
		
		//This comes from create user class where we defined setAttribute
		int id = (int) context.getAttribute("user_id");
		
		
		String bearertoker="f954babbdb0569b1874e61e61c3081e6a6386f77ebd9b5ff49a812e03e4f18b6";
		
		
		
		given()
			.headers("Authorization","Bearer "+bearertoker)
			.pathParam("id",id)
			
	    .when()
	    	.get("https://gorest.co.in/public/v2/users/{id}")
	    .then()
	    	.statusCode(200);
		
			
			
	    	
	    	
	}
}
