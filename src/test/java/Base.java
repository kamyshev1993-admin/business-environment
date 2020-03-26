package test.java;

import main.java.applogic.ApplicationManager;
import main.java.model.User;
import main.java.model.UserFactory;
import org.testng.annotations.*;

public class Base {

    protected UserFactory userFactory;
    protected ApplicationManager app;
    protected User user;

    @BeforeClass
    public void init() {
        if (app == null) {
            app = new ApplicationManager();
        }
        userFactory = UserFactory.getInstance();
        app.getHelpers().getNavigationHelper().openMainPage();
        user = userFactory.getCorrectExistUser();
        app.getHelpers().getNavigationHelper().closeStartDialog();
    }

    @AfterMethod
    public void refreshAndLogout() {
        //Делаю рефреш, чтобы сбросить висящие модалки
        app.getHelpers().getNavigationHelper().openMainPage();
        app.getHelpers().getUserHelper().logout();
    }

    @AfterSuite
    public void closeBrowser() {
        app.getDriver().close();
    }
}
