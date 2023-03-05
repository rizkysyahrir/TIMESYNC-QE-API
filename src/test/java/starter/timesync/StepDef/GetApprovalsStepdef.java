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

public class GetApprovalsStepdef {
    @Steps
    TimesyncAPI timesyncAPI;

    @Given("Get approvals with valid token")
    public void getApprovalsWithValidToken(){
        timesyncAPI.setGetApprovalsEmployees();
    }

    @When("Send request get approvals")
    public void sendRequestGetApprovals() {
        SerenityRest.when().get(TimesyncAPI.GET_APPROVALS_EMPLOYEES);
    }

    @And("Validate JSON schema get approvals")
    public void validateJSONSchemaGetApprovals() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetApprovalsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get approvals with invalid token")
    public void getApprovalsWithInvalidToken() {
        timesyncAPI.setGetApprovalsInvalidToken();
    }

    @When("Send request get approvals with invalid path")
    public void sendRequestGetApprovalsWithInvalidPath() {
        SerenityRest.when().get(TimesyncAPI.GET_APPROVALS_EMPLOYEE_INVALID);
    }

    @Given("Get approvals without token")
    public void getApprovalsWithoutToken() {
        timesyncAPI.setGetApprovalsWithoutToken();
    }
}
