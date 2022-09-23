package com.carlos.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.carlos.automation.utils.ApiConstants.BODY_NOT_VALID;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheUpdateWasNot implements Question<Boolean> {

    public static TheUpdateWasNot successful() {
        return new TheUpdateWasNot();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return BODY_NOT_VALID.equals(lastResponse().body().path("error"));
    }


}
