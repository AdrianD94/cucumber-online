package stepDefinitions;

import Framework.TestRunner;
import Models.LoginModel;
import Pages.LoginPage;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InValidLoginSteps extends TestRunner {
    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

    @DataProvider(name = "LoginJson")
    public Iterator<Object[]> jsonLoginDataProvider() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Collection<Object[]> dp = new ArrayList<>();

        File[] files = getListOfFiles("DataJsons");
        for (File f : files) {
            LoginModel m = objectMapper.readValue(f, LoginModel.class);
            dp.add(new Object[]{m});
        }
        return dp.iterator();
    }


    @Given("^user is on online login page$")
    public void userIsOnOnlineLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.CheckIfUserIsOnLoginPage();
    }

    @When("^user inserts invalid \"([^\"]*)\" or  invalid  password \"([^\"]*)\"$")
    public void userInsertsInvalidOrInvalidPassword(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.EnterInvalidCredentials(email,password);
    }

    @Then("^Error Message is displayed$")
    public void errorMessageIsDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.ErrorDisplayed();
    }



}
