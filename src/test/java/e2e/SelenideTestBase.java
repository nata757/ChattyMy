package e2e;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.Config;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTestBase {
    private final String URL = new Config().getProjectUrl();
    private final String BROWSER = new Config().getBrowser();
    @BeforeMethod
    public void setUp(){
        Configuration.browser = BROWSER;
        Configuration.browserSize = "1920x1080";
        open(URL);
    }
    @AfterMethod
    public void tearDown(){
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}