package com.carlos.automation.questions;

import com.carlos.automation.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheUpdateWas implements Question<Boolean> {

    public static TheUpdateWas successful() {
        return new TheUpdateWas();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        User userFromResponse = actor.recall("theUserUpdated");
        return lastResponse().statusCode() == 200
                && lastResponse().body().path("firstName").equals(userFromResponse.getFirstName())
                && lastResponse().body().path("lastName").equals(userFromResponse.getLastName());
    }
}
