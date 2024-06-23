package utility;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class SettingUpWebDriver extends ConfigLoader{

    static WebDriver driver = null;

    public WebDriver getDriver() {
        return driver;
    }



    public WebDriver setUpTheDriver() {

        loadProperties();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.navigate().to(getUrl());

        return driver;
    }

    public WebDriver SetUpDimension(int height, int width){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.navigate().to("http://localhost:4200/home");
        Dimension dimension = driver.manage().window().getSize();
        height = dimension.getHeight();
        width= dimension.getWidth();

        return driver;
    }

    public void closeDriver(ITestResult result) {
        if (!result.isSuccess()) {
            // Capture and save the screenshot
            String testClassName = result.getTestClass().getName();
            String testMethodName = result.getMethod().getMethodName();
            ScreenShot.captureScreenShot(driver,  testClassName, testMethodName);


        }
        driver.quit();

    }


    }



