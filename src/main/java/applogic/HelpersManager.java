package main.java.applogic;


import main.java.applogic.helpers.NavigationHelper;
import main.java.applogic.helpers.UserHelper;

public class HelpersManager {
    private NavigationHelper navigationHelper;
    private UserHelper userHelper;

    public HelpersManager(ApplicationManager manager) {
        navigationHelper = new NavigationHelper(manager);
        userHelper = new UserHelper(manager);
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
}
