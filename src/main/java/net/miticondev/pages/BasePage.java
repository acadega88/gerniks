package net.miticondev.pages;

import net.miticondev.utils.DriverCommands;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;
    DriverCommands commands = new DriverCommands();


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
