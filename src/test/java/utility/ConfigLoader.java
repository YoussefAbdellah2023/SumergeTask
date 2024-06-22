package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader extends E2ELogger{
    private static String Url;
    private static String userName;
    private static String password;
    private static String InvalidUserName;
    private static String InvalidPassword;
    private static String EmptyUserName;
    private static String EmptyPassword;

    public void loadProperties() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();

            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }

            prop.load(input);
            Url= prop.getProperty("BASE_URL");
            userName=prop.getProperty("User_Name");
            password=prop.getProperty("Password");
            InvalidUserName=prop.getProperty("Invalid_User_Name");
            InvalidPassword=prop.getProperty("Invalid_Password");
            EmptyUserName= prop.getProperty("Empty_User_Name");
            EmptyPassword=prop.getProperty("Empty_Password");



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getUrl() {

        return  Url;
    }

    public static String getUserName() {

        return  userName;
    }

    public static String getPassword() {

        return  password;
    }
    public static String getInvalidUserName() {

        return  InvalidUserName;
    }

    public static String getInvalidPassword() {

        return  InvalidPassword;
    }

    public static String getEmptyUserName() {

        return  EmptyUserName;
    }

    public static String getEmptyPassword() {

        return  EmptyPassword;
    }
}
