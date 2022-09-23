package com.carlos.automation.stepdefinitions;

import com.carlos.automation.exceptions.WrongInfoInBodyException;
import com.carlos.automation.exceptions.WrongResponseCodeException;
import com.carlos.automation.tasks.SearchUsers;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.carlos.automation.exceptions.WrongInfoInBodyException.WRONG_BODY_INFO;
import static com.carlos.automation.exceptions.WrongResponseCodeException.WRONG_RESPONSE_CODE;
import static com.carlos.automation.utils.ApiConstants.APP_ID_MISSING;
import static com.carlos.automation.utils.ApiConstants.APP_ID_NOT_EXIST;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_FORBIDDEN;
import static org.hamcrest.CoreMatchers.equalTo;

public class ErrorsManagementStepDefinitions {

    @When("he tries look for registered users without having an app-id")
    public void lookForUsersWithoutSendingAppId() {
        theActorInTheSpotlight().attemptsTo(SearchUsers.withoutAppId());
    }
    @Then("he must see the error message missing app-id")
    public void heMustSeeMissingAppIdError() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be forbidden (403)",
                        response -> response.statusCode(SC_FORBIDDEN)
                                .contentType("application/json"))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),
                seeThatResponse("There is an error because missing app-id",
                        response -> response.body("error", equalTo(APP_ID_MISSING)))
                        .orComplainWith(WrongInfoInBodyException.class, WRONG_BODY_INFO)
        );
    }

    @When("^he tries look for registered users with app-id (.*)$")
    public void lookForUsersWithIncorrectAppId(String appId) {
        theActorInTheSpotlight().attemptsTo(SearchUsers.withAppId(appId));
    }

    @Then("he must see the error message app-id not exist")
    public void heMustSeeAppIdNotExistError() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be forbidden (403)",
                        response -> response.statusCode(SC_FORBIDDEN)
                                .contentType("application/json")),
                seeThatResponse("There is an error because app-id not exist",
                        response -> response.body("error", equalTo(APP_ID_NOT_EXIST)))
                        .orComplainWith(WrongInfoInBodyException.class, WRONG_BODY_INFO)
        );
    }

}
