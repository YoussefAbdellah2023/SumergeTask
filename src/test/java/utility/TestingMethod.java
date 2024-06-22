package utility;

import org.openqa.selenium.WebElement;

public class TestingMethod extends FindingElements{

    public void CheckIfNotNull(WebElement webElement, String elementName) {
        if (webElement == null) {
            String errorMessage = String.format("Expected " + elementName + " to be exist, but it was not found");
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }

    public void CheckIfContainUrl(String actualValue, String expectedValue) {
        if (!actualValue.contains(expectedValue)) {
            String errorMessage = String.format("The actual value = " + actualValue + " is not the same as the expacted value " + expectedValue);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }


    public void CheckIfContainText(String actualValue, String expectedValue) {
        if (!actualValue.contains(expectedValue)) {
            String errorMessage = String.format("The actual value = " + actualValue + " is not the same as the expected value = " + expectedValue);
            logger.error(errorMessage);
            throw new AssertionError(errorMessage);
        }
    }
}
