package actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Cssselectors.Selectors;
import Data.Credentials;

public class Actions extends Selectors{
	Credentials obj= new Credentials();
	WebDriver driver;
public void navigateURL(String URL) throws IOException{
	//setting driver properties
	System.setProperty("webdriver.chrome.driver", "C:/workspace/GmailLogin/Drivers/chromedriver.exe");
	  //initializing driver ChromeDriver object
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(URL);
	ScreenCapture();
}
public void waitDriverForGivenSec() throws InterruptedException{
	//explicitly putting the driver to sleep for n seconds
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	Thread.sleep(3000);
}
public void loginGmail() throws IOException{
	//enter email id
driver.findElement(By.cssSelector(email)).sendKeys(Email_id);
//click on 'next' button
ScreenCapture();
driver.findElement(By.cssSelector(next)).click();
}
public void enterPassword() throws IOException{
	//Enter the password
	driver.findElement(By.cssSelector(password)).sendKeys(pwd);
	//click on sign in(next) button
	ScreenCapture();
	driver.findElement(By.cssSelector(signIn)).click();
}
public void composeEmail() throws InterruptedException, IOException{
	//click on compose button
	driver.findElement(By.cssSelector(composeButton)).click();
	 //Fill up sent to:
	addingEmail_ids();
	Thread.sleep(2000);
//	driver.findElement(By.cssSelector(mailTo)).sendKeys(mail_id);
	//Fill up Subject
	driver.findElement(By.cssSelector(subject)).sendKeys("Sending Email");
	//Fill up message content
	driver.findElement(By.cssSelector(messageContent)).sendKeys(message);
	//click on send button
	 Thread.sleep(4000);
	 ScreenCapture();
	driver.findElement(By.cssSelector(sendButton)).click();
}
public void addingEmail_ids() throws IOException{
//	driver.findElement(By.cssSelector(mailTo)).sendKeys(mail_id);
    for(String ids:emailids){
    	driver.findElement(By.cssSelector(mailTo)).sendKeys(ids);
    	driver.findElement(By.cssSelector(mailTo)).sendKeys(Keys.ENTER);
    }
    ScreenCapture();
}
public void Logout() throws NoSuchElementException, InterruptedException, IOException {
	//click on profile icon for logging out
	driver.findElement(By.className(profileicon)).click();
	waitDriverForGivenSec();
	ScreenCapture();
	//click on logout button
	driver.findElement(By.cssSelector(logoutButton)).click();
}
public void ScreenCapture() throws IOException{
	Date d=new Date();
	System.out.println(d.toString());
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("C:/workspace/GmailLogin/ScreenShots/"+sdf.format(d)+".png"));
}
public void CloseDriver(){
	driver.close();
	driver.quit();
}
}