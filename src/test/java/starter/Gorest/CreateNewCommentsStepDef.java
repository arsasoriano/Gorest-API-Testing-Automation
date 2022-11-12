package starter.Gorest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class CreateNewCommentsStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("Create new comments with valid json")
    public void createNewCommentsWithValidJson() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/CreateNewCommentsJson.json");
        gorestAPI.postCreateComments(json);
    }
    @And("Set Authentication")
    public void setAuthentication() {
        SerenityRest.given()
                .headers("Authorization","Bearer 45fa67371d10824743c93e52db2a1531d73b64bd4a69af733c8906ffb513d3d9");
    }

    @When("send create request new comments and set authentication")
    public void sendCreateRequestNewCommentsAndSetAuthentication() {
        SerenityRest.when()
                .post(GorestAPI.POST_CREATE_COMMENTS+"?access-token=45fa67371d10824743c93e52db2a1531d73b64bd4a69af733c8906ffb513d3d9");
    }

    @Then("API should return response {int} Created")
    public void apiShouldReturnResponseCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("API should return body page post_id {int}, name {string}, email {string}, body {string}")
    public void apiShouldReturnBodyPagePost_idNameEmailBody(int post_id, String name, String email, String body) {
        SerenityRest.then()
                .body(GorestResponses.POST_ID,equalTo(post_id))
                .body(GorestResponses.NAME,equalTo(name))
                .body(GorestResponses.EMAIL,equalTo(email))
                .body(GorestResponses.BODY,equalTo(body));
    }
}
