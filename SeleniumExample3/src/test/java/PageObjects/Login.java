package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.WeakHashMap;

public class Login {

    public WebDriver localdriver;

    public Login(WebDriver driver) {
    }

    public void Login(WebDriver realdriver)
    {
        localdriver=realdriver;
        PageFactory.initElements(realdriver,this);
    }

    @FindBy(id="Email")
    @CacheLookup
    WebElement textEmail;


    @FindBy(id="Password")
    @CacheLookup
    WebElement textPassword;


    @FindBy(xpath = "//input[@value='Log in']")
    @CacheLookup
    WebElement btnlogin;


    @FindBy(linkText = "Logout")
    @CacheLookup
    WebElement lnkLogout;

//Action methods

    public void setUserName(String uname)
    {


        textEmail.clear();
        textEmail.sendKeys(uname);
    }

    public void setpassword(String pwd)
    {
        textPassword.clear();
        textPassword.sendKeys(pwd);
    }

    public void clickLogin()
    {
        btnlogin.click();
    }


    public void clickLogout()
    {
        lnkLogout.click();
    }
}
