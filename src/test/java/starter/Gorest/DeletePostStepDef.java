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

public class DeletePostStepDef {
    @Steps
    GorestAPI gorestAPI;
    @Given("delete posts with valid id {int}")
    public void deletePostsWithValidId(int id){
        gorestAPI.deletePosts(id);
    }

    @When("send delete posts request with authentication")
    public void sendDeletePostsRequestWithAuthentication() {
        SerenityRest.when().delete(GorestAPI.DELETE_POSTS+"?access-token=45fa67371d10824743c93e52db2a1531d73b64bd4a69af733c8906ffb513d3d9");
    }

    @Then("response code should be {int} no content")
    public void responseCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }

    @Given("delete posts with invalid id {string}")
    public void deletePostsWithInvalidIdId(String id) {
        gorestAPI.deletePostsWithInvalidId(id);
    }

    @When("send delete posts request without authentication")
    public void sendDeletePostsRequestWithoutAuthentication() {
        SerenityRest.when().delete(GorestAPI.DELETE_POSTS);
    }
}
