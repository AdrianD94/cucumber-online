package stepDefinitions;

import Framework.TestRunner;
import Models.LoginModel;
import Pages.LoginPage;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StepsDefinition extends TestRunner {
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




    @Given("^Users is on family portal$")
    public void usersIsOnFamilyPortal() throws Throwable {

        loginPage.verifyLoginScreen();
    }




    @And("^Click on Login button$")
    public void clickOnLoginButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.clickLoginButton();
    }


    @Then("^users is redirected to the family portal dashboard$")
    public void usersIsRedirectedToTheFamilyPortalDashboard() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.DashboardRedirectCheck();
    }


    @When("^User insert \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userInsertAnd(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertValidCredentials(email,password);
    }
}
