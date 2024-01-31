package curahealthcare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MakeAppointment {

    WebDriver driver;

    @BeforeTest
    public void init(){
        System.setProperty("webdriver.chrome.driver","C:/Program Files/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();


        //Login
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
    }
    @Test(priority = 0)
    private void checkElement(){
        //test h2
        Assert.assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Make Appointment");
        //
        Assert.assertEquals(driver.findElement(By.cssSelector("hr.small")).getCssValue("max-width"), "100px");

    }
    @Test(priority = 1)
    private void checkDropdown(){
        //dropdown
        }
}
