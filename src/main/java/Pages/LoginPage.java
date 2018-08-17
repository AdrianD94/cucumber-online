package Pages;



import Models.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(how = How.XPATH, using = "//*[@id=\"login_form\"]/ul/li[1]/input")
    private WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login_form\"]/ul/li[2]/input")
    private WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login_button\"]/span")
    private WebElement logInButton;





    public void verifyLoginScreen(){
      Assert.assertEquals(driver.getCurrentUrl(),"https://fp-pre.qustodio.com/");
   }

   public void insertValidCredentials(LoginModel Login){
    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOf(emailInput));
    emailInput.clear();
    emailInput.sendKeys(Login.getEmail());
    passwordInput.clear();
    passwordInput.sendKeys(Login.getPassword());

   }

   public void clickLoginButton(){
        logInButton.click();
   }

   public void DashboardRedirectCheck() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://fp-pre.qustodio.com/user-activity/summary");
   }

}