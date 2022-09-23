package com.carlos.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

import static com.carlos.automation.endpoints.Users.USERS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchUsers implements Task {

    private final String appId;

    public SearchUsers(String appId) {
        this.appId = appId;
    }

    public static Performable withoutAppId() {
        return instrumented(SearchUsers.class, "");
    }

    public static Performable withAppId(String appId) {
        return instrumented(SearchUsers.class, appId);
    }

    @Step("{0} tries fetch users without having app-id")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (!appId.equals("")) {
            actor.attemptsTo(
                    Get.resource(USERS).with(request -> request
                            .header("app-id", appId))
            );
        } else {
            actor.attemptsTo(
                    Get.resource(USERS)
            );
        }
    }

}
