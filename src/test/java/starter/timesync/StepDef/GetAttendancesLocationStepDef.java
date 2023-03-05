package starter.timesync.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.timesync.TimesyncAPI;
import starter.timesync.Utils.Constant;

import java.io.File;

public class GetAttendancesLocationStepDef {
    @Steps
    TimesyncAPI timesyncAPI;
    @Given("Get attendances location employee with valid token")
    public void getAttendancesLocationEmployeeWithValidToken() {
        timesyncAPI.setGetAttendancesLocationEmployee();
    }

    @When("Send request get attendances location employee")
    public void sendRequestGetAttendancesLocationEmployee() {
        SerenityRest.when().get(TimesyncAPI.GET_ATTENDANCES_LOCATION_EMPLOYEE);
    }

    @And("Validate JSON schema get attendances location")
    public void validateJSONSchemaGetAttendancesLocation() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetAttendancesLocationSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @When("Send request get attendances location with invalid path")
    public void sendRequestGetAttendancesLocationInvalidPath() {
        SerenityRest.when().get(TimesyncAPI.GET_ATTENDANCES_LOCATION_EMPLOYEE_INVALID_PATH);
    }

    @Given("Get attendances location employee with invalid token")
    public void getAttendancesLocationEmployeeWithInvalidToken() {
        timesyncAPI.setGetAttendancesLocationInvalidToken();
    }
}
