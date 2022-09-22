package com.carlos.automation.stepdefinitions;

import com.carlos.automation.questions.TheRegisteredUsers;
import com.carlos.automation.tasks.LookFor;
import com.carlos.automation.tasks.SearchUser;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.carlos.automation.util.ApiConstants.BASEURL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
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
        theActorInTheSpotlight().attemptsTo(LookFor.users());
    }
    @Then("he must see a registered users list")
    public void heMustSeeARegisteredUsersList() {
/*
        theActorInTheSpotlight().should(
                seeThat(TheStatus.code(), equalTo(200)),
                seeThatResponse("All the registered users should be returned",
                        response -> response.statusCode(200)
                                .body("data.firstName", hasItems("Sara", "Edita", "Adina")))
        );
*/
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful",
                        response -> response.statusCode(200)
                                .contentType("application/json")),
                seeThat("All the registered users should be returned",
                        TheRegisteredUsers.list(), hasItems("Sara", "Edita", "Adina"))
        );
    }


    @When("^look for the registered user by id (.*)")
    public void LookForRegisteredUserByID(String id) {
        theActorInTheSpotlight().attemptsTo(SearchUser.by(id));
    }

    @Then("^he must see the first name of the user is (.*)")
    public void HeMustSeeTheFirstNameIs(String firstName) {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful",
                        response -> response.statusCode(200)
                                .contentType("application/json")
                                .body("firstName", equalTo(firstName)))
                /*
                seeThat("The first name of the user is " + firstName,
                        TheRegisteredUsers.list(), hasItems("Sara", "Edita", "Adina"))*/
        );

    }


}