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

public class AdminApprovalStepDef {
    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("GET approvals employees with role admin")
    public void getApprovalsEmployees(){
        SerenityRest.given();
        timesyncAPIAdmin.getApprovalsEmployees();
    }

    @When("Send request get approvals employees")
    public void sendRequestApprovalsEmployees(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_LIST_APPROVALS_EMPLOYEES);
    }

    @And("Response body message get approvals should be status: \"success show all employee approval record\"")
    public void responseBodyMessageGetApprovals() {
        String expectedMessage = "success show all employee approval record";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get approvals")
    public void validateGetApprovals(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetApprovalsSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Negative
    @Given("Get approvals with ID {int}")
    public void getApprovalsEmployeesWithId(int id){
        SerenityRest.given();
        timesyncAPIAdmin.getApprovalsEmployeesWithId(id);
    }

    @When("Send request get approvals employees with ID")
    public void sendRequestApprovalsEmployeesByID(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_PUT_APPROVALS_EMPLOYEES);
    }

    @And("Response body message get approvals should be status: \"success get approval detail\"")
    public void responseBodyMessageGetApprovalsId() {
        String expectedMessage = "success get approval detail";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema approvals with id")
    public void validateApprovalsID(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetApprovalsIdSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    //S3

    @Given("Get admin approvals without token")
    public void getAdminApproveWoToken(){
        SerenityRest.given();
        timesyncAPIAdmin.getApproveEmployeesWoToken();
    }

    @And("Response body message approvals without token should be status: \"missing or malformed jwt\"")
    public void responseBodyMessageGetApproveWoToken(){
        String expectedMessage = "missing or malformed jwt";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    //Scenario PUT

    @Given("PUT update approvals employee ID {int} with approval status {string}")
    public void putApprovalsEmployeeID(int id, String approvals_status){
        timesyncAPIAdmin.setUpdateApprovalsEmployee(id, approvals_status);
    }

    @When("Send request update approvals employees")
    public void updateApprovalsEmployees(){
        SerenityRest.when().put(TimesyncAPIAdmin.GET_PUT_APPROVALS_EMPLOYEES);
    }

    @And("Response body message update approvals should be: \"success approve employee permission\"")
    public void responseBodyMessageUpdateApprovals(){
        String expectedMessage = "success approve employee permission";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Response body message update approvals another case should be: \"unable to process data\"")
    public void responseBodyMessageUpdateApprovalsAnotherCase(){
        String expectedMessage = "unable to process data";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema update approvals employees")
    public void validateJsonSchemaUpdateApprovals(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/UpdateApprovalsEmployeeSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}