package emsInsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Titi on 5/2/2016.
 */
public class DepActive extends BaseMain {
    public void  statusDepartment() throws InterruptedException {
        driver.findElement(By.id("txtUserId")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnSubmit")).click();
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        WebElement menuElement = driver.findElement(By.linkText("Admin Module"));
        builder.moveToElement(menuElement).build().perform();
        WebElement menuElement1 = driver.findElement(By.linkText("Job Details"));
        builder.moveToElement(menuElement1).build().perform();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Department")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdViewDepartments_ctl05_ImgbtnStatus")).click();
       // driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnShowPopup']/div/table")).click();
        driver.findElement(By.xpath("//input[@id='ctl00_ContentPlaceHolder1_btnShowPopup']/div/table")).click();
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnYes")).click();
      WebElement inactive =   driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdViewDepartments_ctl03_ImgbtnStatus"));
        inactive.isDisplayed();
       String inMessage= inactive.getText();
        System.out.println(inMessage);
       // if (inMessage.contains(""))


        driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnYes")).click();
        System.out.println(driver.findElement(By.id("ctl00_ContentPlaceHolder1_grdViewDepartments_ctl05_ImgbtnStatus")).isEnabled());
    }
}


