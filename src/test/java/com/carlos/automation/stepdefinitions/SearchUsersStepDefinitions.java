package com.carlos.automation.stepdefinitions;

import com.carlos.automation.exceptions.WrongInfoInBodyException;
import com.carlos.automation.exceptions.WrongResponseCodeException;
import com.carlos.automation.questions.TheRegisteredUsers;
import com.carlos.automation.tasks.Search;
import com.carlos.automation.tasks.SearchSpecificUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.carlos.automation.exceptions.WrongInfoInBodyException.WRONG_BODY_INFO;
import static com.carlos.automation.exceptions.WrongResponseCodeException.WRONG_RESPONSE_CODE;
import static com.carlos.automation.utils.ApiConstants.BASEURL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

public class SearchUsersStepDefinitions {

    private static EnvironmentVariables environmentVariables;

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) is an (?:administrator|user) of the platform$")
    public void carlosWantsToKnowTheRegisteredUsers(String actorName) {
        theActorCalled(actorName)
                .whoCan(CallAnApi.at(environmentVariables.getProperty(BASEURL)));
    }
    @When("look for the registered users")
    public void lookForTheRegisteredUsers() {
        theActorInTheSpotlight().attemptsTo(Search.users());
    }
    @Then("^he must see a registered users list with some names as (.*), (.*) and (.*)$")
    public void heMustSeeARegisteredUsersList(String name1, String name2, String name3) {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful",
                        response -> response.statusCode(SC_OK)
                                .contentType("application/json")),
                seeThat("All registered users should be displayed",
                        TheRegisteredUsers.list(), hasItems(name1, name2, name3))
        );
    }


    @When("^look for the registered user by id (.*)")
    public void LookForRegisteredUserByID(String id) {
        theActorInTheSpotlight().attemptsTo(SearchSpecificUser.by(id));
    }

    @Then("^he must see the first name of the user is (.*)")
    public void HeMustSeeTheFirstNameIs(String firstName) {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful",
                        response -> response.statusCode(SC_OK)
                                .contentType("application/json")
                                .body("firstName", equalTo(firstName)))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),

                seeThatResponse("The fetched info is right",
                        response -> response
                                .body("firstName", equalTo(firstName)))
                        .orComplainWith(WrongInfoInBodyException.class, WRONG_BODY_INFO)
        );
    }

}