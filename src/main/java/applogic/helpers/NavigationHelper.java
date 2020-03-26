package main.java.applogic.helpers;
import io.qameta.allure.Step;
import main.java.applogic.ApplicationManager;
import main.java.applogic.PageManager;
import main.java.pages.MainPage;
import main.java.pages.modal.user_modal.LoginModal;
import main.java.pages.modal.user_modal.RegistrationModal;
import main.java.pages.modal.StartDialog;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {

    private final String baseUrl;
    private PageManager pages;
    private WebDriver driver;

    public NavigationHelper(ApplicationManager manager) {
        this.baseUrl = manager.getStandData().getUrl();
        this.driver = manager.getDriver();
        this.pages = manager.getPages();
    }

    @Step("Открыть начальную страницу")
    public MainPage openMainPage() {
        try {
            driver.get(baseUrl);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("NavHelper: can't open main page");
        }
        return pages.getMainPage();
    }

    @Step("Открыть окно регистрации")
    public RegistrationModal openRegistrationModal() {
        pages.getMainPage().ensurePageLoaded()
                .clickRegisterLink();
        return new RegistrationModal(driver);
    }

    @Step("Открыть окно логина")
    public LoginModal openLoginModal() {
        pages.getMainPage().ensurePageLoaded()
                .clickLoginLink();
        return new LoginModal(driver);
    }

    @Step("Закрыть окно \"Не пропустить и бит\" если оно отображается")
    public void closeStartDialog() {
        StartDialog startDialog = new StartDialog(driver);
        if (startDialog.isVisible()) {
            startDialog.closeModal();
        }
    }
}
