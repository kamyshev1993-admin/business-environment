package main.java.applogic;

import main.java.pages.MainPage;
import main.java.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageManager {
    private WebDriver driver;
    private MainPage mainPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        mainPage = initElements(new MainPage(driver));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(driver, page);
        return page;
    }

    public MainPage getMainPage() {
        return mainPage;
    }
}
