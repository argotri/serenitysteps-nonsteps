package web.id.gosoft.automation.coba.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import web.id.gosoft.automation.coba.pages.DictionaryPage;
import web.id.gosoft.automation.coba.steps.serenity.EndUserSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class DefinitionSteps {

    @Steps
    EndUserSteps anna;

    DictionaryPage dictionaryPage;

    @Given("^the user is on the Wikionary home page$")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        anna.is_the_home_page();
    }

    @When("^the user looks up the definition of the word '(.*)'$")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        anna.looks_for(word);
    }

    @Then("^they should see the definition '(.*)'$")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        anna.should_see_definition(definition);
    }

    @Given("^the user is on the Wikionary home page without step$")
    public void givenTheUserIsOnTheWikionaryHomePageNoStep() {
        dictionaryPage.open();
    }

    @When("^the user looks up the definition of the word '(.*)' without step$")
    public void whenTheUserLooksUpTheDefinitionOfNostep(String word) {
        dictionaryPage.enter_keywords(word);
        dictionaryPage.lookup_terms();
    }

    @Then("^they should see the definition '(.*)' without step$")
    public void thenTheyShouldSeeADefinitionContainingTheWordsNoStep(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }

}
