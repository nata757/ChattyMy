package e2e.tests.post;

import e2e.TestBase;
import e2e.pages.Header;
import e2e.pages.homeBlog.HomeBlogPage;
import e2e.pages.login.LoginPage;
import e2e.pages.post.EditPostPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class UserCanDeletePostTest extends TestBase {

    LoginPage loginPage;
    HomeBlogPage homeBlogPage;
    Header header;
    EditPostPage editPostPage;

    @Epic(value = "User can delete post")
    @Feature(value = "User deleted post")
    @Description(value = "User can delete post")
    @Severity(SeverityLevel.BLOCKER)
    @AllureId("17")
    @Test(description = "CHATTY-8")
    public void userCanDeletePost() {
        // TODO: Need to add , creating post via api
        String email = "userdeletepost@abv.bg";
        String password = "Manowar33246";
        // TODO: Need to add , creating post via api

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoading();
        loginPage.login(email, password);

        homeBlogPage = new HomeBlogPage(app.driver);

        header = new Header(app.driver);
        header.waitForLoading();
        header.myPostClick();
        header.waitForLoading();
        header.setMyPostTab();

        editPostPage = new EditPostPage(app.driver);
        editPostPage.waitForLoading();
        editPostPage.deletePostButtonClick();

        homeBlogPage = new HomeBlogPage(app.driver);

    }
}
