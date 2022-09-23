package com.carlos.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.List;

import static com.carlos.automation.endpoints.Users.USERS;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.apache.http.HttpStatus.SC_OK;

public class DeleteAn implements Task {

    private String idForRemoving;

    public DeleteAn(String idForRemoving) {
        this.idForRemoving = idForRemoving;
    }

    public static DeleteAn userById(String idForRemoving) {
        return new DeleteAn(idForRemoving);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(USERS + "/" + idForRemoving).with(
                        request -> request.header("app-id", "632a863935bdd3b8cff4d5df")
                )
        );
    }

}
