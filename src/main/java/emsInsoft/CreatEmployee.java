package emsInsoft;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Titi on 5/1/2016.
 */
public class CreatEmployee extends BaseMain {
    public boolean newEmployee() throws InterruptedException {
        driver.findElement(By.id("txtUserId")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnSubmit")).click();
        driver.manage().window().maximize();
        Actions builder = new Actions (driver);//mouse over
        WebElement menu = driver.findElement(By.linkText("EIM Module"));
        builder.moveToElement(menu).build().perform();
        driver.findElement(By.linkText("Employee Master")).click();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgbtnAdd")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("Simran");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastname")).sendKeys("Bhagy");
        new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlGender"))).selectByIndex(2);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDOB")).sendKeys("2/09/1992");//hard code
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDOJ")).sendKeys("2/05/2013");//hard code
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmailId")).sendKeys("simran@yahoo.com");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhoneNo1")).sendKeys("78654326");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPermanentAddress")).sendKeys("Flat 1,23 switch road ,London");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtContactAddress")).sendKeys("Flat 1,23 switch road ,London");
       new Select (driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlQualification"))).selectByVisibleText("MCA");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtYearOfPass")).sendKeys("2010");

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtNameOfCollege")).sendKeys("Brighton College");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPercentageOfGrade")).sendKeys("A");
       // Thread.sleep(3000);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();


        boolean display = driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblMsg")).isDisplayed();
        Thread.sleep(3000);
        String text =  driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblMsg")).getText();
        if(text.contains("Registration Successfully")) {
            System.out.println("Registration Successfully complited : Test Pass");
        }
        else {
            System.out.println("Registration unSuccessfully  : Test fail");
           driver.findElement(By.id("ctl00_ContentPlaceHolder1_lnkBack")).click();


        }

        return display;



    }
}
