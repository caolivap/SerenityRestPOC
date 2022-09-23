package com.carlos.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.carlos.automation.utils.ApiConstants.BODY_NOT_VALID;
import static com.carlos.automation.utils.ApiConstants.EMAIL_ALREADY_USED;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheCreationWasNot implements Question<Boolean> {


    public static TheCreationWasNot successful() {
        return new TheCreationWasNot();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
            return lastResponse().statusCode() == 400
                    && lastResponse().body().path("error").equals(BODY_NOT_VALID)
                    && lastResponse().body().path("data.email").equals(EMAIL_ALREADY_USED);
    }
}
