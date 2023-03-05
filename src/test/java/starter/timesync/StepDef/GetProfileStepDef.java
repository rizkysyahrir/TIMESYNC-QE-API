package starter.timesync.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.timesync.TimesyncAPI;
import starter.timesync.Utils.Constant;

import java.io.File;
import java.sql.Time;

public class GetProfileStepDef {
    @Steps
    TimesyncAPI timesyncAPI;
    @Given("Get employee profile with valid token")
    public void getProfileEmployeeWithValidToken() {
            timesyncAPI.setGetProfileEmployee();
    }

    @When("Send request get profile employee")
    public void sendRequestGetProfileEmployee() {
        SerenityRest.when().get(TimesyncAPI.GET_PROFILE_EMPLOYEES);
    }

    @And("Validate JSON schema get employee profile")
    public void validateJSONSchemaGetEmployeeProfile() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetEmployeeProfileSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get employee profile without token")
    public void getEmployeeProfileWithoutToken() {
        timesyncAPI.setGetProfileEmployeeWithoutToken();

    }

    @Given("Get employee profile invalid token")
    public void getEmployeeProfileInvalidToken() {
        timesyncAPI.setGetProfileEmployeeInvalidToken();
    }

    @When("Send request get profile employee with invalid path")
    public void sendRequestGetProfileEmployeeInvalidPath() {
        SerenityRest.when().get(TimesyncAPI.GET_PROFILE_EMPLOYEES_INVALID_PATH);
    }
}
