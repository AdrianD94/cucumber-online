package Pages.LoginPage;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(how = How.ID, using = "user-email")
    private WebElement emailInput;

    @FindBy(how = How.ID, using = "user-password")
    private WebElement passwordInput;

    @FindBy(how = How.ID, using = "user-password-confirm")
    private WebElement confirmPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"agreement\"]")
    private WebElement acceptTerms;


    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div/div/div/form/div[5]/div[2]")
    private WebElement submit;


    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/header/div/div[2]/div/div[2]/a")
    private WebElement signUpButton;



    public void CheckIfUserIsOnRegisterPage(){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        signUpButton.click();
        wait.until(ExpectedConditions.urlContains("https://online.io/dashboard/sign-up"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://online.io/dashboard/sign-up");
    }

    public void EnterCredentials(String email,String password) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPassword.sendKeys(password);
        acceptTerms.click();
        Assert.assertTrue(submit.isEnabled());
        submit.click();
    }

    public void CheckEmailVerificationScreen(){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlContains("https://online.io/dashboard/confirm-email"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://online.io/dashboard/confirm-email");
    }
}