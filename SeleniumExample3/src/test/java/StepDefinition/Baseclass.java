package StepDefinition;

import PageObjects.AddCustomerPage;
import PageObjects.Login;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class Baseclass {

    public WebDriver driver;
    public Login lp;
    public AddCustomerPage addCust;

    public static String randomestring()
    {
        String generatedString1= RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }

}
