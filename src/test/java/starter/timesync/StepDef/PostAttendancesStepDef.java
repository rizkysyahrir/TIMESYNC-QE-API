package starter.timesync.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.timesync.TimesyncAPI;
import starter.timesync.Utils.Constant;

import java.io.File;

public class PostAttendancesStepDef {
    @Steps
    TimesyncAPI timesyncAPI;
    @Given("Post Attendances with valid token")
    public void postAttendancesWithValidToken() {
        timesyncAPI.setPostAttendancesEmployee();
    }

    @When("Send request post attendances")
    public void sendRequestPostAttendances() {
        SerenityRest.when().post(TimesyncAPI.POST_ATTENDANCES_EMPLOYEE);
    }
}
