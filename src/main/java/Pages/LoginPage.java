package Pages;



import Models.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(how = How.ID, using = "user-login-email")
    private WebElement emailInput;

    @FindBy(how = How.ID, using = "user-login-password")
    private WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div/div/form/div[3]/button")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div/div/form/div[4]/p")
    private WebElement loginError;



    public void CheckIfUserIsOnLoginPage(){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlContains("https://online.io/dashboard/sign-in"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://online.io/dashboard/sign-in");
    }

    public void EnterCredentials(String email,String password){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);

        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginButton.click();

    }

    public void CheckDashboardRedirect(){
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.urlContains("https://online.io/dashboard/wallets"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://online.io/dashboard/wallets");
    }


    public void EnterInvalidCredentials(String email,String password){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void ErrorDisplayed(){
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(loginError));
        Assert.assertEquals(loginError.getText(),"Wrong email or password");
    }

}