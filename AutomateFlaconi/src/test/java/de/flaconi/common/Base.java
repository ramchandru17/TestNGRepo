package de.flaconi.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    public static InputStream inputStream;
    public static String product;


    public void startBrowser() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        //driver = new ChromeDriver();
        DesiredCapabilities dcap = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dcap);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void openFlaconi()throws IOException {
        inputStream= new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/application.properties"));
        Properties appProperties = new Properties();
        appProperties.load(inputStream);
        product=appProperties.getProperty("Product");
        driver.get(appProperties.getProperty("URL"));
    }

    public void exitBrowser()throws IOException {
        inputStream.close();
        driver.quit();
        System.out.println("Ram Done");
    }



}
