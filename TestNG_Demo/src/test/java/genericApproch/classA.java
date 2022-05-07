package genericApproch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class classA {

    public static void main(String[] args) throws IOException {

        // Retreving the data from properties file

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("data.properties");
        prop.load(fis);

        // Updating the data into the Properties File

        /*prop.setProperty("result", "pass");
        FileOutputStream fos=new FileOutputStream("data.properties");
        prop.store(fos,null);*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

        driver.switchTo().frame(0);

        driver.findElement(By.linkText("Log in")).click();
        driver.findElement(By.id("Email")).sendKeys(prop.getProperty("userName"));
        driver.findElement(By.id("Password")).sendKeys(prop.getProperty("pwd"));
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();



    }
}
