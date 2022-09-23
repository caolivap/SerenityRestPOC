package com.carlos.automation.stepdefinitions;

import com.carlos.automation.exceptions.WrongInfoInBodyException;
import com.carlos.automation.exceptions.WrongResponseCodeException;
import com.carlos.automation.questions.TheRemovalWas;
import com.carlos.automation.questions.TheRemovalWasNot;
import com.carlos.automation.tasks.DeleteAn;
import com.carlos.automation.tasks.Search;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;

import static com.carlos.automation.exceptions.WrongInfoInBodyException.WRONG_BODY_INFO;
import static com.carlos.automation.exceptions.WrongResponseCodeException.WRONG_RESPONSE_CODE;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;

public class DeleteUserStepDefinitions {

    public static EnvironmentVariables environmentVariables;

    @When("he deletes an user by id")
    public void deleteUserById() {
        String idForRemoving = getIdForRemoving();
        theActorInTheSpotlight().attemptsTo(
                DeleteAn.userById(idForRemoving)
        );
    }

    @Then("he should see that user was deleted successfully")
    public void shouldSeeUserDeletedSuccessfully() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful",
                        response -> response.statusCode(SC_OK)
                                .contentType("application/json"))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),

                seeThat("The user was deleted successfully",
                        TheRemovalWas.successful())
                        .orComplainWith(WrongInfoInBodyException.class, WRONG_BODY_INFO)
        );
    }

    @When("^he deletes an user with id (.*)$")
    public void deleteExistentUserById(String id) {
        theActorInTheSpotlight().attemptsTo(DeleteAn.userById(id));
    }

    @Then("he should see that user does not exist")
    public void shouldSeeCanNotDeleteUser() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be resource not found",
                        response -> response.statusCode(SC_NOT_FOUND)
                                .contentType("application/json"))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),

                seeThat("The user should not be deleted because user does not exist",
                        TheRemovalWasNot.successful())
                        .orComplainWith(WrongInfoInBodyException.class, WRONG_BODY_INFO)
        );
    }

    private String getIdForRemoving() {
        theActorInTheSpotlight().attemptsTo(
                Search.users()
        );
        if (lastResponse().statusCode() == SC_OK) {
            List<String> idList = lastResponse().body().path("data.id");
            theActorInTheSpotlight().remember("idForRemoving", idList.get(0));
            return idList.get(0);
        } else {
            throw new RuntimeException("User ids list can not be fetched");
        }
    }
}
