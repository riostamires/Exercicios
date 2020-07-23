package flowhr.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManagerFactory implements Constantes {

    public static WebDriver driver;

    public By consultarVaga = By.cssSelector("");


    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER);
        driver = new ChromeDriver();
        driver.get("http://192.168.0.68:9090/");
        return driver;
    }
}

