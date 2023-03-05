package starter.timesync.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.timesync.TimesyncAPIAdmin;
import starter.timesync.Utils.Constant;
import starter.timesync.Utils.TimesyncResponse;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class AttendanceAdminStepDef {
    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("POST attendance employees by admin with id {int}, attendance {string}, date start {string}, date end {string}")
    public void postAttendanceEmployeesAdmin(int id, String at, String ds, String de){
        timesyncAPIAdmin.setPostAttendanceEmployees(id, at, ds, de);
    }

    @When("Send request post attendance employees by admin")
    public void sendRequestPostAttendanceEmployees(){
        SerenityRest.when().post(TimesyncAPIAdmin.POST_ATTENDANCE);
    }

    @And("Response body message post attendance employees should be: \"success create attendance\"")
    public void responseBodyMessagePostAttendance(){
        String expectedMessage = "success create attendance";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema post attendance employees by admin")
    public void validateJsonSchemaPostAttendance(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2
    @Given("POST attendance employees by admin without id, attendance {string}, date start {string}, date end {string}")
    public void postAttendanceWoId(String at, String ds, String de){
        timesyncAPIAdmin.setPostAttendanceWoId(at, ds, de);
    }

    @When("Send request post attendance employees without id")
    public void sendRequestPostAttendanceWoId(){
        SerenityRest.when().post(TimesyncAPIAdmin.POST_WO_ATTENDANCE);
    }

    @And("Response body message post attendance employees without id: \"clock in fail, you already clock in today\"")
    public void responseBodyMessagePostAttendanceWoId(){
        String expectedMessage = "clock in fail, you already clock in today";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema post attendance employees without id")
    public void validateJsonSchemaPostAttendanceWoId(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
