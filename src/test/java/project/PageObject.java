package project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObject {
	WebDriver driver;
	
	PageObject(WebDriver driver)
	{
		this.driver=driver;
	}
	By signInLink=By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]");
	By forgotPasswordLink=By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[3]/div[2]/span/a");
	By next=By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/input[2]");
	By privacyPolicy=By.xpath("/html/body/div[1]/div[3]/a[2]");
	public void submitButton()
	{
		driver.findElement(signInLink).click();
	}
	public void forgotPass()
	{
		driver.findElement(forgotPasswordLink).click();
	}
	public void pressNext()
	{
		driver.findElement(next).click();
	}
	public void privacyPol()
	{
		driver.findElement(privacyPolicy).click();
	}
	public void goBack()
	{
		driver.navigate().back();
	}
	public String getTitle()
	{
    	String pageTitle="";
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow))
            	driver.switchTo().window(windowHandle);
             pageTitle = driver.getTitle(); 
             }
        return pageTitle;
	}
	public String getAlertText()
	{
	      Alert alert=driver.switchTo().alert();
	      String alertText = alert.getText();
	      alert.accept();
	      return alertText;
	}
	
}
