package main.java.pages.modal;

import org.openqa.selenium.WebDriver;

public class StartDialog extends AbstractModal {
    public StartDialog(WebDriver driver) {
        super(driver, "dark-theme-dialog__dialogBody");
    }
}
