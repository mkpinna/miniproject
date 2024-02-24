package project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class NewTest {
    private static WebDriver driver;
  @Test(priority=1)
  public void test1() {
	  WebElement signInLink = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]"));
      signInLink.click();
      Alert alert=driver.switchTo().alert();
      String alertText = alert.getText();
      alert.accept();
	  Assert.assertEquals(alertText,"Please enter a valid user name");
  }
  @Test(priority=2)
  public void test2() {
      WebElement forgotPasswordLink =driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[3]/div[2]/span/a"));
      forgotPasswordLink.click();
      WebElement Next =driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/input[2]"));
      Next.click();
      Alert alert=driver.switchTo().alert();
      String secondText = alert.getText();
      alert.accept();
	  Assert.assertEquals(secondText,"Please enter your email ID");
  }
  @Test(priority=3)
  public void test3() {
		driver.navigate().back();
        WebElement privacyPolicy =driver.findElement(By.xpath("/html/body/div/div[3]/a[2]"));
        privacyPolicy.click();
    	String pageTitle="";
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow))
            	driver.switchTo().window(windowHandle);
             pageTitle = driver.getTitle(); 
  
        }
	  Assert.assertEquals(pageTitle,"Welcome to rediff.com");
  }
  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	  driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
