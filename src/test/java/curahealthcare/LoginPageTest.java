package curahealthcare;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    WebDriver driver;

    @BeforeTest
    //Inisialisasi untuk membuka website menggunakan chrome
    public void init(){
        System.setProperty("webdriver.chrome.driver","C:/Program Files/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();

        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    private void checkElementLogin (){
        //element H2
        Assert.assertEquals(driver.findElement(By.cssSelector("section h2")).getText(),"Login");

        //Element P
        Assert.assertEquals(driver.findElement(By.cssSelector("section p")).getText(),"Please login to make appointment.");

        //Element Username
        Assert.assertEquals(driver.findElement(By.id("txt-username")).getAttribute("placeholder"),"Username");
        Assert.assertEquals(driver.findElement(By.id("txt-password")).getAttribute("placeholder"),"Password");

    }
    @Test(priority = 1)
    private void loginWithNullValues(){
        driver.findElement(By.id("btn-login")).click();
        Assert.assertEquals(driver.findElement(By.className("text-danger")).getText(),"Login failed! Please ensure the username and password are valid.");

    }

    @Test(priority = 2)
    public void loginWithWrongValues(){

    }
}
