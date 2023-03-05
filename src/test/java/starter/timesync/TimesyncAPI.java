package starter.timesync;


import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.timesync.Utils.Constant;

import java.io.File;

public class TimesyncAPI {
    public static String GET_PROFILE_EMPLOYEES = Constant.BASE_URL + "/employees/profile";
    public static String GET_PROFILE_EMPLOYEES_INVALID_PATH = Constant. BASE_URL + "/employees/profilXYZ";
    public static String PUT_EMPLOYEES = Constant.BASE_URL + "/employees";
    public static String POST_APPROVALS_EMPLOYEE = Constant.BASE_URL + "/approvals";
    public static String GET_APPROVALS_EMPLOYEES = Constant.BASE_URL + "/approvals";
    public static String GET_APPROVALS_EMPLOYEE_INVALID = Constant.BASE_URL + "/approvalsssssssss";
    public static String PUT_ATTENDANCES_EMPLOYEE = Constant.BASE_URL + "/attendances";
    public static String GET_ATTENDANCES_EMPLOYEE = Constant.BASE_URL + "/attendances";
    public static String POST_ATTENDANCES_EMPLOYEE = Constant.BASE_URL + "/attendances";
    public static String GET_ATTENDANCES_LOCATION_EMPLOYEE = Constant.BASE_URL + "/attendances/location";
    public static String GET_ATTENDANCES_LOCATION_EMPLOYEE_INVALID_PATH = Constant.BASE_URL + "/attendances/locationnn";
    public static String GET_PRESENCES_EMPLOYEE = Constant.BASE_URL + "/presences";
    public static String GET_PRESENCES_EMPLOYEE_INVALID_PATH = Constant.BASE_URL + "/presencesxyz";
    public static String GET_EMPLOYEE_INBOX = Constant.BASE_URL + "/inbox";
    public static String GET_EMPLOYEE_INBOX_INVALID_PATH = Constant.BASE_URL +"/inboxxyz";
    public static String GET_EMPLOYEE_APPROVALS = Constant.BASE_URL + "/employee/approvals";
    public static String GET_EMPLOYEE_APPROVALS_INVALID_PATH = Constant.BASE_URL + "/employee/approvalssssss";
    public static String GET_RECORD_ID_EMPLOYEE = Constant.BASE_URL + "/record/9";


    @Step("Get profile employee")
    public void setGetProfileEmployee() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjh9.Tyw9fenvyLJ7FNDlonDjaMfY8-RqKCc7gzeuVf_KF2o";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }
    @Step("Get profile employee without token")
    public void setGetProfileEmployeeWithoutToken() {
        String token = "";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }
    @Step("Get profile employee invalid token")
    public void setGetProfileEmployeeInvalidToken() {
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }

    @Step("Put employee")
    public void setPutEmployees (){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjgyfQ.i6koT9RuTRix_p2948wnXNFm69BturymDo4bsHyySlQ";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }

    @Step("Put employee invalid token")
    public void setPutEmployeesInvalidToken () {
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }

    @Step("Post Approvals with Token and JSON")
    public void setApprovalsJsonAndToken (File json) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjh9.Tyw9fenvyLJ7FNDlonDjaMfY8-RqKCc7gzeuVf_KF2o";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Post Approvals with Invalid Token and Valid JSON")
    public void setApprovalsInvalidTokenAndValidJson (File json) {
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Get Approvals with valid token")
    public void setGetApprovalsEmployees (){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjh9.Tyw9fenvyLJ7FNDlonDjaMfY8-RqKCc7gzeuVf_KF2o";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }

    @Step("Get Approvals with invalid token")
    public void setGetApprovalsInvalidToken() {
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get Approvals without token")
    public void setGetApprovalsWithoutToken (){
        String token = "";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Put Attendances with valid token and json")
    public void setPutAttendancesEmployee(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjgyfQ.i6koT9RuTRix_p2948wnXNFm69BturymDo4bsHyySlQ";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }

    @Step ("Get Attendances with param date from and date to")
    public void setGetAttendancesWithParam(String date_from, String date_to){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjl9.q4wuyQS07oMI_h567d0EwHbc8VYRVPy_WSqS4wi7Rdk";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken)
                .queryParam("date_from",date_from)
                .queryParam("date_to",date_to)
                .log().all();
    }

    @Step ("Get Attendances with invalid token param date from and date to")
    public void setGetAttendancesWithInvalidToken(String date_from, String date_to){
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken)
                .queryParam("date_from",date_from)
                .queryParam("date_to",date_to)
                .log().all();
    }

    @Step ("Get record with param date from and date to")
    public void setGetRecordWithParam(String date_from, String date_to){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjl9.q4wuyQS07oMI_h567d0EwHbc8VYRVPy_WSqS4wi7Rdk";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken)
                .queryParam("date_from",date_from)
                .queryParam("date_to",date_to)
                .log().all();
    }

    @Step ("Get record with invalid token date_from and date_to")
    public void setGetRecordWithInvalidToken(String date_from, String date_to){
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken)
                .queryParam("date_from",date_from)
                .queryParam("date_to",date_to)
                .log().all();
    }

    @Step ("Post Attendances with valid token")
    public void setPostAttendancesEmployee(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjgyfQ.i6koT9RuTRix_p2948wnXNFm69BturymDo4bsHyySlQ";
        String authToken = "Bearer " + token;
        SerenityRest.given().headers("Authorization",authToken);
    }

    @Step("Get Attendances Location with valid token")
    public void setGetAttendancesLocationEmployee(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjh9.Tyw9fenvyLJ7FNDlonDjaMfY8-RqKCc7gzeuVf_KF2o";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step ("Get Attendances location with invalid token")
    public void setGetAttendancesLocationInvalidToken(){
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get Presences employee with valid token")
    public void setGetPresencesEmployee(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjI5fQ.xCGvu6_8qbfnJvMKeBVTkoKLWD-4d_pvymbjnWXwT-g";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get Presences employee invalid token")
    public void setGetPresencesEmployeeInvalidToken(){
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get Presences employee without token")
    public void setGetPresencesEmployeeWithoutToken(){
        String token = "";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }


    @Step("Get Employee Inbox with valid token")
    public void setGetEmployeeInbox(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjh9.Tyw9fenvyLJ7FNDlonDjaMfY8-RqKCc7gzeuVf_KF2o";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get Employee Inbox with invalid token")
    public void setGetEmployeeInboxInvalidToken (){
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Get Employee approvals with valid token")
    public void setGetEmployeeApprovals(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjh9.Tyw9fenvyLJ7FNDlonDjaMfY8-RqKCc7gzeuVf_KF2o";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step ("Get Employee approvals with invalid token")
    public void setGetEmployeeApprovalsInvalidToken (){
        String token = "invalid token";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step ("Get Employee approvals without token")
    public void setGetEmployeeApprovalsWithoutToken (){
        String token = "";
        String authToken = "Bearer " + token;
        SerenityRest.given()
                .headers("Authorization",authToken);
    }

    @Step("Put employee image and password")
    public void setPutEmployeesImagesAndPassword(String password, File image) {
        SerenityRest.given().headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjgyfQ.i6koT9RuTRix_p2948wnXNFm69BturymDo4bsHyySlQ")
                .multiPart("password", password)
                .multiPart("profile_picture",image)
                .log().all();
    }

    @Step("Put employee image invalid format")
    public void setPutEmployeesImagesInvalidFormatCsv(File Csv) {
        SerenityRest.given().headers("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJ1c2VySUQiOjgyfQ.i6koT9RuTRix_p2948wnXNFm69BturymDo4bsHyySlQ")
                .multiPart("photo",Csv)
                .log().all();
    }

}

