package emsInsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by Titi on 4/26/2016.
 */
public class Employee extends BaseMain {
    public boolean  viewEmployee() throws InterruptedException {
        driver.findElement(By.id("txtUserId")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnSubmit")).click();
       // driver.navigate().to("http://sriram-001-site1.ctempurl.com/EIM/ViewEmployeeDetails.aspx");
        Actions builder = new Actions(driver);
        WebElement menuElement = driver.findElement(By.linkText("EIM Module"));
        builder.moveToElement(menuElement).build().perform();
        driver.findElement(By.linkText("Employee Master")).click();


        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_gvEmployees_ctl03_ImgtnEdit")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).clear();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("Simran");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastname")).clear();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastname")).sendKeys("Pam");
        new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlGender"))).selectByIndex(2);
        //new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlGender"))).selectByValue("Female");
       // new Select(driver.findElement(By.id(""))).selectByVisibleText("Female");
        //driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmailId")).sendKeys("simran@yahoo.com");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhoneNo1")).clear();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhoneNo1")).sendKeys("7835462709");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPermanentAddress")).clear();
       driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPermanentAddress")).sendKeys("flat 20 ,5 Shakepher Road ,East Ham ");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtContactAddress")).clear();
       driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtContactAddress")).sendKeys("flat 20 ,5 Shakepher Road ,East Ham ");
        new Select (driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlQualification"))).selectByIndex(9);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtYearOfPass")).clear();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtNameOfCollege")).clear();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtNameOfCollege")).sendKeys("Kala NIketan College");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtYearOfPass")).sendKeys("2012");
        driver.findElement(By.className("capsTextField")).clear();
        driver.findElement(By.className("capsTextField")).sendKeys("A");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_btnSave")).click();

     WebElement message  = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblMsg"));
       boolean display =  message.isDisplayed();
        String text = message.getText();
        if (text.equals("Registration Successfully Completed")){
            System.out.println("Employee Register Sucessfully");
        }
        else {
            System.out.println("Employee Register unSucessfully");
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnClear")).click();
        }


     return display;

    }

}
