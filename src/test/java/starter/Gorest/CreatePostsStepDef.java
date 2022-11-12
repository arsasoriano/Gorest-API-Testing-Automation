package starter.Gorest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;

public class CreatePostsStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("post create posts with valid body json")
    public void postCreatePostsWithValidBodyJson(){
        File json = new File(GorestAPI.JSON_REQ_BODY+"/CreatePostsValidBodyJson.json");
        gorestAPI.postCreatePosts(json);
    }

    @And("set the authentication")
    public void setTheAuthentication() {
        SerenityRest.given()
                .headers("Authorization","Bearer 45fa67371d10824743c93e52db2a1531d73b64bd4a69af733c8906ffb513d3d9");
    }

    @When("send post create posts request with authentication")
    public void sendPostCreatePostsRequest() {
        SerenityRest.when()
                .post(GorestAPI.POST_CREATE_POSTS+"?access-token=45fa67371d10824743c93e52db2a1531d73b64bd4a69af733c8906ffb513d3d9");
    }

    @Then("response code should be {int} created")
    public void responseCodeShouldBeCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("response body should contain user_id {int}, title {string} and body {string}")
    public void responseBodyShouldContainUser_idTitleAndBody(int userID, String title, String body) {
        SerenityRest.then()
                .body(GorestResponses.USER_ID,equalTo(userID))
                .body(GorestResponses.TITLE,equalTo(title))
                .body(GorestResponses.BODY,equalTo(body));
    }

    @Then("response code should be {int} Unauthorized")
    public void responseCodeShouldBeUnauthorized(int unauthorized) {
        SerenityRest.then().statusCode(unauthorized);
    }

    @Given("post create posts with invalid user_id")
    public void postCreatePostsWithInvalidUser_id() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/CreatePostsInvalidUserID.json");
        gorestAPI.postCreatePosts(json);
    }

    @Then("response code should be {int} Unprocessable Entity")
    public void responseCodeShouldBeUnprocessableEntity(int unprocessableEntity) {
        SerenityRest.then().statusCode(unprocessableEntity);
    }

    @Given("post create posts with invalid title")
    public void postCreatePostsWithInvalidTitle() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/CreatePostsInvalidTitle.json");
        gorestAPI.postCreatePosts(json);
    }

    @Given("post create posts with invalid body")
    public void postCreatePostsWithInvalidBody() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/CreatePostsInvalidBody.json");
        gorestAPI.postCreatePosts(json);
    }

    @Given("post create posts with invalid body json")
    public void postCreatePostsWithInvalidBodyJson() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/CreatePostsInvalidBodyJson.json");
        gorestAPI.postCreatePosts(json);
    }

    @When("send post create posts request without authentication")
    public void sendPostCreatePostsRequestWithoutAuthentication() {
        SerenityRest.when().post(GorestAPI.POST_CREATE_POSTS);
    }
}
