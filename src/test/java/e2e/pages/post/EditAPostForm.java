package e2e.pages.post;

import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditAPostForm extends BasePage {
    public EditAPostForm(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@data-test='title-input']")
    WebElement titleInput;

    @FindBy(xpath = "//*[@data-test='description-input']")
    WebElement descriptionInput;

    @FindBy(xpath = "//*[@data-test='textarea']")
    WebElement contentInput;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement submitEditButton;

    @FindBy(xpath = "//*[@class='close']")
    WebElement closeButton;

    public String getEditTitle() {
        return titleInput.getAttribute("value");
    }

    public String getEditDescriptionText() {
        return descriptionInput.getAttribute("value");
    }

    public String getEditContent() {
        return contentInput.getAttribute("value");
    }

    @Step("Wait for loading edit a post")
    public void waitForLoading() {
        try {
            getWait().forVisibility(titleInput);
            getWait().forVisibility(descriptionInput);
            getWait().forVisibility(contentInput);
            getWait().forVisibility(submitEditButton);
            //getWait().forVisibility(tumblerSwitch);
            getWait().forVisibility(closeButton);
        } catch (Exception e) {
            Assert.fail("Failed to load Create a post form: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void editPost(String editTitle, String editDescription, String editContent) {
        titleInput.clear();
        titleInput.sendKeys(editTitle);
        descriptionInput.clear();
        descriptionInput.sendKeys(editDescription);
        contentInput.clear();
        contentInput.sendKeys(editContent);
    }
    @Step("Upload image: {imagePath}")
    public void imageLoading(String relativeImagePath) {
        try {
            String absoluteImagePath = System.getProperty("user.dir") + "/" + relativeImagePath;
            WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
            fileInput.sendKeys(absoluteImagePath);
        } catch (Exception e) {
            Assert.fail("Failed to upload image: " + e.getMessage());
        }
    }
    public void draftTumblerSwitch() {
        //tumblerSwitch.click();
    }
    public void clickEditSubmitButton() {
        submitEditButton.click();
    }
}
