package main.java.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class JSWaiterUtils {
    private static final String JS_PATH = "js";

    private static final String jsString = ResourceFactory.stringFromFileBy(JS_PATH + File.separator + "WaitForAngular.js");

    public static Object executeAsyncScript(WebDriver driver, Object... args) {
        return ((JavascriptExecutor) driver).executeAsyncScript(jsString, args);
    }
}
