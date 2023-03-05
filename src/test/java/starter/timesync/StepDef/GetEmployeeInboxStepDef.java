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

public class GetEmployeeInboxStepDef {
    @Steps
    TimesyncAPI timesyncAPI;

    @Given("Get employee Inbox with valid token")
    public void getEmployeeInboxWithValidToken() {
        timesyncAPI.setGetEmployeeInbox();
    }

    @When("Send request get employee Inbox")
    public void sendRequestGetEmployeeInbox() {
        SerenityRest.when().get(TimesyncAPI.GET_EMPLOYEE_INBOX);
    }

    @And("Validate JSON schema get employee Inbox")
    public void validateJSONSchemaGetEmployeeInbox() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetEmployeeInboxSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get employee inbox with invalid token")
    public void getEmployeeInboxWithInvalidToken() {
        timesyncAPI.setGetEmployeeInboxInvalidToken();
    }

    @When("Send request get employee inbox invalid path")
    public void sendRequestGetEmployeeInboxInvalidPath() {
        SerenityRest.when().get(TimesyncAPI.GET_EMPLOYEE_INBOX_INVALID_PATH);
    }
}
