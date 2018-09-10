package stepDefinitions.LoginSteps;

import Framework.TestRunner;
import Models.LoginModel;
import Pages.LoginPage.LoginPage;
import Pages.LoginPage.RegisterPage;
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

public class ValidRegisterSteps extends TestRunner {
    RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);

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



    @Given("^user is on register page$")
    public void userIsOnRegisterPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        registerPage.CheckIfUserIsOnRegisterPage();
    }

    @When("^user inserts  email \"([^\"]*)\" and  password \"([^\"]*)\"$")
    public void userInsertsEmailAndPassword(String email, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        registerPage.EnterCredentials(email,password);
    }

    @Then("^user is redirected to the verify email page$")
    public void userIsRedirectedToTheVerifyEmailPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
       registerPage.CheckEmailVerificationScreen();
    }


}
