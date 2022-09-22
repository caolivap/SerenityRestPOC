package com.carlos.automation.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/users/",
        glue = {"com.carlos.automation.stepdefinitions"},
        snippets = CAMELCASE
)
public class UsersRunner {
}
