package e2e.pages.profile;

import e2e.enums.GenderInfo;
import e2e.pages.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EditUserForm extends BasePage {
    public EditUserForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-test='post-header__plus']")
    WebElement editButton;

    @FindBy(xpath = "//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']")
    WebElement avatarImage;

    @FindBy(xpath = "//*[@name='name']")
    WebElement nameInput;

    @FindBy(xpath = "//*[@name='surname']")
    WebElement surnameInput;

    @FindBy(xpath = "//select[@id='gender']")
    WebElement gender;

    @FindBy(xpath = "//*[@id='birthDate']")
    WebElement birthDateForm;

    @FindBy(xpath = "//*[@name='phone']")
    WebElement phoneInput;

    @FindBy(xpath = "//*[@data-test='profileSaveButton']")
    WebElement saveButton;

    @Step("Wait for loading Edit profile page")
    public void waitForLoading() {
        try {
            getWait().forVisibility(editButton);
            getWait().forVisibility(nameInput);
            Assert.assertTrue(nameInput.isDisplayed());
            getWait().forVisibility(surnameInput);
            Assert.assertTrue(surnameInput.isDisplayed());
            getWait().forVisibility(gender);
            getWait().forVisibility(birthDateForm);
            Assert.assertTrue(birthDateForm.isDisplayed());
            getWait().forVisibility(phoneInput);
            Assert.assertTrue(phoneInput.isDisplayed());
            getWait().forVisibility(saveButton);
        } catch (StaleElementReferenceException e) {
        }
    }
    @Step("click edit button")
    public void clickEditUserForm() {
        editButton.click();
    }
    public String getName() {
        return nameInput.getAttribute("value");
    }
    public String getSurname() {
        return surnameInput.getAttribute("value");
    }
    public String getDate() {
        return birthDateForm.getAttribute("value");
    }
    public String getPhone() {
        return phoneInput.getAttribute("value");
    }

    @Step("upload avatar image {imagePath}")
    public void imageAvatarLoading(String imagePath) {
        try {
            WebElement fileInput = driver.findElement(By.xpath("//*[@accept='image/png,.png,image/jpg,.jpg,image/jpeg,.jpeg']"));
            fileInput.sendKeys(imagePath);;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Step("fill profile form")
    public void setProfileForm(String name, String surname, GenderInfo tab, String date, String phone) {
        try {
            nameInput.clear();
            nameInput.sendKeys(name);
        } catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
        surnameInput.clear();
        surnameInput.sendKeys(surname);
        WebElement option = driver.findElement(By.xpath("//*[@value='" + tab.value + "']"));
        gender.click();
        getWait().forVisibility(option);
        option.click();
        try {
            birthDateForm.clear();
            birthDateForm.sendKeys(date);
        } catch (StaleElementReferenceException e){
            e.printStackTrace();
        }
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }
    @Step("click save button")
    public void saveButtonClick() {
        saveButton.click();
    }
}
