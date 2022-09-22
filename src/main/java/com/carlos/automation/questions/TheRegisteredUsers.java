package com.carlos.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class TheRegisteredUsers implements Question<List<String>> {

    public static TheRegisteredUsers list() {
        return new TheRegisteredUsers();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return lastResponse().body().path("data.firstName");
    }

}


