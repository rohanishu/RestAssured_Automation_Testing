package api.test;

import org.testng.annotations.Test;

import api.endpoints.PojoUser;
import api.endpoints.UserEndPoints;
import api.utilities.DataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DataDriverTest {

	
	@Test(priority=1,dataProvider="allData",dataProviderClass=DataProviders.class)
	public void testPostUser(String userid,String userName, String fname, String lname, String userEmail, String pwd, String phone)
	
	{
		PojoUser user=new PojoUser();
		
		user.setId(Integer.parseInt(userid));
		user.setUsername(userName);
		user.setFirstName(fname);
		user.setLastName(lname);
		user.setEmail(userEmail);
		user.setPassword(pwd);
		user.setPhone(phone);
		
		Response res=UserEndPoints.createUser(user);
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	
	
	
}
