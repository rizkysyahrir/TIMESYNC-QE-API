package starter.timesync.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.checkerframework.checker.units.qual.Time;
import starter.timesync.TimesyncAPI;
import starter.timesync.Utils.Constant;

import java.io.File;

public class GetAttendancesStepDef {
    @Steps
    TimesyncAPI timesyncAPI;

    @Given("Get attendances employee with token and params value date_from {string} and date_to {string}")
    public void getAttendancesEmployeeWithParams(String date_from, String date_to) {
        timesyncAPI.setGetAttendancesWithParam(date_from, date_to);
    }

    @When("Send request get attendances")
    public void sendRequestGetAttendanceWithValidParamsEmployee() {
        SerenityRest.when().get(TimesyncAPI.GET_ATTENDANCES_EMPLOYEE);
    }

    @And("Validate JSON schema get attendances")
    public void validateJSONSchemaGetAttendances() {
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/GetAttendancesSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get attendances employee with token and invalid params value date_from {string} and date_to {string}")
    public void getAttendancesEmployeeWithTokenAndInvalidParamsValueDate_fromAndDate_to(String date_from, String date_to)
    {
        timesyncAPI.setGetAttendancesWithParam(date_from, date_to);
    }

    @Given("Get attendances employee with invalid token and params value date_from {string} and date_to {string}")
    public void getAttendancesEmployeeWithInvalidTokenAndParamsValueDate_fromAndDate_to(String date_from, String date_to)
    {
        timesyncAPI.setGetAttendancesWithInvalidToken(date_from, date_to);
    }
}
