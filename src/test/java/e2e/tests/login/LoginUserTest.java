package e2e.tests.login;

import com.github.javafaker.Faker;
import e2e.TestBase;
import e2e.pages.login.LoginPage;
import e2e.utils.DataProviders;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginUserTest extends TestBase {

    Faker faker = new Faker();
    LoginPage loginPage;

    @Feature(value = "User has been logged in")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-3")
    public void userCanLogin() {
        String email = faker.internet().emailAddress();
        String password = "Manowar333246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
    }
    @Feature(value = "User is not logged in")
    @Description(value = "User can't login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-5")
    public void userCanNotLoginWithInvalidEmail() {
        String email = "tatara@abv.bg";
        String password = "Manowar33246";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);

    }
    @Feature(value = "User is not logged in")
    @Description(value = "User can't login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-6")
    public void userCanNotLoginWithInvalidPassword() {
        String email = "tatar@abv.bg";
        String password = "Mannn32";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        assertTrue("User not found. Please register.", loginPage.textError());
    }
    @Feature(value = "User is not logged in")
    @Description(value = "User can't login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-20")
    public void userCanNotLoginWithoutAEmailAndPassword() {
        String email = "";
        String password = "";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        loginPage.takeLoginPageScreenshot("userCanNotLoginWithInvalidEmail");
    }
    @Feature(value = "adminPanel is not logged in")
    @Description(value = "adminPanel can't login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "CHATTY-47")
    public void userCanNotLoginWithoutInvalidEmailAndPassword() {
        String email = "tatar@abvbg";
        String password = "Manowar332466";

        loginPage = new LoginPage(app.driver);
        loginPage.login(email, password);
        assertTrue("User not found. Please register.", loginPage.textError());
    }
    @Feature(value = "User is not logged in")
    @Description(value = "User can login")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "All negative Test",dataProvider = "userCanNotLoginTest", dataProviderClass = DataProviders.class)
    public void userCannotLoginWithInvalidData(String email, String password, String caseName) {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);


        loginPage.waitForLoading();
        loginPage.takeLoginPageScreenshot(caseName + "_negative_login_case");
        loginPage.waitForLoading();

    }
}
