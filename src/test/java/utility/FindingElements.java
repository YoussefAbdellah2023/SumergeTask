package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static java.sql.DriverManager.getDriver;

public class FindingElements extends WaitingMethod{

    public WebElement findElementDynamicallyById(String id, int seconds, boolean isNull) {
        try {

            for (int i = 0; i < seconds; i++) {
                WebElement webElement = getDriver().findElement(By.id(id));

                if (isNull) {
                    if (webElement == null) {
                        return null;
                    }
                }
                if (!isNull) {
                    if (webElement != null) {
                        return webElement;
                    }
                }

                waitForAFixedPeriod(2);
            }
            return null;

        } catch (NoSuchElementException e) {
            // System.out.println("This is the exception " + e);
        }
        return null;
    }


    public WebElement findElementDynamicallyByClassName(String className, int seconds, boolean isNull) {
        try {

            for (int i = 0; i < seconds; i++) {
                WebElement webElement = getDriver().findElement(By.className(className));

                if (isNull) {
                    if (webElement == null) {
                        return null;
                    }
                }
                if (!isNull) {
                    if (webElement != null) {
                        return webElement;
                    }
                }

                waitForAFixedPeriod(2);
            }
            return null;

        } catch (NoSuchElementException e) {
            // System.out.println("This is the exception " + e);
        }
        return null;
    }
}
