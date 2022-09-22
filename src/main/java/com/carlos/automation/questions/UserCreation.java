package com.carlos.automation.questions;

import com.carlos.automation.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;

public class UserCreation implements Question<Boolean> {

    public static UserCreation wasSuccessful() {
        return new UserCreation();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        User user = theActorInTheSpotlight().recall("user");
        User returnedUser = lastResponse().as(User.class);

        user.getId().equals(returnedUser.getId());
/*        .body("id", not(isEmptyOrNullString()))
                .body("title", equalTo(user.getTitle()))
                .body("firstName", equalTo(user.getFirstName()))
                .body("lastName", equalTo(user.getLastName()))
                .body("email", equalTo(user.getEmail()))),*/
        return null;
    }
}
