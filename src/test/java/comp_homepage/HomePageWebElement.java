package comp_homepage;

import org.openqa.selenium.WebElement;
import utility.SeleniumUtility;

public class HomePageWebElement extends SeleniumUtility {

    public WebElement getHomePageContainer(boolean isNull){return findElementDynamicallyById("page_wrapper",10,isNull);}
    public WebElement getHeaderContainer(boolean isNull){return findElementDynamicallyById("header_container",10,isNull);}
    public WebElement getText(boolean isNull){return findElementDynamicallyByClassName("app_logo",10,isNull);}
}
