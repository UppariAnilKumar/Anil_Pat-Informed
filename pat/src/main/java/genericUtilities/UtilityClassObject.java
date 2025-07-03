package genericUtilities;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void setTest(ExtentTest testInstance) {
        test.set(testInstance);
    }

    public static void unloadTest() {
        test.remove();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void unloadDriver() {
        driver.remove();
    }
}
