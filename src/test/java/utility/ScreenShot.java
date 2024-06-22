package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShot extends SettingUpWebDriver{

    public static void captureScreenShot(WebDriver driver, String testClassName, String testMethodName) {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Define the directory path based on the class and method name
        String directoryPath = "target/ScreenShots/" + testClassName + "_" + testMethodName + ".png" ;
        logger.info("directoryPath = " + directoryPath);
        File targetDirectory = new File(directoryPath);
        if (!targetDirectory.exists()) {
            targetDirectory.mkdirs();
        }
        File targetFile = new File(targetDirectory,  testClassName + "_"+ testMethodName + ".png");
        try {
            FileUtils.copyFile(scrFile, targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void takeScreenShots(ITestResult result) throws IOException {
//        if(ITestResult.FAILURE == result.getStatus()){
//            // Create Reference of takeScreenShots
//            TakesScreenshot screenshot = (TakesScreenshot)driver;
//            File source = screenshot.getScreenshotAs(OutputType.FILE);
//            File source2 = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
//            WebElement nextGeneration = driver.findElement(By.cssSelector("#root h4"));
//            File source3 = nextGeneration.getScreenshotAs(OutputType.FILE);
//
//            String directoryPath = "target/screenShots/"+ result.getName()+ "-" + result.getTestClass().getName() + ".png";
//            FileUtils.copyFile(source, new File(directoryPath));
//            logger.info("directoryPath = " +directoryPath);
//
//
//        }
//
//        driver.quit();
//
//    }
}
