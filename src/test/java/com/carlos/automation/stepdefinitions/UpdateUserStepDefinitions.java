package com.carlos.automation.stepdefinitions;

import com.carlos.automation.exceptions.WrongInfoInBodyException;
import com.carlos.automation.exceptions.WrongResponseCodeException;
import com.carlos.automation.exceptions.WrongUserUpdatedException;
import com.carlos.automation.questions.TheUpdateWas;
import com.carlos.automation.questions.TheUpdateWasNot;
import com.carlos.automation.tasks.UpdateTheUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;

import static com.carlos.automation.exceptions.WrongInfoInBodyException.WRONG_BODY_INFO;
import static com.carlos.automation.exceptions.WrongResponseCodeException.WRONG_RESPONSE_CODE;
import static com.carlos.automation.exceptions.WrongUserUpdatedException.WRONG_USER_UPDATED;
import static com.carlos.automation.models.builder.UserBuilder.with;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;

public class UpdateUserStepDefinitions {

    public static EnvironmentVariables environmentVariables;

    @When("she updates her personal information:")
    public void sendPersonalInformation(List<Map<String, String>> data) {
        Map<String, String> userData = data.get(0);
        theActorInTheSpotlight().attemptsTo(UpdateTheUser.info(
                with()
                        .theId(userData.get("id"))
                        .theFirstName(userData.get("firstName"))
                        .theLastName(userData.get("lastName"))
                        .build()));
    }

    @Then("she should see that information was updated successfully")
    public void shouldSeeRegisterSuccessful() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful",
                        response -> response.statusCode(SC_OK)
                                .contentType("application/json"))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),

                seeThat("The user info was updated successfully",
                        TheUpdateWas.successful())
                        .orComplainWith(WrongUserUpdatedException.class, WRONG_USER_UPDATED)
        );
    }

    @When("she tries to update the info of the user:")
    public void tryUpdateInfoUserNotExist(List<Map<String, String>> data){
        sendPersonalInformation(data);
    }

    @Then("she should see that info was not updated")
    public void shouldSeeUserDoesNotExist() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be bad request (400)",
                        response -> response.statusCode(SC_BAD_REQUEST)
                                .contentType("application/json"))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),

                seeThat("The user should not be updated because user does not exist",
                        TheUpdateWasNot.successful())
                        .orComplainWith(WrongInfoInBodyException.class, WRONG_BODY_INFO)
        );

    }
}
