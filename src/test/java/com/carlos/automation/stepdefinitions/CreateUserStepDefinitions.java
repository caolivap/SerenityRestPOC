package com.carlos.automation.stepdefinitions;

import com.carlos.automation.exceptions.WrongInfoInBodyException;
import com.carlos.automation.exceptions.WrongResponseCodeException;
import com.carlos.automation.exceptions.WrongUserCreatedException;
import com.carlos.automation.models.User;
import com.carlos.automation.questions.TheCreationWasNot;
import com.carlos.automation.questions.TheCreationWas;
import com.carlos.automation.tasks.Create;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;

import static com.carlos.automation.exceptions.WrongInfoInBodyException.WRONG_BODY_INFO;
import static com.carlos.automation.exceptions.WrongResponseCodeException.WRONG_RESPONSE_CODE;
import static com.carlos.automation.exceptions.WrongUserCreatedException.WRONG_USER_CREATED;
import static com.carlos.automation.models.builder.UserBuilder.with;
import static com.carlos.automation.utils.EmailManagement.generateValidEmail;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;

public class CreateUserStepDefinitions {

    public static EnvironmentVariables environmentVariables;

    @When("she sends her personal information:")
    public void sendPersonalInformation(List<Map<String, String>> data) {
        Map<String, String> userData = data.get(0);
        String userEmail = generateValidEmail(userData.get("email"));
        theActorInTheSpotlight().attemptsTo(
                Create.aNewUser(with()
                        .theTitle(userData.get("title"))
                        .theFirstName(userData.get("firstName"))
                        .theLastName(userData.get("lastName"))
                        .andEmail(userEmail).build()));
    }

    @Then("she should see register was successful")
    public void shouldSeeRegisterSuccessful() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful (200)",
                        response -> response.statusCode(SC_OK)
                                .contentType("application/json"))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),

                seeThat("The creation of the new user was successful",
                        TheCreationWas.successful(), is(true))
                        .orComplainWith(WrongUserCreatedException.class, WRONG_USER_CREATED)
        );
    }

    @When("she wants to register to the already existent user:")
    public void sendExistentUserInfo(List<Map<String, String>> data) {
        sendPersonalInformation(data);
    }

    @Then("she should see that user already exists")
    public void shouldSeeUserAlreadyExists() {
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be 400",
                        response -> response.statusCode(SC_BAD_REQUEST)
                                .contentType("application/json"))
                        .orComplainWith(WrongResponseCodeException.class, WRONG_RESPONSE_CODE),

                seeThat("The creation of the new user should not be successful",
                        TheCreationWasNot.successful(), is(true))
                        .orComplainWith(WrongInfoInBodyException.class, WRONG_BODY_INFO)
        );
    }

}
