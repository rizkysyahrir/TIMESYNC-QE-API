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

import static org.hamcrest.Matchers.equalTo;

public class PostApprovalsStepDef {
    @Steps
    TimesyncAPI timesyncAPI;
    @Given("Post employee with valid token and json")
    public void postEmployeeWithValidTokenAndJson() {
        File jsonPostApprovals = new File(Constant.JSON_REQUEST+"/PostApprovals.json");
        timesyncAPI.setApprovalsJsonAndToken(jsonPostApprovals);
    }

    @When("Send request post employee approvals")
    public void sendRequestPostEmployeeApprovals() {
        SerenityRest.when().post(TimesyncAPI.POST_APPROVALS_EMPLOYEE);
    }

    @And("Validate JSON schema post approvals")
    public void validateJSONSchemaPostApprovals() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/PostApprovalsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }

    @And("Response body should contain {string} as approval_title {string} as ApprovalStarDate" +
            "{string} ApprovalEndDate {string} ApprovalDescription")
    public void responseBodyShouldContain(String approval_title, String approval_start_date, String approval_end_date, String approval_description) {
        SerenityRest.then()
                .body("approval_title", equalTo(approval_title))
                .body("approval_start_date", equalTo(approval_start_date))
                .body("approval_end_date", equalTo(approval_end_date))
                .body("approval_description", equalTo(approval_description));
    }

    @Given("Post employee with valid token and empty title")
    public void postEmployeeWithValidTokenAndEmptyTitle() {
        File jsonPostApprovals = new File(Constant.JSON_REQUEST+"/FailedPostApprovalsEmptyTitle.json");
        timesyncAPI.setApprovalsJsonAndToken(jsonPostApprovals);
    }


    @Given("Post employee with valid token and empty Approvals Start Date")
    public void postEmployeeWithValidTokenAndEmptyApprovalsStartDate() {
        File jsonPostApprovals = new File(Constant.JSON_REQUEST+"/FailedPostApprovalsEmptyStartDate.json");
        timesyncAPI.setApprovalsJsonAndToken(jsonPostApprovals);
    }

    @Given("Post employee with valid token and empty Approvals End Date")
    public void postEmployeeWithValidTokenAndEmptyApprovalsEndDate() {
        File jsonPostApprovals = new File(Constant.JSON_REQUEST+"/FailedPostApprovalsEmptyEndDate.json");
        timesyncAPI.setApprovalsJsonAndToken(jsonPostApprovals);
    }

    @Given("Post employee with valid token and empty Approvals Description")
    public void postEmployeeWithValidTokenAndEmptyApprovalsDescription() {
        File jsonPostApprovals = new File(Constant.JSON_REQUEST+"/FailedPostApprovalsEmptyDescription.json");
        timesyncAPI.setApprovalsJsonAndToken(jsonPostApprovals);
    }

    @Given("Post employee with invalid token and json")
    public void postEmployeeWithInvalidTokenAndJson() {
        File jsonPostApprovals = new File(Constant.JSON_REQUEST+"/FailedPostApprovalsEmptyDescription.json");
        timesyncAPI.setApprovalsInvalidTokenAndValidJson(jsonPostApprovals);
    }
}
