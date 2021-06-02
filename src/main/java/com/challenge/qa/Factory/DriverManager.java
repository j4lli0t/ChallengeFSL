package com.challenge.qa.Factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager
{
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver initDriver()
    {
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
        return getDriver();
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }
}
