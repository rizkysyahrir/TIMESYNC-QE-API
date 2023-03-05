package starter.timesync.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.timesync.AuthApi;
import starter.timesync.Utils.Constant;

import java.io.File;

import static org.hamcrest.core.StringContains.containsString;

public class LoginEmployeeStepDef {
    @Steps
    AuthApi authApi;
    @Given("Login with valid JSON")
    public void loginWithValidJSON() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/PostLogin.json");
        authApi.postLogin(jsonRequest);
    }

    @When("Send request post to login")
    public void sendRequestPostToLogin() {
        SerenityRest.when().post(AuthApi.POST_LOGIN);
    }

    @And("Validate json schema success login")
    public void validateJsonSchemaSuccessLogin() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginEmployeeSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Login empty password with invalid JSON")
    public void loginWithInvalidJSON() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/FailedPostLoginEmptyPass.json");
        authApi.postLogin(jsonRequest);
    }

    @And("Response body message {string}")
    public void responseBodyMessage(String Message) {
        SerenityRest.then()
                .assertThat()
                .body("message", containsString(Message));
    }

    @Given("Login empty nip with invalid JSON")
    public void loginEmptyNipWithInvalidJSON() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/FailedPostLoginNipEmpty.json");
        authApi.postLogin(jsonRequest);
    }

    @Given("Login employee invalid nip and valid password")
    public void loginEmployeeInvalidNipAndValidPassword() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/FailedPostLoginInvalidNip.json");
        authApi.postLogin(jsonRequest);
    }

    @Given("Login employee invalid password and valid nip")
    public void loginEmployeeInvalidPasswordAndValidNip() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/FailedPostLoginInvalidPass.json");
        authApi.postLogin(jsonRequest);
    }

    @Given("Login employee without fill nip and password")
    public void loginEmployeeWithoutFillNipPassword() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/FailedPostLoginEmptyData.json");
        authApi.postLogin(jsonRequest);
    }
}
