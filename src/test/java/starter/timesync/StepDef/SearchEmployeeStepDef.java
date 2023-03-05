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

public class SearchEmployeeStepDef {
    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("Get search employee with name or nip {string}")
    public void getSearchEmployee(String q){
        SerenityRest.given();
        timesyncAPIAdmin.getSearchEmployee(q);
    }
    @When("Send request search employee")
    public void sendRequestSearch(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_SEARCH);
    }

    @And("Response body message search should be: \"searching success\"")
    public void responseBodyMessageSearch(){
        String expectedMessage = "searching success";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get search employee")
    public void validateJsonSchemaSearch(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SearchSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2
    @Given("Get search employee without query param")
    public void getSearchWoParam(){
        SerenityRest.given();
        timesyncAPIAdmin.getSearchWoParam();
    }

    @And("Response body message error \"nothing to search\"")
    public void responseMessageSearchErr(){
        String expectedMessage = "nothing to search";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }
    @And("Validate json schema get search without query param")
    public void validateJsonSchemaSearchErr(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 3
    @Given("Get search employee unauthorized with name or nip {string}")
    public void getSearchUnauthorized(String q){
        SerenityRest.given();
        timesyncAPIAdmin.getSearchUnauthorized(q);
    }

    @And("Response body message unauthorized \"access denied\"")
    public void responseMessageSearchUnauthorized(){
        String expectedMessage = "access denied";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get search unauthorized")
    public void validateJsonSchemaSearchUnauthorized(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 4 not found
    @And("Response body message error search: \"user not found\"")
    public void responseMessageSearchNotFound(){
        String expectedMessage = "user not found";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get search user not found")
    public void validateJsonSchemaSearchNotFound(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
