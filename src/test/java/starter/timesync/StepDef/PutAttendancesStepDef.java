package starter.timesync.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.timesync.TimesyncAPI;

public class PutAttendancesStepDef {
    @Steps
    TimesyncAPI timesyncAPI;
    @Given("Put attendances with valid token")
    public void putAttendancesWithValidToken() {
        timesyncAPI.setPutAttendancesEmployee();
    }

    @When("Send request put attendances")
    public void sendRequestPutAttendances() {
        SerenityRest.when().put(TimesyncAPI.PUT_ATTENDANCES_EMPLOYEE);
    }
}
