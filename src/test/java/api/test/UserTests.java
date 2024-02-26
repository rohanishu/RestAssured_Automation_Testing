package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PojoUser;
import api.endpoints.UserEndPoints;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests {

	Faker faker;
	
	PojoUser user;
	
	@BeforeClass
	public void setupData()
	{
		faker=new Faker();
		
		user=new PojoUser();
		
		
		user.setId(faker.idNumber().hashCode());
		user.setUsername(faker.name().username());
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().safeEmailAddress());
		user.setPassword(faker.internet().password(5, 10));
		user.setPhone(faker.phoneNumber().cellPhone());
		
		
		/*
		user.setId(faker.idNumber().hashCode());
		user.setUsername(faker.name().username());
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		user.setEmail(faker.internet().safeEmailAddress());
		user.setPassword(faker.internet().password(5, 10));
		user.setPhone(faker.phoneNumber().cellPhone());
		*/
		
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		Response res=UserEndPoints.createUser(user);
		
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	
	@Test(priority=2)
	public void testgetUser()
	{
		Response res=UserEndPoints.readUser(this.user.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
	}
	
	@Test(priority=3)
	public void testupdateUser()
	{
		// update data using payload
		// this will create new username, firstname & lastname
		
		user.setUsername(faker.name().username());
		user.setFirstName(faker.name().firstName());
		user.setLastName(faker.name().lastName());
		
		
		Response res=UserEndPoints.updateUser(this.user.getUsername(), user);
		
		Assert.assertEquals(res.getStatusCode(), 200);
		
		//checking the updated username by passing the details getUser
		Response resafterUpdate=UserEndPoints.readUser(this.user.getUsername());
		res.then().log().all();
		Assert.assertEquals(resafterUpdate.getStatusCode(),200);
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		Response res=UserEndPoints.deleteUser(this.user.getUsername());
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	
	
}
