package starter.Gorest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;
import starter.Gorest.GorestResponses;

import java.io.File;

public class PostCreateNewUserSteps {
    @Steps
    GorestAPI gorestAPI;

    @Given("Post create new user with valid body json")
    public void postCreateNewUserValid(){
        File json = new File(GorestAPI.POST_CREATE_USERS+"/POSTCreateNewUserValidInput.json");
        gorestAPI.postCreateUsers(json);
    }
    @And("Set authentication token")
    public void setToken(){
        SerenityRest.given().headers("Authorization","Bearer 2765d45f58a9cbdd2e7002df3e796dd890102283fc74e446d85f6841826e3fcf");
    }
    @When("Send post create new user request")
    public void sendPostNewUser(){
        SerenityRest.when().post(GorestAPI.POST_CREATE_USERS);
    }

    @Then("Response body code should be {int} created")
    public void responseBodyCodeShouldBeCreated(int idSuccess) {
        SerenityRest.then().statusCode(idSuccess);
    }

    @And("Validate post create new user valid value json schema")
    public void validatePostCreateNewUserValidValueJsonSchema() {
        File json = new File(GorestAPI.JSON_SCHEMA+"/POSTNewUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Post create new user using valid body json without authentication")
    public void postCreateNewUserUsingValidBodyJsonWithoutAuthentication() {
        File json = new File(GorestAPI.POST_CREATE_USERS+"/POSTCreateNewUserValidInput.json");
        gorestAPI.postCreateUsers(json);
    }

    @Then("Response body should be {int} unauthorized")
    public void responseBodyShouldBeUnauthorized(int idUnauthorized) {
        SerenityRest.then().statusCode(idUnauthorized);
    }

    @And("Validate post create new user unauthorized error message json schema")
    public void validatePostCreateNewUserUnauthorizedErrorMessageJsonSchema() {
        File json = new File(GorestAPI.JSON_SCHEMA+"/POSTErrorUnAuthorizedNewUserJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 3
    @Given("Post create new user without input name")
    public void postCreateNewUserWithoutInputName() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/POSTCreateNewUserEmptyName.json");
        gorestAPI.postCreateUsers(json);
    }

    @Then("Response body code should be {int} Unprocessable Entity")
    public void responseBodyCodeShouldBeUnprocessableEntity(int errorUnprocessable) {
        SerenityRest.then().statusCode(errorUnprocessable);
    }

//    @And("Response body error message should be contain {string}")
//    public void responseBodyErrorMessageShouldBeContain(String nameCantBlank) {
//        SerenityRest.then().body(GorestResponses.)
//    }
    @And("Validate post create new user unprocessable json schema")
    public void validatePostCreateNewUserUnprocessableJsonSchema(){
        File json = new File(GorestAPI.JSON_SCHEMA+"/POSTErrorEmptyFieldNewUserJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 4
    @Given("Post create new user without input email")
    public void postCreateNewUserWithoutInputEmail() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/POSTCreateNewUserEmptyEmail.json");
        gorestAPI.postCreateUsers(json);
    }

    // Scenario 5
    @Given("Post create new user without input gender")
    public void postCreateNewUserWithoutInputGender() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/POSTCreateNewUserEmptyGender.json");
        gorestAPI.postCreateUsers(json);
    }

    // Scenario 6
    @Given("Post create new user without input status")
    public void postCreateNewUserWithoutInputStatus() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/POSTCreateNewUserEmptyEmail.json");
        gorestAPI.postCreateUsers(json);
    }

}
