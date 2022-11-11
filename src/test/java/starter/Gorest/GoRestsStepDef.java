package starter.Gorest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.jruby.ext.ripper.Warnings;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GoRestsStepDef {

    @Steps
    GorestAPI gorestAPI;

//skenario 1

    @Given("Set path paramater page")
    public void setPathParameterPage() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/GetListToDos.json");
        gorestAPI.getListTodos(json);
    }
    @And("Click send button")
    public void clickSendButton() {
        SerenityRest.when().get(GorestAPI.GET_LIST_TODOS);
    }

    @Then("API should return response {int} OK")
    public void apiShouldReturnResponseOK(int OK) {
        SerenityRest.then().statusCode(OK);}

    //skenario 2

    @When("Set path to invalid parameter")
    public void setPathToInvalidParameter() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/GetListToDosInvalidParam.json");
        gorestAPI.setGetListTodosInvalid(json);
    }
    @And("Click send button invalid")
    public void clickSendButtonInvalid() {
        SerenityRest.when().get(GorestAPI.GET_LIST_TODOS_INVALID);
    }
    @Then("API should return response {int} Not Found")
    public void apiShouldReturnResponseNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);}


//skenario 3
@Given("Set path to param id {int}")
public void setPathToParamId(int id) {
    File json = new File(GorestAPI.JSON_REQ_BODY + "/GetListToDos.json");
   gorestAPI.getListTodosParam(id, json);
}

    @And("Click send button for id")
    public void clickSendButtonForId() {
        SerenityRest.when().get(GorestAPI.GET_LIST_TODOS_PARAM_ID);
    }
//skenario 4
    @When("Set path to param ID {int}")
    public void setPathToParamID(int ID) {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/GetListToDos.json");
        gorestAPI.getListTodosParamKapital(ID, json);
    }

    @And("Click send button for ID")
    public void clickSendButtonForID() {
        SerenityRest.when().get(GorestAPI.GET_LIST_TODOS_PARAM_ID_KAPITAL);
    }
//skenario 5
    @And("Click send button for ID +key&go")
    public void clickSendButtonForIDKeyGo() {
        SerenityRest.when().get(GorestAPI.GET_LIST_TODOS_PARAM_ID_KEY_GO);
    }
//skenario 6
    @And("Click send button for ID +KEY&GO")
    public void clickSendButtonForIDKEYGO() {
        SerenityRest.when().get(GorestAPI.GET_LIST_TODOS_PARAM_ID_KEY_GO_KAPITAL);
    }
//skenario 7
    @When("Set path without token")
    public void setPathWithoutToken() {
        File json = new File(GorestAPI.JSON_REQ_BODY+"/404Unauthorization.json");
        gorestAPI.postCreateTodos(json);
    }

    @And("Click send button without token")
    public void clickSendButtonWithoutToken() {
        SerenityRest.when().get(GorestAPI.POST_CREATE_TODOS);
    }

    @Then("API should return response {int} Unauthorized")
    public void apiShouldReturnResponseUnauthorized(int OK) {
        SerenityRest.then().statusCode(OK);
    }
//skenario 8
    @When("Set path with token")
    public void setPathWithToken() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
    }

    @And("Click send button with token")
    public void clickSendButtonWithToken() {
        SerenityRest.when().get(GorestAPI.POST_CREATE_TODOS);
    }
    //skenario 9
    @When("Set path to id in body field as integer")
    public void setPathToIdInBodyFieldAsInteger() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        File json = new File(GorestAPI.JSON_REQ_BODY+"/UpdateUserInteger.json");
        gorestAPI.postCreateTodos(json);
    }

    @Then("API should return response {int} Created")
    public void apiShouldReturnResponseCreated(int Created) {
        SerenityRest.then().statusCode(Created);
    }
//skenario 10
    @When("Set path to id in body field as string")
    public void setPathToIdInBodyFieldAsString() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        File json = new File(GorestAPI.JSON_REQ_BODY+"/UpdateUserString.json");
        gorestAPI.postCreateTodos(json);
    }
//skenario 11
    @When("Set path to ID in body")
    public void setPathToIDInBody() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        File json = new File(GorestAPI.JSON_REQ_BODY+"/IDinBody.json");
        gorestAPI.postCreateTodos(json);
    }

    @Then("API should return response {int} Unprocessable Entity")
    public void apiShouldReturnResponseUnprocessableEntity(int UnprocessableEntity) {
        SerenityRest.then().statusCode(UnprocessableEntity);
    }
//skenario 12
    @When("Set path to USER_ID in body")
    public void setPathToUSER_IDInBody() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        File json = new File(GorestAPI.JSON_REQ_BODY+"/USER_IDinBody.json");
        gorestAPI.postCreateTodos(json);
    }
//skenario 13
    @When("Set path to user_id in body as string")
    public void setPathToUser_idInBodyAsString() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        File json = new File(GorestAPI.JSON_REQ_BODY+"/user_idAsString.json");
        gorestAPI.postCreateTodos(json);
    }
//skenario 14
    @When("Set path to user_id in body as special character")
    public void setPathToUser_idInBodyAsSpecialCharacter() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        File json = new File(GorestAPI.JSON_REQ_BODY+"/user_idSpecialCharacter.json");
        gorestAPI.postCreateTodos(json);
    }
//sekenario 15
    @When("Set path for put without token")
    public void setPathForPutWithoutToken() {
        SerenityRest.when().get(GorestAPI.PUT_UPDATE_TODOS);
    }
//skenario 16
    @When("Set path for put with token")
    public void setPathForPutWithToken() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        SerenityRest.when().get(GorestAPI.PUT_UPDATE_TODOS);
    }
//skenario 17
    @When("Set path for patch without token")
    public void setPathForPatchWithoutToken() {
        SerenityRest.when().get(GorestAPI.PATCH_TODOS);
    }
//skenario 18
    @When("Set path for patch with token")
    public void setPathForPatchWithToken() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        SerenityRest.when().get(GorestAPI.PATCH_TODOS);
    }

//skenario 19
    @When("Set path for delete without token")
    public void setPathForDeleteWithoutToken() {
        SerenityRest.when().get(GorestAPI.DELETE_TODOS);
    }
//skenario 20
    @When("Set path for delete with token")
    public void setPathForDeleteWithToken() {
        SerenityRest.given().headers("Authorization","Bearer c3cc91ee7c6da50f98cb8ac378f9eb1dc52ef24c66bfb81c3b852a66fb1042dd");
        SerenityRest.when().get(GorestAPI.DELETE_TODOS);
    }

    @And("Click send button post")
    public void clickSendButtonPost() {
    }
}



