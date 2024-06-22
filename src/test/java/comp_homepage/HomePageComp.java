package comp_homepage;

import org.openqa.selenium.WebElement;

public class HomePageComp extends HomePageWebElement{

    public void CheckHomePageOpen(){
        logger.debug("Check Home Page Open");
        // Check Home Page Container
        WebElement homePageContainer = getHomePageContainer(false);
        CheckIfNotNull(homePageContainer,"Home Page Container");

        // Check URL
        CheckIfContainUrl(getDriver().getCurrentUrl(),getUrl());
        System.out.println("*** The URL Is: " +getUrl());
    }

    public void CheckHeaderAppearAndTextVisible(){
        logger.debug("Check Header Appear And Text Is Visible");
        // Check Header Container
        WebElement headerContainer = getHeaderContainer(false);
        CheckIfNotNull(headerContainer,"Header Container");

        // Check Text Is Visible
        WebElement text = getText(false);
        CheckIfNotNull(text,"The Text");
        System.out.println("*** The Text Is: " +text.getText());
        CheckIfContainText(text.getText(),"Swag Labs");
    }

}
