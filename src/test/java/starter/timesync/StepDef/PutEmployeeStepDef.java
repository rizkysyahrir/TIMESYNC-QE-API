package starter.timesync.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.timesync.TimesyncAPI;
import starter.timesync.Utils.Constant;

import java.io.File;

public class PutEmployeeStepDef {
    @Steps
    TimesyncAPI timesyncAPI;

    @Given("Put update employee with empty data")
    public void putEmployeeWithValidToken() {
        timesyncAPI.setPutEmployees();
    }

    @When("Send request put employees")
    public void sendRequestPutEmployee() {
        SerenityRest.when().put(TimesyncAPI.PUT_EMPLOYEES);
    }


    @Given("Put employee with invalid token")
    public void putEmployeeWithInvalidToken() {
        timesyncAPI.setPutEmployeesInvalidToken();
    }

    @Given("Put update employees image and password {string}")
    public void putEmployeesPhotoAndPassword(String password) {
        File image = new File(Constant.IMAGE_REQUEST+"/goku.jpg");
        timesyncAPI.setPutEmployeesImagesAndPassword(password, image);
    }

    @Given("Put update employees invalid image")
    public void putUpdateEmployeesInvalidImageCsv() {
        File csv = new File(Constant.CSV_REQUEST+"/fileCsv.csv");
        timesyncAPI.setPutEmployeesImagesInvalidFormatCsv(csv);
    }
}
