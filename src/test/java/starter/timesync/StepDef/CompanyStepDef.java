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

public class CompanyStepDef {

    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    @Given("GET Company profile by admin")
    public void getCompanyProfile(){
        SerenityRest.given();
        timesyncAPIAdmin.getCompanyProfiles();
    }

    @When("Send request get company profiles")
    public void sendRequestGetCompanyProfiles() {
        SerenityRest.when().get(TimesyncAPIAdmin.GET_PUT_COMPANY_PROFILES);
    }

    @And("Response body message get should be status: \"success show company profile\"")
    public void responseBodyMessageGetCompany() {
        String expectedMessage = "success show company profile";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get company profiles")
    public void validateJsonSchemaCompanyProfiles(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/CompanyProfileSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Negative

    @Given("GET Company profile with unauthorized")
    public void getCompanyProfileUnauthorized(){
        SerenityRest.given();
        timesyncAPIAdmin.getUnauthCompanyProfiles();
    }

    @When("Send request get company profiles unauthorized")
    public void sendRequestGetCompanyProfilesUnauthorized() {
        SerenityRest.when().get(TimesyncAPIAdmin.GET_PUT_COMPANY_PROFILES);
    }

    @And("Response body message get should be status: \"invalid or expired jwt\"")
    public void responseBodyMessageGetCompanyUnauthorized() {
        String expectedMessage = "invalid or expired jwt";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema get company profiles unauthorized token")
    public void validateJsonSchemaCompanyProfilesUnauth(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
    //Scenario PUT
    @Given("Update company profile with image, set company_name {string}, company_email {string}," +
            "description {string},company_address {string}, company_phone {string}, sosmed {string}")
    public void updateCompanyProfiles(String company_name, String company_email, String description,
                                      String company_address, String company_phone, String sosmed) {
        File image = new File(Constant.IMAGE_REQUEST + "/momonosuke.jpg");
        timesyncAPIAdmin.setUpdateCompanyProfiles(company_name, company_email, description,
                company_address, company_phone, sosmed, image);
    }

    @When("Send request update company profile")
    public void sendRequestUpdateCompanyProfile(){
        SerenityRest.when().put(TimesyncAPIAdmin.GET_PUT_COMPANY_PROFILES);
    }

    @And("Response body message put should be status: \"success update company profile\"")
    public void responseMessageUpdateCompany(){
        String expectedMessage = "success update company profile";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

}
