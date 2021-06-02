package com.challenge.qa.Modules;

import com.challenge.qa.Utils.Wrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormModule
{
    WebDriver driver;
    Wrapper wrapper;
    private static final By appName = By.xpath("//h1[@data-testid='app-name']");
    private static final By titleForm = By.xpath("//h2[@data-testid='Title']");
    private static final By petNameInput = By.xpath("//input[@data-testid='pet']");
    private static final By ownerNameInput = By.xpath("//input[@data-testid='owner']");
    private static final By dateInput = By.xpath("//input[@data-testid='date']");
    private static final By timeInput = By.xpath("//input[@data-testid='time']");
    private static final By symptomsInput = By.xpath("//textarea[@data-testid='symptoms']");
    private static final By alert = By.xpath("//p[@data-testid=\"alert\"]");
    private static final By addAppointmentButton = By.xpath("//button[@data-testid='btn-submit']");

    public FormModule(WebDriver driver)
    {

        this.driver = driver;
        this.wrapper = new Wrapper(driver);
    }

    public void doSubmit()
    {
        wrapper.doClick(addAppointmentButton);
    }

    public String submitWithFieldsEmpty() throws InterruptedException {
        doSubmit();
        return wrapper.getElement(alert).getText();
    }

    public String getURL()
    {
        return wrapper.getPageUrl();
    }

    public String getAppName()
    {
        return wrapper.getElement(appName).getText();
    }


    public void createAppointment(String petName,String ownerName,String date, String time,String symptoms) throws InterruptedException {

        wrapper.type(petNameInput,petName);
        wrapper.type(ownerNameInput,ownerName);
        wrapper.type(timeInput,time);
        driver.findElement(symptomsInput).sendKeys(symptoms);
        wrapper.type(dateInput,date);
        wrapper.doClick(addAppointmentButton);
        Thread.sleep(4000);
    }
}
