package com.carlos.automation.tasks;

import com.carlos.automation.models.User;
import com.google.gson.Gson;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static com.carlos.automation.endpoints.Users.USERS;

public class Create implements Task {

    private User user;

    public Create(User user) {
        this.user = user;
    }

    public static Create aNewUser(User user) {
        return new Create(user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(USERS + "/create").with(
                        request -> request.header("Content-Type", "application/json")
                                .header("app-id", "632a863935bdd3b8cff4d5df")
                                .body(user)
                )
        );
        actor.remember("user", user);
    }
}
