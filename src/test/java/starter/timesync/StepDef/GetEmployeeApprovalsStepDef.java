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
import java.sql.Time;

public class GetEmployeeApprovalsStepDef {
    @Steps
    TimesyncAPI timesyncAPI;

    @Given("Get Employee Approvals with valid token")
    public void getEmployeeApprovalsWithValidToken() {
        timesyncAPI.setGetEmployeeApprovals();
    }

    @When("Send request get Employee Approvals")
    public void sendRequestGetEmployeeApprovals() {
        SerenityRest.when().get(TimesyncAPI.GET_EMPLOYEE_APPROVALS);
    }

    @And("Validate JSON schema get Employee Approvals")
    public void validateJSONSchemaGetEmployeeApprovals() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetEmployeeApprovalsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get Employee Approvals with invalid token")
    public void getEmployeeApprovalsWithInvalidToken() {
        timesyncAPI.setGetEmployeeApprovalsInvalidToken();

    }

    @Given("Get Employee Approvals without token")
    public void getEmployeeApprovalsWithoutToken() {
        timesyncAPI.setGetEmployeeApprovalsWithoutToken();
    }

    @When("Send request get Employee Approvals with invalid path")
    public void sendRequestGetEmployeeApprovalsWithInvalidPath() {
        SerenityRest.when().get(TimesyncAPI.GET_EMPLOYEE_APPROVALS_INVALID_PATH);
    }
}
