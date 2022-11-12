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

public class UpdatePostsStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("put update posts with valid body json and valid id {int}")
    public void putUpdatePostsWithValidBodyJsonAndValidId(int id){
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PutUpdatePostValidBodyJson.json");
        gorestAPI.putUpdatePosts(id,json);
    }

    @When("send put update posts request with authentication")
    public void sendPutUpdatePostsRequestWithAuthentication() {
        SerenityRest.when()
                .put(GorestAPI.PUT_UPDATE_POSTS+"?access-token=45fa67371d10824743c93e52db2a1531d73b64bd4a69af733c8906ffb513d3d9");
    }

    @Then("response code should be {int} ok")
    public void responseCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("response body should contain title {string} and body {string}")
    public void responseBodyShouldContainTitleAndBody(String title, String body) {
        SerenityRest.then()
                .body(GorestResponses.TITLE,equalTo(title))
                .body(GorestResponses.BODY,equalTo(body));
    }

    @Given("put update posts with valid body json and invalid id {string}")
    public void putUpdatePostsWithValidBodyJsonAndInvalidIdId(String id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PutUpdatePostValidBodyJson.json");
        gorestAPI.putUpdatePostsWithInvalidId(id,json);
    }

    @Then("response code should be {int} not found")
    public void responseCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @When("send put update posts request without authentication")
    public void sendPutUpdatePostsRequestWithoutAuthentication() {
        SerenityRest.when().put(GorestAPI.PUT_UPDATE_POSTS);
    }

    @Given("put update posts with invalid title and valid id {int}")
    public void putUpdatePostsWithInvalidTitleAndValidIdId(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PutUpdatePostInvalidTitle.json");
        gorestAPI.putUpdatePosts(id,json);
    }

    @Given("put update posts with invalid body and valid id {int}")
    public void putUpdatePostsWithInvalidBodyAndValidIdId(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PutUpdatePostInvalidBody.json");
        gorestAPI.putUpdatePosts(id,json);
    }

    @Given("put update posts with invalid body json and valid {int}")
    public void putUpdatePostsWithInvalidBodyJsonAndValidId(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PutUpdatePostInvalidBodyJson.json");
        gorestAPI.putUpdatePosts(id,json);
    }
}
