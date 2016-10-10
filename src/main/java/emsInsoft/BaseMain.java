package emsInsoft;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by Titi on 4/26/2016.
 */
public class BaseMain {
    public static WebDriver driver;



    public void openBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/emsInsoft/configuration/Configuration.properties");
        properties.load(fileInputStream);
        String browser = properties.getProperty("browser");
        String url = properties.getProperty("url");


        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie")) {
            InternetExplorerDriverManager.getInstance().setup();
            driver = new ChromeDriver();
        }

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void closeBrowser(){
        driver.quit();

    }
}
