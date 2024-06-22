package comp_loginpage;

import org.openqa.selenium.WebElement;
import utility.SeleniumUtility;

public class LoginPageWebElement extends SeleniumUtility {

    public WebElement getLoginContainer(boolean isNull){return findElementDynamicallyById("root",10,isNull);}
    public WebElement getUserNameField(boolean isNull){return findElementDynamicallyById("user-name",10,isNull);}
    public WebElement getPasswordField(boolean isNull){return findElementDynamicallyById("password",10,isNull);}
    public WebElement getLoginButton(boolean isNull){return findElementDynamicallyById("login-button",10,isNull);}
    public WebElement getLoginFieldsContainer(boolean isNull){return findElementDynamicallyById("login_button_container",10,isNull);}
    public WebElement getErrorMessageContainer(boolean isNull){return findElementDynamicallyByClassName("error-message-container",10,isNull);}
    public WebElement getCloseErrorMessageBtn(boolean isNull){return findElementDynamicallyByClassName("error-button",10,isNull);}







}
