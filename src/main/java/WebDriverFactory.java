package main.java;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class WebDriverFactory {

    private static WebDriver webDriver;

    public static WebDriver getInstance() {
        if (webDriver != null) {
            return webDriver;
        }
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("start-maximized", "always-authorize-plugins", "--enable-npapi");
        options.addArguments("--test-type", "--disable-infobars");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("profile.content_settings.pattern_pairs.*.multiple-automatic-downloads", 1);
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("safebrowsing.enabled", "true");
        options.setExperimentalOption("prefs", chromePrefs);
        webDriver =  new ChromeDriver(options);
        return webDriver;
    }
}
