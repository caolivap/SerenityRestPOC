package com.carlos.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static com.carlos.automation.endpoints.Users.USERS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Search implements Task {

    @Step("{0} fetches a list of the registered users")
    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Get.resource(USERS).with(request -> request
                            .header("app-id", "632a863935bdd3b8cff4d5df"))
            );
    }

    public static Performable users() {
        return instrumented(Search.class);
    }

}
