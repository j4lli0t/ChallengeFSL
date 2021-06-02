package com.challenge.qa.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wrapper
{
    WebDriver driver;
    public Wrapper(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getElement(By locator)
    {
        WebElement element = driver.findElement(locator);
        return element;
    }
    public void type(By locator, String value) {
        WebElement element = getElement(locator);
        element.sendKeys(value);
    }
    public void doClick(By locator) {
        getElement(locator).click();
    }
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
