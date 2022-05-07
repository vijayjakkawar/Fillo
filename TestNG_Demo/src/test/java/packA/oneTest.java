package packA;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class oneTest {

    // mvn cmd (  mvn clean mvn compile  mvn test  )
    // to run only specific test (  mvn -Dtest=oneTest test  )

    WebDriver driver;

    @Test
    public  void m1()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://frontend.nopcommerce.com/");
        System.out.println("Method 1 ");
    }

    @AfterMethod
    public  void m2()
    {
        driver.close();
    }
}
