package com.carlos.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.carlos.automation.utils.ApiConstants.RESOURCE_NOT_FOUND;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheRemovalWasNot implements Question<Boolean> {

    public static TheRemovalWasNot successful() {
        return new TheRemovalWasNot();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return RESOURCE_NOT_FOUND.equals(lastResponse().body().path("error"));
    }
}
