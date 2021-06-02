package com.challenge.qa.Base;

import com.challenge.qa.Factory.DriverManager;
import com.challenge.qa.Modules.AppointmentModule;
import com.challenge.qa.Modules.FormModule;
import com.challenge.qa.Utils.ExcelUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class Base
{
    DriverManager driverManager;
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected AppointmentModule appointmentModule;
    protected FormModule formModule;
    @BeforeClass
    public void setUp() throws IOException {
        driverManager = new DriverManager();
        driver = driverManager.initDriver();
        driver.manage().window().maximize();
        driver.get(ExcelUtil.getData("properties",0,0));
        appointmentModule = new AppointmentModule(driver);
        formModule = new FormModule(driver);
    }


    @AfterClass
    public void tearDown()
    {
        driver.close();
    }
}
