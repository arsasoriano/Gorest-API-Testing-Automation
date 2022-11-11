package starter.Gorest.StepDefs;

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

import static org.hamcrest.Matchers.equalTo;

public class GetListPostsSteps {
    @Steps
    GorestAPI gorestAPI;

    // Scenario 1
    @Given("Get list posts with valid parameter page {int}")
    public void getListPostsWithValidParameterPagePage(int page) {
        gorestAPI.getListPosts(page);}
    @When("Send get list posts request")
    public void sendGetListPostsRequest() {
        SerenityRest.when().get(GorestAPI.GET_LIST_POSTS);
    }
    @Then("Should return {int} OK")
    public void shouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }
    @And("Validate get list posts json schema")
    public void validateGetListUserJsonSchema() {
        File json = new File(GorestAPI.JSON_SCHEMA+"/GetListPostsJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Get list posts with invalid parameter page {string}")
    public void getListUserWithInvalidParameterPage(String page) {
        gorestAPI.getListPostsInvalidPage(page);
    }
    @Then("Should return {int} not found")
    public void shouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
}
