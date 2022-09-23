package com.carlos.automation.tasks;

import com.carlos.automation.models.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.carlos.automation.endpoints.Users.USERS;

public class UpdateTheUser implements Task {

    private User user;

    public UpdateTheUser(User user) {
        this.user = user;
    }

    public static UpdateTheUser info(User user) {
        return new UpdateTheUser(user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.remember("theUserUpdated", user);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.toJsonTree(user).getAsJsonObject();
        jsonObject.remove("id");
        jsonObject.remove("title");
        jsonObject.remove("email");
        String json = jsonObject.toString();
        actor.attemptsTo(
                Put.to(USERS + "/" + user.getId()).with(
                        request -> request.header("Content-Type", "application/json")
                                .header("app-id", "632a863935bdd3b8cff4d5df")
                                .body(json)
                )
        );
    }

}
