package genericApproch;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class extentReportDemo {

    WebDriver driver;
    ExtentReports extent;

    @BeforeMethod
    public void extentConfiguration() {
        // setting the reportig path
        String reportPath = System.getProperty("user.dir") + "\\reporter\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        // configuraing the name of the report
        reporter.config().setReportName("nopCommerce Test Results");
        // configuraing the title of the report
        reporter.config().setDocumentTitle("nopCommerce Test Results Title");

        // creating object for extent report
        ExtentReports extent = new ExtentReports();
        // attaching configuration to the extent report
        extent.attachReporter(reporter);
        extent.setSystemInfo("operating system ", "windows 10");
        extent.setSystemInfo("Tested By  ", " Vijay Jakkawar ");

    }

    @Test
    public void m1() {
        // creating the extent test
        ExtentTest etest = extent.createTest("Test Is Started");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        etest.info("driver is initiated");
        driver.get("https://frontend.nopcommerce.com/");
        etest.info("navigated to application");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void m2() {
        driver.close();
        // closing the extent test
        extent.flush();
    }
}





