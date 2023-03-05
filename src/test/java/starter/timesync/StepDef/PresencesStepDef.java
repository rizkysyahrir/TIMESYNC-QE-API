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

public class PresencesStepDef {
    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("Get presences total employees by admin")
    public void getPresencesTotal(){
        SerenityRest.given();
        timesyncAPIAdmin.getPresences();
    }

    @When("Send request presences total employees")
    public void sendRequestPresencesTotal(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_PRESENCES_TOTAL);
    }

    @And("Response body message get presences total should be: \"success show all employe presence data today\"")
    public void responseMessageGetPresencesTotal(){
        String expectedMessage = "success show all employe presence data today";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get presences total")
    public void validateJsonSchemaPresencesTotal(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/PresencesTotalSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    //Scenario Presences Detail
    @Given("Get presences detail employees by admin with id {int}")
    public void getPresencesDetail(int id){
        SerenityRest.given();
        timesyncAPIAdmin.getPresencesDetail(id);
    }

    @When("Send request get presences detail")
    public void sendRequestPresencesDetail(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_PRESENCES_DETAIL);
    }

    @And("Response body message get presences detail should be: \"success show presence data detail\"")
    public void responseMessageGetPresencesDetail(){
        String expectedMessage = "success show presence data detail";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }
    @And("Validate json schema get presences detail")
    public void validateJsonSchemaPresencesDetail(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/PresencesDetailSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
