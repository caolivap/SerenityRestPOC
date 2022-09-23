package com.carlos.automation.questions;

import com.carlos.automation.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.not;

public class TheCreationWas implements Question<Boolean> {

    public static TheCreationWas successful() {
        return new TheCreationWas();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        User user = theActorInTheSpotlight().recall("user");
        if (lastResponse().statusCode() == HttpStatus.SC_OK) {
            User returnedUser = lastResponse().as(User.class);
            return returnedUser.getId() != null
                    && user.equals(returnedUser);
        } else {
            return false;
        }
    }
}
