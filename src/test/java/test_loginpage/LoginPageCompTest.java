package test_loginpage;

import comp_homepage.HomePageComp;
import comp_loginpage.LoginPageComp;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageCompTest extends LoginPageComp {

    @BeforeMethod
    public void setUp() {
        setUpTheDriver();
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown(ITestResult result) {
//        closeDriver(result);
//    }

    @AfterMethod(alwaysRun = true)
    public void tearDown2 (ITestResult result) {
        closeDriver(result);
    }


    @Test(priority = 1)
    public void CheckLoginPageOpen(){
        CheckTheLoginPageOpen();
    }

//    @Test(priority = 2,dataProvider = "testData")
//    public void CheckUserLoginSuccessfullyUsingDDTAndDataProvider(String userName, String password){
////        1- Check Login Page Opened
//        CheckTheLoginPageOpen();
////        2- Check The Email And Password Fields Are The Main Page
//        CheckTheUsernameAndPasswordFieldsAreOnTheMainScreen();
////        3- Check User Enter Data Success With DDT And Data Provider
//        CheckUserEnterDataSuccessfullyWithDDTAndDataProviders(userName,password);
////        4- Check User Login Success And Home Page Opened
//        HomePageComp homePageComp = new HomePageComp();
//        homePageComp.CheckHomePageOpen();
//        homePageComp.CheckHeaderAppearAndTextVisible();
//    }
//
//    @Test(priority = 3)
//    public void CheckUserLoginSuccessfullyUsingPropertiesFile(){
////        1- Check Login Page Opened
//        CheckTheLoginPageOpen();
////        2- Check The Email And Password Fields Are The Main Page
//        CheckTheUsernameAndPasswordFieldsAreOnTheMainScreen();
////        3- Check User Enter Data Success With DDT And Data Provider
//        CheckUserEnterDataSuccessfullyWithDDTAndPropertiesFile();
////        4- Check User Login Success And Home Page Opened
//        HomePageComp homePageComp = new HomePageComp();
//        homePageComp.CheckHomePageOpen();
//        homePageComp.CheckHeaderAppearAndTextVisible();
//
//    }
//
    @Test(priority = 4, dataProvider = "userDataExcel")
    public void CheckUserLoginSuccessfullyUsingExcelFile(String userName, String password) throws IOException {
//        1- Check Login Page Opened
        CheckTheLoginPageOpen();
//        2- Check The Email And Password Fields Are The Main Page
        CheckTheUsernameAndPasswordFieldsAreOnTheMainScreen();
//        3- Check User Enter Data Success With DDT And Data Provider
        CheckUserEnterDataSuccessfullyWithDDTAndExcelFile(userName,password);
//        4- Check User Login Success And Home Page Opened
        HomePageComp homePageComp = new HomePageComp();
        homePageComp.CheckHomePageOpen();
        homePageComp.CheckHeaderAppearAndTextVisible();
    }
//
//    @Test(priority = 5)
//    public void CheckErrorMessageWhenUserEnterInvalidDataWithDDTAndPropertiesFile(){
////        1- Check Login Page Opened
//        CheckTheLoginPageOpen();
////        2- Check The Email And Password Fields Are The Main Page
//        CheckTheUsernameAndPasswordFieldsAreOnTheMainScreen();
////        3- Check User Enter Invalid Data With DDT And Properties File
//        CheckUserEnterInvalidDataWithDDTAndPropertiesFile();
////        4- Check Error Message
//        CheckErrorMessageWithInvalidData();
//    }
//
//
//    @Test(priority = 7)
//    public void CheckErrorMessageWhenUserLeaveTheUserNameAndPasswordFieldsEmpty(){
////        1- Check Login Page Opened
//        CheckTheLoginPageOpen();
////        2- Check The Email And Password Fields Are The Main Page
//        CheckTheUsernameAndPasswordFieldsAreOnTheMainScreen();
////        3- Check User Leave UserName And Password Fields Empty
//        CheckUserLeaveUserNameAndPasswordFieldsEmpty();
//    }



}
