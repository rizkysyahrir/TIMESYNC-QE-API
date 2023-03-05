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

public class GraphStepDef {

    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("GET graph by admin with type {string}, year_month {string}, and limit {string}")
    public void getGraph(String type, String ym, String lim){
        SerenityRest.given();
        timesyncAPIAdmin.setGetGraph(type, ym, lim);
    }

    @When("Send request get graph")
    public void sendRequestGraoh(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_GRAPH);
    }

    @And("Response body message get graph should be: \"success show graph data\"")
    public void responseBodyMessagGraph(){
        String expectedMessage = "success show graph data";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Response body message error get graph should be: \"wrong type parameter\"")
    public void responseBodyMessageErrorGraph(){
        String expectedMessage = "wrong type parameter";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema mtwh graph")
    public void validateJsonSchemaMTWHGraph(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GraphMtwhSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate json schema mtel graph")
    public void validateJsonSchemaMTELGraph(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GraphMtelSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
