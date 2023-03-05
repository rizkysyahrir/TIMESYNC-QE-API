package starter.timesync.Utils;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.timesync.AuthApi;

import java.io.File;

public class Authorization {
    public String getToken() {
        File jsonRequest = new File(Constant.JSON_REQUEST + "/PostLogin.json");
        Response response = SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(jsonRequest)
                .post(AuthApi.POST_LOGIN);

        JsonPath jsonPathEvaluator = response.jsonPath();
        String token = jsonPathEvaluator.get("token");
        return token;
    }
}


