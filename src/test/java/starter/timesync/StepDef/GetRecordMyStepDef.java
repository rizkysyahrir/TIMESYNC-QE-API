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

public class GetRecordMyStepDef {
    @Steps
    TimesyncAPI timesyncAPI;
    @Given("Get Record with token employee and parameter value date_from {string} and date_to {string}")
    public void getRecordWithTokenEmployeeAndValidParameterValueDate_fromAndDate_to(String date_from, String date_to)
    {
        timesyncAPI.setGetRecordWithParam(date_from, date_to);
    }
    @When("Send request get record")
    public void sendRequestGetRecord() {
        SerenityRest.when().get(TimesyncAPI.GET_RECORD_ID_EMPLOYEE);
    }

    @And("Validate JSON schema get record")
    public void validateJSONSchemaGetRecord() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetRecordEmployeeSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get Record with invalid token employee and parameter value date_from {string} and date_to {string}")
    public void getRecordWithInvalidTokenEmployeeAndParameterValueDate_fromAndDate_to(String date_from, String date_to)
    {
        timesyncAPI.setGetRecordWithInvalidToken(date_from, date_to);
    }
}
