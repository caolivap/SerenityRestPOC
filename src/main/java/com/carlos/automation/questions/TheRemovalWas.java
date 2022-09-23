package com.carlos.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheRemovalWas implements Question<Boolean> {

    public static TheRemovalWas successful() {
        return new TheRemovalWas();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return actor.recall("idForRemoving").equals(lastResponse().body().path("id"));
    }
}
