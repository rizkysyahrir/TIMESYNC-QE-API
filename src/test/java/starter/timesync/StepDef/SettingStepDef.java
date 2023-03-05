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

public class SettingStepDef {

    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("GET setting employees by admin")
    public void getSettingEmployee() {
        SerenityRest.given();
        timesyncAPIAdmin.getSettingEmployees();
    }

    @When("Send request get setting employees")
    public void sendRequestEmployees(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_PUT_SETTING);
    }

    @And("Response body message get should be status: \"success show setting\"")
    public void responseBodyMessageSetting() {
        String expectedMessage = "success show setting";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get setting employees")
    public void validateGetSettingSchema(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SettingEmployeeSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Update Setting
    @Given("PUT Admin update setting employees working hour start {string}, working hour end {string}" +
            ", tolerance {string}, annual leave {string}")
    public void editSettingEmployees(String working_hour_start, String working_hour_end, String tolerance,
                                     String annual_leave){
        timesyncAPIAdmin.setUpdateSettingEmployees(working_hour_start, working_hour_end, tolerance, annual_leave);
    }

    @When("Send request update setting employees")
    public void sendRequestUpdateSetting(){
        SerenityRest.when().put(TimesyncAPIAdmin.GET_PUT_SETTING);
    }

    @And("Response body message update setting should be status: \"success change setting\"")
    public void responseBodyMessageUpdateSetting() {
        String expectedMessage = "success change setting";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema update setting")
    public void validateUpdateSetting(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateSettingEmployeeSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
