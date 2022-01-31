package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

    public WebDriver localdriver;

    public AddCustomerPage(WebDriver realdriver)
    {
        localdriver=realdriver;
        PageFactory.initElements(localdriver,this);
    }

    By lnkCustomers_menu= By.xpath("/html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]");////a[@href='#']//span[contains(text(),'Customers')]
    By getLnkCustomers_menuitem=By.xpath("/html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");////span[@class='menu-item-title'][contains(text(),'Customers')]

    By btnAddnew=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]");

    By txtEmail=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By txtPassword=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[2]/div[2]/div[1]/input[1]");

    By txtCustomerRoles=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");

    By lstitemAdministrators=By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/ul[1]/li[1]");
    By lstitemRegistered=By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/ul[1]/li[4]");
    By lstitemGuests=By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/ul[1]/li[3]");
    By lstitemVendors=By.xpath("/html[1]/body[1]/div[6]/div[1]/div[2]/ul[1]/li[5]");

    By drpmgrofVendor=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[11]/div[2]/select[1]");
    By rdMaleGender=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[1]/input[1]");
    By rdFeMaleGender=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[5]/div[2]/div[1]/div[2]/input[1]");


    By txtFirstName=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[3]/div[2]/input[1]");
    By txtLastName=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[4]/div[2]/input[1]");

    By txtDob=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[6]/div[2]/span[1]/span[1]/input[1]");

    By txtCompanyName=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[7]/div[2]/input[1]");

    By txtAdminContent=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[13]/div[2]/textarea[1]");
    By btnSave=By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]");


    //Action method

    public void clickonCustomersMenu()
    {
        localdriver.findElement(lnkCustomers_menu).click();
    }

    public void clickonCustomersMenuItem()
    {
        localdriver.findElement(getLnkCustomers_menuitem).click();
    }

    public void clickonAddnew()
    {
        localdriver.findElement(btnAddnew).click();
    }

    public void setemail(String email)
    {
        localdriver.findElement(txtEmail).sendKeys(email);
    }
    public void setPassword(String Password)
    {
        localdriver.findElement(txtPassword).sendKeys(Password);
    }

    public void setCustomerroles(String role) throws InterruptedException
    {
        if(!role.equals("vendors"))
        {
            localdriver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]"));
        }


        localdriver.findElement(txtCustomerRoles).click();

        WebElement listitem;
        Thread.sleep(2000);
        if(role.equals("Administrators"))
        {
            listitem=localdriver.findElement(lstitemAdministrators);
        }
        else if(role.equals("Guests"))
        {
            listitem=localdriver.findElement(lstitemGuests);


        }
        else if(role.equals("Registered"))
        {
            listitem=localdriver.findElement(lstitemRegistered);

        }
        else if(role.equals("Vendors"))
        {
            listitem=localdriver.findElement(lstitemVendors);

        }
        else{
            listitem=localdriver.findElement(lstitemGuests);

        }

      //  listitem.click();
    }

        public void setManagerOfVendor(String value)
        {
            Select drp=new Select(localdriver.findElement(drpmgrofVendor));
            drp.selectByVisibleText(value);


        }

        public void setGender(String gender)
        {
            if(gender.equals("Male"))
            {
                localdriver.findElement(rdMaleGender).click();
            }
            else if(gender.equals("Female"))
            {
                localdriver.findElement(rdFeMaleGender).click();
            }

            else{localdriver.findElement(rdMaleGender).click();}
        }


        public void setfirstname(String fname)
        {
            localdriver.findElement(txtFirstName).sendKeys(fname);
        }

        public void setlastname(String lname)
        {
            localdriver.findElement(txtLastName).sendKeys(lname);
        }

        public void setDOB(String dob)
        {
            localdriver.findElement(txtDob).sendKeys(dob);
        }
    public void setCompanyName(String comname)
    {
        localdriver.findElement(txtCompanyName).sendKeys(comname);
    }

    public void setAdminContent(String content)
    {
        localdriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnsave()
    {localdriver.findElement(btnSave).click();}


    public String getpagetitle()
    {
        return localdriver.getTitle();
    }
}
