package starter.Gorest.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Gorest.GorestAPI;

public class DeleteTodoSteps {
    @Steps
    GorestAPI gorestAPI;

    @Given("Delete todo using valid id {int}")
    public void deleteTodoUsingValidId(int id){
        gorestAPI.deleteTodos(id);
    }
    @When("Send delete todo request")
    public void sendDeleteTodoRequest(){
        SerenityRest.when().delete(GorestAPI.DELETE_TODOS+"?access-token=2765d45f58a9cbdd2e7002df3e796dd890102283fc74e446d85f6841826e3fcf");
    }
    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent){
        SerenityRest.then().statusCode(noContent);
    }

    // Scenario 2
    @Given("Delete todo using invalid id {int}")
    public void deleteTodoUsingInvalidIdId(int id) {
        gorestAPI.deletePostsWithInvalidIdInt(id);
    }


    @When("Send delete todo request without token")
    public void sendDeleteTodoRequestWithoutToken() {
        SerenityRest.when().delete(GorestAPI.DELETE_TODOS);
    }
}
