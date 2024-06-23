package comp_loginpage;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import utility.ExcelReader;

import java.io.IOException;

public class LoginPageComp extends LoginPageWebElement{

    public void CheckTheLoginPageOpen() {
        logger.debug("Check Login Page Open");

        // Check URL & Title
        System.out.println("**** The URL Is = " +getDriver().getCurrentUrl());
        System.out.println("**** The Title Is = " +getDriver().getTitle());
        CheckIfContainUrl(getDriver().getCurrentUrl(),getUrl());
        CheckIfContainText(getDriver().getTitle(),"Swag Labs");

        // Check Container
        WebElement loginPageContainer = getLoginContainer(false);
        CheckIfNotNull(loginPageContainer, "Login page");

    }

    public void CheckTheUsernameAndPasswordFieldsAreOnTheMainScreen(){
        logger.debug("Check The Username And Password Fields Are On The Main Screen");

        WebElement loginFieldsContainer = getLoginFieldsContainer(false);
        CheckIfNotNull(loginFieldsContainer,"Login Fields Container");

    }

    @DataProvider(name = "testData")
    public static  Object[] [] UserData(){

        return new Object[][]{
//                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"}
//                {"problem_user","secret_sauce"},
//                {"performance_glitch_user","secret_sauce"},
//                {"error_user","secret_sauce"},
//                {"visual_user","secret_sauce"}
        };

    }

    public void CheckUserEnterDataSuccessfullyWithDDTAndDataProviders(String userName, String password){
        logger.debug("Check User Enter Data Success With DDT And Data Providers");


        // Check Email Field And Send Data
        WebElement emailField = getUserNameField(false);
        CheckIfNotNull(emailField,"Email Field");
        System.out.println("*** The Placeholder For Email Field Is: " +emailField.getAttribute("placeholder"));
        CheckIfContainText(emailField.getAttribute("placeholder"),"Username");
        emailField.sendKeys(userName);

        // Check Password Field And Send Data
        WebElement passwordField = getPasswordField(false);
        CheckIfNotNull(passwordField,"Password Field");
        System.out.println("*** The Placeholder For Password Field Is: " +passwordField.getAttribute("placeholder"));
        CheckIfContainText(passwordField.getAttribute("placeholder"),"Password");
        passwordField.sendKeys(password);


        // Click On Login Button
        WebElement loginButton =getLoginButton(false);
        CheckIfNotNull(loginButton,"Login Button");
        loginButton.click();
    }

    public void CheckUserEnterDataSuccessfullyWithDDTAndPropertiesFile(){
        logger.debug("Check User Enter Data Success With DDT And Properties File");


        // Check Email Field And Send Data
        WebElement emailField = getUserNameField(false);
        CheckIfNotNull(emailField,"Email Field");
        System.out.println("*** The Placeholder For Email Field Is: " +emailField.getAttribute("placeholder"));
        CheckIfContainText(emailField.getAttribute("placeholder"),"Username");
        emailField.sendKeys(getUserName());

        // Check Password Field And Send Data
        WebElement passwordField = getPasswordField(false);
        CheckIfNotNull(passwordField,"Password Field");
        System.out.println("*** The Placeholder For Password Field Is: " +passwordField.getAttribute("placeholder"));
        CheckIfContainText(passwordField.getAttribute("placeholder"),"Password");
        passwordField.sendKeys(getPassword());


        // Click On Login Button
        WebElement loginButton =getLoginButton(false);
        CheckIfNotNull(loginButton,"Login Button");
        loginButton.click();
    }

    @DataProvider(name = "userDataExcel")
    public Object [] [] UserDataExcelFile() throws IOException {
        // Read Data From Excel Reader Class
        ExcelReader excelReader = new ExcelReader();

            return excelReader.getExcelData();
    }

    public void CheckUserEnterDataSuccessfullyWithDDTAndExcelFile(String userName, String password){
        logger.debug("Check User Enter Data Success With DDT And Excel File");


        // Check Email Field And Send Data
        WebElement emailField = getUserNameField(false);
        CheckIfNotNull(emailField,"Email Field");
        System.out.println("*** The Placeholder For Email Field Is: " +emailField.getAttribute("placeholder"));
        CheckIfContainText(emailField.getAttribute("placeholder"),"Username");
        emailField.sendKeys(userName);

        // Check Password Field And Send Data
        WebElement passwordField = getPasswordField(false);
        CheckIfNotNull(passwordField,"Password Field");
        System.out.println("*** The Placeholder For Password Field Is: " +passwordField.getAttribute("placeholder"));
        CheckIfContainText(passwordField.getAttribute("placeholder"),"Password");
        passwordField.sendKeys(password);


        // Click On Login Button
        WebElement loginButton =getLoginButton(false);
        CheckIfNotNull(loginButton,"Login Button");
        loginButton.click();
    }

    public void CheckUserEnterInvalidDataWithDDTAndPropertiesFile(){
        logger.debug("Check User Enter Invalid Data  With DDT And Properties File");

        loadProperties();
        // Check Email Field And Send Data
        WebElement emailField = getUserNameField(false);
        CheckIfNotNull(emailField,"Email Field");
        System.out.println("*** The Placeholder For Email Field Is: " +emailField.getAttribute("placeholder"));
        CheckIfContainText(emailField.getAttribute("placeholder"),"Username");
        emailField.sendKeys(getInvalidUserName());

        // Check Password Field And Send Data
        WebElement passwordField = getPasswordField(false);
        CheckIfNotNull(passwordField,"Password Field");
        System.out.println("*** The Placeholder For Password Field Is: " +passwordField.getAttribute("placeholder"));
        CheckIfContainText(passwordField.getAttribute("placeholder"),"Password");
        passwordField.sendKeys(getInvalidPassword());


        // Click On Login Button
        WebElement loginButton =getLoginButton(false);
        CheckIfNotNull(loginButton,"Login Button");
        loginButton.click();
    }

    public void CheckErrorMessageWithInvalidData(){
        logger.debug("Check Error Message With Invalid Data");

        WebElement ErrorMessage = getErrorMessageContainer(false);
        CheckIfNotNull(ErrorMessage,"Error Message Container");

        // Check Background Color For Error Message
        CheckIfContainText(ErrorMessage.getCssValue("background-color"),"rgba(226, 35, 26, 1)");
        System.out.println("*** The Background Color For Error Message Is: " +ErrorMessage.getCssValue("background-color"));

        // Check Text For Error Message
        System.out.println("*** The Text Is Displayed: " +ErrorMessage.isDisplayed());
        CheckIfContainText(ErrorMessage.getText(),"Epic sadface: Username and password do");
        System.out.println("*** The Error Message Is: " +ErrorMessage.getText());

    }

    public void CheckUserLeaveUserNameAndPasswordFieldsEmpty(){
        logger.debug("Check User Leave UserName And Password Fields Empty");
        // Click On Login Button
        WebElement loginButton =getLoginButton(false);
        CheckIfNotNull(loginButton,"Login Button");
        loginButton.click();

        // Check Error Message For UserName Filed And Close It
        WebElement ErrorMessage = getErrorMessageContainer(false);
        CheckIfNotNull(ErrorMessage,"Error Message Container");

        CheckIfContainText(ErrorMessage.getCssValue("background-color"),"rgba(226, 35, 26, 1)");
        System.out.println("*** The Background Color For Error Message Is: " +ErrorMessage.getCssValue("background-color"));

        System.out.println("*** The Text Is Displayed: " +ErrorMessage.isDisplayed());
        CheckIfContainText(ErrorMessage.getText(),"Epic sadface: Username is required");
        System.out.println("*** The Error Message For UserNameField Is: " +ErrorMessage.getText());

        WebElement ErrorMessageBtn = getCloseErrorMessageBtn(false);
        CheckIfNotNull(ErrorMessageBtn,"Close Error Message Button");
        ErrorMessageBtn.click();

        // Check User Enter Data In userName Field
        WebElement userNameField = getUserNameField(false);
        CheckIfNotNull(userNameField,"userName Field");
        System.out.println("*** The Placeholder For UserName Field Is: " +userNameField.getAttribute("placeholder"));
        CheckIfContainText(userNameField.getAttribute("placeholder"),"Username");
        userNameField.sendKeys(getUserName());

        loginButton.click();

        // Check Error Message For Password Field
        CheckIfNotNull(ErrorMessage,"Error Message Container");

        CheckIfContainText(ErrorMessage.getCssValue("background-color"),"rgba(226, 35, 26, 1)");
        System.out.println("*** The Background Color For Error Message Is: " +ErrorMessage.getCssValue("background-color"));

        System.out.println("*** The Text Is Displayed: " +ErrorMessage.isDisplayed());
        CheckIfContainText(ErrorMessage.getText(),"Epic sadface: Password is required");
        System.out.println("*** The Error Message For UserNameField Is: " +ErrorMessage.getText());

        WebElement ErrorMessageBtn2 = getCloseErrorMessageBtn(false);
        CheckIfNotNull(ErrorMessageBtn2,"Close Error Message Button");
        ErrorMessageBtn2.click();

    }






}
