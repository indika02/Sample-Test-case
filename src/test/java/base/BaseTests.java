package base;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public  void setUp(){
        System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
        driver=new EdgeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage=new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
@AfterMethod
   public void recordFailure(ITestResult result){
        if(ITestResult.SUCCESS==result.getStatus()){

        var camera=(TakesScreenshot)driver;
        File screenshot=camera.getScreenshotAs(OutputType.FILE);
        try{
            Files.move(screenshot.toPath(), new File("resources/screenshots/test.png").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        }
}
}
