package starter.timesync.StepDef;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.timesync.TimesyncAPIAdmin;
import starter.timesync.Utils.TimesyncResponse;

import static org.junit.Assert.assertEquals;

public class AdminDeleteStepDef {

    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("DELETE employees by admin with id {int}")
    public void deleteEmployees(int id){
        timesyncAPIAdmin.deleteEmployees(id);
    }

    @When("Send request delete employee")
    public void sendRequestDeleteEmployee(){
        SerenityRest.when().delete(TimesyncAPIAdmin.DELETE_EMPLOYEE);
    }

    @And("Response body message delete should be: \"success deactivate employee profile\"")
    public void responseBodyMessageDelete(){
        String expectedMessage = "success deactivate employee profile";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

   //Scenario 2
    @Given("DELETE announcements by admin with id {int}")
    public void deleteAnnounce(int id){
        timesyncAPIAdmin.deleteAnnounce(id);
    }

    @When("Send request delete announcements")
    public void sendRequestDeleteAnnounce(){
        SerenityRest.when().delete(TimesyncAPIAdmin.DELETE_ANNOUNCEMENTS);
    }
    @And("Response body message delete should be: \"success delete announcement\"")
    public void responseBodyMessageDeleteAnnounce(){
        String expectedMessage = "success delete announcement";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }
}
