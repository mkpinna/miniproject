package project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class miniproject {
    private static WebDriver driver;

    public void createBrowser() {
    	driver =new ChromeDriver();
    }
    
    public void closeBrowser() {
        driver.quit();
    }
    
    public void navigateToURL(String url) {
        driver.navigate().to(url);
    }

    public void maximizeWindow()
    {
		driver.manage().window().maximize();
    }
    
    public void clickSignInLink() {
        WebElement signInLink = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input[2]"));
        signInLink.click();
    }
    
    public String getAlertText() {
    	Alert alert=driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
    
    public void clickForgotPasswordLink() {
        WebElement forgotPasswordLink =driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/form/div[1]/div[3]/div[2]/span/a"));
        forgotPasswordLink.click();
    }
    
    public void clickNext() {
        WebElement Next =driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div[1]/input[2]"));
        Next.click();
    }
    
    public void clickPrivacypolicy() {
        WebElement privacyPolicy =driver.findElement(By.xpath("/html/body/div/div[3]/a[2]"));
        privacyPolicy.click();
    }
    public void goPrevious()
    {
		driver.navigate().back();
    }
    
    public void closePage()
    {
		driver.close();
    }
    
    public String getNewTabTitle() {
    	String pageTitle="";
        String currentWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindow))
            	driver.switchTo().window(windowHandle);
             pageTitle = driver.getTitle(); 
  
        }
		return pageTitle;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		miniproject obj=new miniproject();
		obj.createBrowser();
		obj.navigateToURL("https://mail.rediff.com/cgi-bin/login.cgi");
		obj.maximizeWindow();
		obj.clickSignInLink();
		String firstAlert=obj.getAlertText();
		obj.clickForgotPasswordLink();
		obj.clickNext();
		String secondAlert=obj.getAlertText();
		obj.goPrevious();
		obj.clickPrivacypolicy();
		
		String newTabTitle=obj.getNewTabTitle();
		
		obj.closePage();
		
		if(firstAlert.equals("Please enter a valid user name"))
				System.out.println("Test Case 1 Passed");
		else
			System.out.println("Test Case 1 Failed");
		
		if(secondAlert.equals("Please enter your email ID"))
			System.out.println("Test Case 2 Passed");
		else
			System.out.println("Test Case 2 Failed");
		
		if(newTabTitle.equals("Welcome to rediff.com"))
			System.out.println("Test Case 3 Passed");
		else
			System.out.println("Test Case 3 Failed");
		
		
		obj.closeBrowser();
		Excel obj2=new Excel();
		obj2.excelsheet(firstAlert, secondAlert, newTabTitle);
    }
	}

  
