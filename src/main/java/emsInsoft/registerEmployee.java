package emsInsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;



/**
 * Created by Titi on 5/2/2016.
 */
public class registerEmployee extends BaseMain {
    public String  register() throws InterruptedException {
        driver.findElement(By.id("txtUserId")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnSubmit")).click();
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        WebElement menuElement = driver.findElement(By.linkText("EIM Module"));
        builder.moveToElement(menuElement).build().perform();
         driver.findElement(By.linkText("Employee Registration")).click();
     String regDepart =  driver.findElement(By.xpath("//div [@id='ctl00_ContentPlaceHolder1_UpdatePanel2']/table/tbody/tr/td/table[1]/tbody[1]/tr[1]/td[1]")).getText();
        System.out.println(regDepart);
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_lnkbtnEmpReg")).click();
        driver.findElement(By.className("HellowWorldPopup")).click();



        WebDriverWait wait = new  WebDriverWait(driver,10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable ( driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEmpName"))));
        Select select = new Select (element);
        select.selectByIndex(3);
       Select select2= new Select (driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDept")));
        select2.selectByIndex(3);
        Select select3 = new Select (driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlDesig")));
        select3.selectByIndex(6);

      Select select4 =   new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlPayGrd")));
        select4.selectByIndex(1);
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      Select select5 = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEmpType")));;
        select5.selectByIndex(5);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Select select6 =new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEmpCat")));
        select6.selectByIndex(3);
      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       Select select7 =new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSalcomp")));
        select7.selectByIndex(4);

        Select select8  = new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlShifts")));
        select8.selectByIndex(4);
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("ctl00$ContentPlaceHolder1$btnSave")).click();

      WebElement message =   driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblViewmsg"));
        message.isDisplayed();
        String text =message.getText();
        if(text.contains("Submitted successfully")) {
            System.out.println("User submitted successfully: Test Pass");
        }
        else {
            System.out.println("User submitted unsuccessfully: Test Fail");

        }
        return text;

    }


    }


