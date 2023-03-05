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

public class AnnouncementsStepDef {

    @Steps
    TimesyncAPIAdmin timesyncAPIAdmin;

    //Scenario 1 GET
    @Given("GET list announcements by admin")
    public void getListAnnouncements() {
        SerenityRest.given();
        timesyncAPIAdmin.getListAnnouncements();
    }

    @When("Send request get list announcements")
    public void sendRequestGetListAnnounce() {
        SerenityRest.when().get(TimesyncAPIAdmin.GET_LIST_ANNOUNCEMENTS);
    }

    @And("Validate json schema all list announcements")
    public void validateJsonSchemaListAnnounce(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/ListAnnounceSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 2 GET
    @Given("GET Announcements by id {int}")
    public void getAnnounceById(int id){
        SerenityRest.given();
        timesyncAPIAdmin.getAnnouncementsById(id);
    }

    @When("Send request get announcements by id")
    public void sendRequestGeAnnounceById() {
        SerenityRest.when().get(TimesyncAPIAdmin.GET_ANNOUNCEMENTS_ID);
    }

    @And("Response body message get should be status: \"success get announcement details\"")
    public void responseBodyMessageGetAnnounceById() {
        String expectedMessage = "success get announcement details";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema announcements by id")
    public void validateJsonSchemaSingleAnnounce(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/SingleAnnounceSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario 3 GET
    @And("Response body message get should be status: \"announcement not found\"")
    public void responseBodyMessageGetAnnounceUnregisterID() {
        String expectedMessage = "announcement not found";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema announcements unregistered id")
    public void validateJsonSchemaAnnounceUnregisteredID(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    //Scenario Post
    @Given("Post admin create announcements for employee")
    public void createAnnounceValidJson(){
        File json = new File(Constant.JSON_REQUEST+"/CreateAnnounce.json");
        timesyncAPIAdmin.postCreateAnnounce(json);
    }

    @When("Send request create announcements from employee")
    public void sendRequestCreateAnnounce(){
        SerenityRest.when().post(TimesyncAPIAdmin.POST_ANNOUNCEMENTS);
    }

    @When("Send request create announcements from employee fail")
    public void sendRequestCreateAnnounceFail(){
        SerenityRest.when().post(TimesyncAPIAdmin.POST_ANNOUNCEMENTS_FAIL);
    }

    @And("Validate json schema create announce from employee")
    public void validateJsonSchemaCreateAnnounce(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/CreateAnnounceSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Validate json schema create announce fail to employee")
    public void validateJsonSchemaCreateAnnounceFail(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/MessageSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @And("Response body message fail should be status: \"Not Found\"")
    public void responseBodyMessagePostAnnounceFail() {
        String expectedMessage = "Not Found";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    //Scenario POST Personal

    @Given("Post admin create announcements with specifications nip {string}, tittle {string}, description {string}")
    public void createAnnounceWithNip(String to, String at, String ad){
        timesyncAPIAdmin.postCreateAnnounceNip(to, at, ad);
    }

    @And("Response body message post announcements should be status: \"send announcement message to employee success\"")
    public void responseBodyMessage() {
        String expectedMessage = "send announcement message to employee success";
        String actualMessage = SerenityRest.then().extract().path(TimesyncResponse.MESSAGE);
        assertEquals(expectedMessage, actualMessage);
    }

    @And("Validate json schema create announcements with nip")
    public void validateJsonSchemaCreateAnnounceWithNip(){
        File jsonSchema = new File(Constant.JSON_SCHEMA+"/CreateAnnounceWithNipSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
