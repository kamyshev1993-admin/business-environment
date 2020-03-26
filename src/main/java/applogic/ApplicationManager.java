package main.java.applogic;

import main.java.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ApplicationManager {

    private PageManager pages;
    private HelpersManager helpers;

    private WebDriver driver;
    private StandData standData;

    public PageManager getPages() {
        return pages;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public StandData getStandData() {
        return standData;
    }

    public HelpersManager getHelpers() {
        return helpers;
    }

    public ApplicationManager() {
        loadProperties();
        driver = WebDriverFactory.getInstance();
        pages = new PageManager(driver);
        helpers = new HelpersManager(this);
    }

    private void loadProperties() {
        String resourceName = "stand.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName);
        InputStreamReader reader = new InputStreamReader(inputStream);
        Properties properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        standData = new StandData(properties);
    }
}
