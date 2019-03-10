package com.w2a.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.ExtentManager;
import utilities.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Page {

    public static WebDriver driver;
    public static Properties config = new Properties();
    public static Properties OR = new Properties();
    public static FileInputStream fis;
    public static Logger log = Logger.getLogger("devpinoyLogger");
    public static WebDriverWait wait;
    public ExtentReports rep = ExtentManager.getInstance();
    public static ExtentTest test;
    public static String browser;
    public static TopMenu menu;

    public Page() throws IOException {
        if (driver == null) {

            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\com.w2a.properties\\config.properties");
            config.load(fis);
            log.debug("config file loaded !!!");
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\com.w2a.properties\\or.properties");
            OR.load(fis);
            log.debug("OR file loaded !!!");

            //Jenkins Browser filter configuration
            if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
                browser = System.getenv("browser");
            }
            else {
                browser = System.getProperty("browser");
            }
            //config.setProperty("browser", browser);

            if (config.getProperty("browser").equals("firefox")) {
                //execute in Firefox driver
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Leonidus\\projects\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.executables\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
            else if (config.getProperty("browser").equals("chrome")) {
                //execute in chrome driver
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leonidus\\projects\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.executables\\chromedriver.exe");
                log.debug("chrome launched !!!");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-infobars");
                driver = new ChromeDriver(options);
            }
            else if (config.getProperty("browser").equals("IE")) {
                //execute in IE driver
                System.setProperty("webdriver.IE.driver", "C:\\Users\\Leonidus\\projects\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.executablesIEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }

            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Leonidus\\projects\\PageObjectModelBasics\\src\\test\\resources\\com.w2a.executables\\chromedriver.exe");

            driver.get(config.getProperty("testsiteurl"));
            log.debug("navigated to: " + config.getProperty("testsiteurl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 5);

            menu = new TopMenu(driver);
        }
    }

    public static void quit() {
        driver.quit();
    }

    //Common Keywords
    public static void click(String locator) {

        if (locator.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
        }
        else if (locator.endsWith("_XPATH")) {
            driver.findElement(By.xpath(OR.getProperty(locator))).click();
        }
        else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(OR.getProperty(locator))).click();
        }
        //test.log(LogStatus.INFO, "Clicking on: " + locator);
        log.debug("Clicking on element: " + locator);
    }


    public static void type(String locator, String value) {

        if (locator.endsWith("_CSS")) {
            driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
        }
        else if (locator.endsWith("_XPATH")) {
            driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
        }
        else if (locator.endsWith("_ID")) {
            driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
        }
        //test.log(LogStatus.INFO, "Typing in: " + locator + " entered value: " + value);
        log.debug("Typing in an element: " + locator + " entered value as: " + value);
    }

    static WebElement dropdown;

    public static void select(String locator, String value) {

        if (locator.endsWith("_CSS")) {
            dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));
        }
        else if (locator.endsWith("_XPATH")) {
            dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
        }
        else if (locator.endsWith("_ID")) {
            dropdown = driver.findElement(By.id(OR.getProperty(locator)));
        }

        Select select = new Select(dropdown);
        select.selectByVisibleText(value);

        test.log(LogStatus.INFO, "Selecting from dropdown: " + locator + " entered value: " + value);
        log.debug("Selecting from an element: " + locator + " value as: " + value);
    }

    public boolean isElementPresent(By by) {

        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void verifyEquals(String expected, String actual) throws IOException {
        try{
            Assert.assertEquals(expected, actual);
        } catch (Throwable t) {
            Utilities.captureScreenshot("verifyEquals failed! ");
        }
    }

}
