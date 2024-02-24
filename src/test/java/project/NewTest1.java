package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest1 {
	WebDriver driver;
	PageObject obj;
	@Test(priority=1)
	void Login1()
	{
		obj=new PageObject(driver);
		obj.submitButton();
		Assert.assertEquals(obj.getAlertText(),"Please enter a valid user name");
	}
	@Test(priority=2)
	void forgotLogin()
	{
		obj.forgotPass();
		obj.pressNext();
		Assert.assertEquals(obj.getAlertText(),"Please enter your email ID");
	}
	@Test(priority=3)
	void PrivacyNewTab()
	{
		obj.goBack();
		obj.privacyPol();
		Assert.assertEquals(obj.getTitle(),"Welcome to rediff.com");
	}
	
	  @BeforeClass
	  @Parameters({"browser"})
	  public void beforeClass(String br) {
		  if(br.equals("chrome"))
			  driver=new ChromeDriver();
		  else if(br.equals("edge"))
			  driver=new EdgeDriver();
			  
		  driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		  driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }
}