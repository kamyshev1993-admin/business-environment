package main.java.pages.modal.user_modal;

import io.qameta.allure.Step;
import main.java.pages.modal.AbstractModal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractUserModal extends AbstractModal {

    @FindBy(name = "password")
    protected WebElement passwordInput;

    @FindBy(xpath = "//div[@data-testid = 'errorContainer']//p|//li")
    private List<WebElement> errors;

    public AbstractUserModal(WebDriver driver) {
        super(driver, "auth-dialog__authDialogBody");
    }

    @Step("Проверка списка ошибок о неправильно заполненных полях")
    public void errorShouldContainTexts(List<String> errorTexts) {
        wait.until(ExpectedConditions.visibilityOfAllElements(errors));
        List<String> errorTextListFromWeb = errors.stream().map(WebElement::getText).collect(Collectors.toList());
        Assert.assertEquals(errorTexts.size(), errors.size());
        if (errorTexts.size() != 0) {
            errorTexts.forEach(e -> Assert.assertTrue(errorTextListFromWeb.contains(e)));
        }
    }
}
