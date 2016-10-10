package emsInsoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Titi on 5/1/2016.
 */
public class newDepartment extends BaseMain  {
    public String  newAddDepartment() {
        driver.findElement(By.id("txtUserId")).sendKeys("admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnSubmit")).click();
        driver.manage().window().maximize();
        Actions builder = new Actions(driver);
        WebElement menuElement = driver.findElement(By.linkText("Admin Module"));
        builder.moveToElement(menuElement).build().perform();
        WebElement menuElement1 = driver.findElement(By.linkText("Job Details"));
        builder.moveToElement(menuElement1).build().perform();
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElement(By.linkText("Department")).click();
     String text =  driver.findElement(By.xpath("//tr[@id='clrMsg']/td[1]/table/tbody/tr[1]/td[1]")).getText();
        System.out.println( text  );


       driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgbtnAdd")).click();

        driver.findElement(By.className("HellowWorldPopup")).click();

        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDeptName")).sendKeys("Medical");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtDeptCode" )).sendKeys("Blood");
        driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnSave")).click();
      String depart=  driver.findElement(By.id("ctl00_ContentPlaceHolder1_lblViewmsg")).getText();
        if (depart.contains("Submitted successfully")){
            System.out.println("New Department created ");
        }
        else {
            System.out.println("Department not created");
            driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBack")).click();
        }
        System.out.println(depart);
        return depart;


    }
}
