package com.carlos.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static com.carlos.automation.endpoints.Users.USERS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchSpecificUser implements Task {

    private final String userId;

    public SearchSpecificUser(String userId) {
        this.userId = userId;
    }

    @Step("{0} fetches a specific registered user by id")
    @Override
    public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Get.resource(USERS + "/{userId}").with(request -> request
                            .pathParam("userId", userId)
                            .header("app-id", "632a863935bdd3b8cff4d5df"))
            );
    }

    public static Performable by(String userId) {
        return instrumented(SearchSpecificUser.class, userId);
    }
}
