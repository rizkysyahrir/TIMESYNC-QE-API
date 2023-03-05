package starter.timesync.StepDef;

import io.cucumber.java.bs.A;
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

public class RecordStepDef {

    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("GET record employees with id {int}, date from {string}, and date to {string}")
    public void getRecordEmployees(int id, String df, String dt){
        timesyncAPIAdmin.setGetRecordEmployees(id, df, dt);
    }

    @Given("GET record employees invalid param with id {int}, date from {string}, and date to {string}")
    public void getRecordEmployeesInvalidParam(int id, String df, String dt){
        timesyncAPIAdmin.setGetRecordEmployeesInvalidParam(id, df, dt);
    }

    @When("Send request get record by admin")
    public void sendRequestGetRecord(){
        SerenityRest.when().get(TimesyncAPIAdmin.GET_RECORD);
    }

    @And("Response body message get record should be: \"success show employee attendance record\"")
    public void responseBodyMessagePostAttendance(){
        String expectedMessage = "success show employee attendance record";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get record employees")
    public void validateJsonSchemaRecord(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/RecordSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
