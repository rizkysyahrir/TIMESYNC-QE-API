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

public class LoginAdminStepDef {

    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("Login admin with valid json")
    public void loginAdminValidJson(){
        File json = new File(Constant.JSON_REQUEST+"/LoginAdmin.json");
        timesyncAPIAdmin.postLoginAdmin(json);
    }

    @When("Send request post login admin")
    public void sendRequestLoginAdmin(){
        SerenityRest.when().post(TimesyncAPIAdmin.POST_LOGIN_ADMIN);
    }

    @And("Response body message should be status: \"success login\"")
    public void responseBodyMessage(){
        String expectedMessage = "success login";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
  }

    @And("Validate json schema login as an admin")
    public void validateJsonSchemaLoginAdmin(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/LoginAdminSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2

    @Given("Login admin with invalid json")
    public void loginAdminInvalidJson(){
        File json = new File(Constant.JSON_REQUEST+"/LoginAdminInvalid.json");
        timesyncAPIAdmin.postLoginAdmin(json);
    }

    @And("Response body message should be status: \"password not match\"")
    public void responseBodyMessageError() {
        String expectedMessage = "password not match";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema login as an admin invalid json")
    public void validateJsonSchemaLoginAdminInvalid(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/LoginAdminInvalidSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
