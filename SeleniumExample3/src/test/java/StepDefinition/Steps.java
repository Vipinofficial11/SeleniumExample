package StepDefinition;

import PageObjects.AddCustomerPage;
import PageObjects.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps extends Baseclass {

public WebDriver driver;
public Login lp;

    @Given("user Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Documents\\chromedriver_win32 (1)\\chromedriver.exe");

        driver=new ChromeDriver();

        lp=new Login(driver);

    }
    @When("user opens URL {string}")
    public void user_opens_url(String url) {
    driver.get(url);

    }
    @When("user enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        driver.findElement(By.name("Email")).clear();
        driver.findElement(By.name("Password")).clear();
        driver.findElement(By.name("Email")).sendKeys(email);
        driver.findElement(By.name("Password")).sendKeys(password);

    }
    @When("click on Login")
    public void click_on_login() throws InterruptedException {
        driver.findElement(By.className("button-1")).click();
    Thread.sleep(3000);

    }
    //Customer feature step definition

    @Then("user can view Dashboard")
    public void user_can_view_dashboard() {
    addCust=new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getpagetitle());


    }
    @When("user click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
   Thread.sleep(2000);
    addCust.clickonCustomersMenu();
    }

    @When("click on customers Menu item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(2000);
        addCust.clickonCustomersMenuItem();

    }
    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
    addCust.clickonAddnew();
        Thread.sleep(2000);
    }
    @Then("user can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getpagetitle());


        }
    @When("user enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
    String email=randomestring()+"@gmail.com";
    addCust.setemail(email);
    addCust.setPassword("test123");

addCust.setCustomerroles("Guests");
Thread.sleep(2000);

    addCust.setManagerOfVendor("Vendor 2");
    addCust.setGender("Male");
    addCust.setfirstname("Vipin");
    addCust.setlastname("Bhatt");
    addCust.setDOB("5/23/2000");
    addCust.setCompanyName("CloudSufi");
    addCust.setAdminContent("This is for testing");

    }
    @When("click on save button")
    public void click_on_save_button() throws InterruptedException {
    addCust.clickOnsave();
    Thread.sleep(2000);

     }
    @Then("user can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully"));


    }
    @Then("close browser")
    public void close_browser() {
driver.close();
    }

}
