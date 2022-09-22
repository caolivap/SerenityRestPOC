package com.carlos.automation.stepdefinitions;

import com.carlos.automation.models.User;
import com.carlos.automation.questions.UserCreation;
import com.carlos.automation.tasks.Create;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class CreateUserStepDefinitions {

    public static EnvironmentVariables environmentVariables;

    @When("she sends her personal information:")
    public void sendPersonalInformation(List<Map<String, String>> data) {
        Map<String, String> userData = data.get(0);
        User user = new User(userData.get("title"), userData.get("firstName"), userData.get("lastName"),
                userData.get("email"));
        theActorInTheSpotlight().attemptsTo(Create.aNewUser(user));
    }

    @Then("she should see register was successful")
    public void shouldSeeRegisterSuccessful() {
        User user = theActorInTheSpotlight().recall("user");
        theActorInTheSpotlight().should(
                seeThatResponse("The response code should be successful",
                        response -> response.statusCode(200)
                                .contentType("application/json")),
                 seeThat(UserCreation.wasSuccessful())
        );
    }


}
