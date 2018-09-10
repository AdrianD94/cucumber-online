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

public class LoginSteps extends TestRunner {
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



    @Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.CheckIfUserIsOnLoginPage();
    }

    @When("^user inserts confirmed email \"([^\"]*)\" and valid  password \"([^\"]*)\"$")
    public void user_inserts_confirmed_email_and_valid_password(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.EnterCredentials(email,password);
    }

    @Then("^user is redirected to the dashboard$")
    public void user_is_redirected_to_the_dashboard() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.CheckDashboardRedirect();
    }
}
