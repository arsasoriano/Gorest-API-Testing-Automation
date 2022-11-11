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

public class PutUpdateCommentSteps {
    @Steps
    GorestAPI gorestAPI;

    @Given("Put update comment on body comment using valid id {int} and authenticated")
    public void putUpdateCommentOnBodyCommentUsingValidIdAndAuthenticated(int id){
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUpdateCommentValidId.json");
        gorestAPI.putUpdateComments(id, json);
    }
    @When("Send put update comment request")
    public void sendPutUpdateCommentRequest(){
        SerenityRest.when().put(GorestAPI.PUT_UPDATE_COMMENTS+"?access-token=2765d45f58a9cbdd2e7002df3e796dd890102283fc74e446d85f6841826e3fcf");
    }
    @Then("Response body code should be {int} OK")
    public void responseBoodyCodeShouldBeOk(int OK){
        SerenityRest.then().statusCode(OK);
    }

    // Scenario 2
    @Given("Put update comment on body comment using invalid id {int}")
    public void putUpdateCommentOnBodyCommentUsingInvalidId(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUpdateCommentValidId.json");
        gorestAPI.putUpdateCommentInvalidId(id, json);
    }

    // Scenario 3
    @Given("Put update comment on body comment using valid id {int}")
    public void putUpdateCommentOnBodyCommentUsingValidId(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUpdateCommentValidId.json");
        gorestAPI.putUpdateComments(id, json);
    }

    @When("Send put update comment request but not yet authenticated")
    public void sendPutUpdateCommentRequestButNotYetAuthenticated() {
        SerenityRest.when().put(GorestAPI.PUT_UPDATE_COMMENTS);
    }

    // Scenario 4
    @Given("Put update comment with id {int} empty email input on body json")
    public void putUpdateCommentWithEmptyEmailInputOnBodyJson(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUpdateCommentEmptyEmail.json");
        gorestAPI.putUpdateComments(id, json);
    }

    // Scenario 5
    @Given("Put update comment with id {int} empty name input on body json")
    public void putUpdateCommentWithIdIdEmptyNameInputOnBodyJson(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUpdateCommentEmptyName.json");
        gorestAPI.putUpdateComments(id, json);
    }

    // Scenario 6
    @Given("Put update comment with id {int} empty body comment input on body json")
    public void putUpdateCommentWithEmptyBodyCommentInputOnBodyJson(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUppdateCommentEmptyBody.json");
        gorestAPI.putUpdateComments(id, json);
    }

    // Scenario 7
    @Given("Put update comment with id {int} empty name and email")
    public void putUpdateCommentWithIdIdEmptyNameAndEmail(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUpdateCommentEmptyNameEmail.json");
        gorestAPI.putUpdateComments(id, json);
    }

    // Scenario 8
    @Given("Put update comment with id {int} empty name email and body comment")
    public void putUpdateCommentWithIdEmptyNameEmailAndBodyComment(int id) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/PUTUpdateCommentEmptyNameEmailBody.json");
        gorestAPI.putUpdateComments(id, json);
    }
}
