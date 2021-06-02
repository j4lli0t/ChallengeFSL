package com.challenge.qa.TestCases;

import com.challenge.qa.Base.Base;
import com.challenge.qa.Utils.ExcelUtil;
import org.testng.annotations.Test;

import java.io.IOException;

public class someTest extends Base {
    @Test(description = "When we don’t have any appointments we need to see a message saying 'There are no Appointments'",
            priority = 0)
    public void verifyThereAreNoItems() throws IOException {
        softAssert.assertEquals(appointmentModule.verifyNotAppointments(), ExcelUtil.getData("Messages", 0, 0));
        softAssert.assertAll();
    }

    @Test(description = "When we leave any field empty a warning appear and indicate that 'All fields are required'",
            priority = 1)
    public void allFieldsAreRequired() throws IOException, InterruptedException {
        softAssert.assertEquals(formModule.submitWithFieldsEmpty(), ExcelUtil.getData("Messages", 1, 0));
        softAssert.assertAll();
    }

    @Test(description = "Verify if the URL is the correct.", priority = 2)
    public void verifyURL() throws IOException {
        softAssert.assertEquals(formModule.getURL(), ExcelUtil.getData("properties", 0, 0));
        softAssert.assertAll();
    }

    @Test(description = "Verify the app name is APPOINTMENT MANAGEMENT", priority = 3)
    public void verifyAppName() throws IOException {
        softAssert.assertEquals(formModule.getAppName(), ExcelUtil.getData("Messages", 2, 0));
        softAssert.assertAll();
    }

    @Test(description = "Create an Appointment and delete it.", priority = 4)
    public void createAndDeleteAppointment() throws IOException, InterruptedException {
        formModule.createAppointment(
                ExcelUtil.getData("Data", 0, 0),
                ExcelUtil.getData("Data", 1, 0),
                ExcelUtil.getData("Data", 2, 0),
                ExcelUtil.getData("Data", 3, 0),
                ExcelUtil.getData("Data", 4, 0)
        );
        appointmentModule.deleteAppointment();
    }


    @Test(description = "Try to create an appointment with the same date and hour.", priority = 5)
    public void createRepeatAppointment() throws IOException, InterruptedException {
        formModule.createAppointment(
                ExcelUtil.getData("Data", 0, 0),
                ExcelUtil.getData("Data", 1, 0),
                ExcelUtil.getData("Data", 2, 0),
                ExcelUtil.getData("Data", 3, 0),
                ExcelUtil.getData("Data", 4, 0)
        );
        formModule.createAppointment(
                ExcelUtil.getData("Data", 0, 0),
                ExcelUtil.getData("Data", 1, 0),
                ExcelUtil.getData("Data", 2, 0),
                ExcelUtil.getData("Data", 3, 0),
                ExcelUtil.getData("Data", 4, 0)
        );
    }


    @Test(description = "Try to create a pet name and Owner name with special characters", priority = 6)
    public void specialCharacters() throws IOException, InterruptedException {
        formModule.createAppointment(
                "121212**$&&**@(@#(_)$)",
                "*((!)!@**!#&&#!@??$?!1212sdjnq",
                ExcelUtil.getData("Data", 2, 0),
                ExcelUtil.getData("Data", 3, 0),
                ExcelUtil.getData("Data", 4, 0));
    }

    @Test(description = "Check when there is an appointment the subtitle of the appointment module change to MANAGE YOUR APPOINTMENTS", priority = 7)
    public void checkTitle() throws IOException, InterruptedException {
        softAssert.assertEquals(appointmentModule.checkTitleAppointment(), ExcelUtil.getData("Messages", 3, 0));
        softAssert.assertAll();
    }
}
