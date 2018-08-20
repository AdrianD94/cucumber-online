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

    @FindBy(how = How.XPATH, using = "//*[@id=\"user_switcher\"]/div/ul\n")
    private WebElement dashboardPage;

    @FindBy(how = How.XPATH, using = "//*[@id=\"logout_button\"]/img")
    private WebElement logOutButton;




    public void verifyLoginScreen(){
      Assert.assertEquals(driver.getCurrentUrl(),"https://fp-pre.qustodio.com/");
   }

   public void insertValidCredentials(String email,String password ){
    System.out.println(email);
       System.out.println(password);
    WebDriverWait wait=new WebDriverWait(driver,20);
    wait.until(ExpectedConditions.visibilityOf(emailInput));
    emailInput.clear();
    emailInput.sendKeys(email);
    passwordInput.clear();
    passwordInput.sendKeys(password);

   }

   public void clickLoginButton(){
        logInButton.click();
   }

   public void DashboardRedirectCheck() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(dashboardPage));
        Assert.assertTrue(dashboardPage.isDisplayed());

   }

}