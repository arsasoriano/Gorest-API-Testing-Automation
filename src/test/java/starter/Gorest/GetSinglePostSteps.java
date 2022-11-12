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

import static org.hamcrest.Matchers.equalTo;

public class GetSinglePostSteps {
    @Steps
    GorestAPI gorestAPI;

    @Given("Get single post with id {int}")
    public void getSinglePostWithId(int id){
        gorestAPI.getSinglePosts(id);
    }
    @When("Send request to get single post")
    public void sendRequestToGetSinglePost(){
        SerenityRest.when().get(GorestAPI.GET_SINGLE_POSTS);
    }
    @And("Response body should contain id {int} with user id {int} and title {string}")
    public void responseBodyShouldContainIdWithUserIdAndTitle(int id, int userId, String postTitle){
        SerenityRest.then().body(GorestResponses.ID, equalTo(id))
                .body(GorestResponses.USER_ID,equalTo(userId))
                .body(GorestResponses.POST_TITLE, equalTo(postTitle));
    }
    @And("Validate get single post with json schema validator")
    public void validateGetSinglePostWithJsonSchemaValidator(){
        File json = new File(GorestAPI.JSON_SCHEMA+"/GETSinglePostJsonSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    // Scenario 2
    @Given("Get single post with invalid id using alphabet {string}")
    public void getSinglePostWithInvalidIdUsingAlphabet(String id){
        gorestAPI.getSinglePostInvalidPage(id);
    }


}
