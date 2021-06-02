package com.challenge.qa.Modules;

import com.challenge.qa.Utils.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentModule
{
    WebDriver driver;
    Wrapper wrapper;
    private static final By titleForm = By.xpath("//h2[@data-testid='dynamic-title']");
    private static final By deleteButton = By.xpath("//button[@data-testid='btn-delete']");

    public AppointmentModule(WebDriver driver)
    {
        this.driver = driver;
        wrapper = new Wrapper(driver);
    }

    public String verifyNotAppointments()
    {
        return wrapper.getElement(titleForm).getText();
    }

    public void deleteAppointment()
    {
        wrapper.doClick(deleteButton);
    }

    public String checkTitleAppointment()
    {
        return wrapper.getElement(titleForm).getText();
    }

}
