package starter.timesync.Utils;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class TimesyncResponse {

    public static String  MESSAGE = "message";

    @Then("Should return status code {int}")
    public void ShouldReturnStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}