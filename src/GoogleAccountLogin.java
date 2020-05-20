import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleAccountLogin extends MainTest{

    @Test(priority = 1, description = "Launching the Browser")
    public void setUp(){
        System.out.println("Opening Browser");

        driver = new ChromeDriver();
        //driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://accounts.google.com/ServiceLogin");
    }

    @Test(priority = 2, description = "Login Functionality")
    public void LoginPage() throws InterruptedException,IOException
    {
        System.out.println("This is a login test");
        //System.setProperty("webdriver.chrome.driver","C:\Users\kuchi\Documents\Selenium jars\chromedriver_win32\chromedriver.exe")

        driver.findElement(By.id("identifierId")).sendKeys("onlyfortesting459",Keys.ENTER);
        Thread.sleep(1500);
        //Utility.captureScreenshot(driver,"BrowserMode");
        GetScreenshot.capture("BrowserMode");
        driver.findElement(By.name("password")).sendKeys("Google@123",Keys.ENTER);
        Thread.sleep(5000);
        //Utility.captureScreenshot(driver,"LoginScreen");
        GetScreenshot.capture("LoginScreen");
        String title=driver.getTitle();
        Assert.assertEquals("Google Account",title);
        driver.close();

    }

    @Test(priority = 3, description = "Exit the Browser")
    public void exit(){
        System.out.println("Closing Browser");
        WebDriverWait wait=new WebDriverWait(driver,20);
        driver.quit();
    }

}
