package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Form {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement lastName;

    @FindBy(id = "userEmail")
    private WebElement userEmail;

    @FindBy(id = "gender-radio-2")
    private WebElement femaleRadio;

    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement userNumber;

    @FindBy(css = "#dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(css = ".react-datepicker__year-select")
    private WebElement yearDropdown;

    @FindBy(css = ".react-datepicker__month-select")
    private WebElement monthDropdown;

    @FindBy(xpath = "//div[contains(@class, 'react-datepicker__day') and text()='5']")
    private WebElement day5;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(css = "label[for='hobbies-checkbox-1']")
    private WebElement hobbiesSport;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInput;

    @FindBy(id = "submit")
    private WebElement submit;

    @FindBy(css = ".modal-content")
    private WebElement modal;

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement header;

    @FindBy(id = "Ad.Plus-970x250-2")
    private WebElement footer;

    public Form(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterRandomFirstName(String randomName) {
        firstName.sendKeys(randomName);
    }

    public void enterRandomLastName(String randomLastName) {
        lastName.sendKeys(randomLastName);
    }

    public void enterRandomEmail(String randomEmail) {
        userEmail.sendKeys(randomEmail);
    }

    public void selectFemaleRadioButton() {
        scrollToElement(femaleRadio);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(femaleRadio));
            femaleRadio.click();
        } catch (TimeoutException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", femaleRadio);
        }
    }

    public void enterRandomPhoneNumber(String phoneNumber) {
        userNumber.sendKeys(phoneNumber);
   }

    public void selectDate() {
        scrollToElement(subjectsInput);
        dateOfBirthInput.click();

        wait.until(ExpectedConditions.visibilityOf(yearDropdown)).click();
        yearDropdown.sendKeys("1990");
        yearDropdown.click();

        wait.until(ExpectedConditions.visibilityOf(monthDropdown)).click();
        monthDropdown.sendKeys("May");
        monthDropdown.click();

        wait.until(ExpectedConditions.visibilityOf(day5)).click();
    }

    public void enterSubject(String text) {
        subjectsInput.sendKeys(text);
        subjectsInput.sendKeys(Keys.ENTER);
    }

    public void clickHobbiesSport() {
        scrollToElement(footer);
        hobbiesSport.click();
    }

    public void uploadImage(String filePath) {
        uploadPicture.sendKeys(filePath);
    }

    public void enterCurrentAddress(String address) {
        currentAddress.sendKeys(address);
    }
    public void selectState(String stateName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", state);
        wait.until(ExpectedConditions.visibilityOf(state));
        wait.until(ExpectedConditions.elementToBeClickable(state));
        state.click();
        stateInput.sendKeys(stateName);
        stateInput.sendKeys(Keys.ENTER);
    }
    public void selectCity(String cityName) {
        wait.until(ExpectedConditions.elementToBeClickable(city)).click();
        cityInput.sendKeys(cityName);
        cityInput.sendKeys(Keys.ENTER);
    }

    public void clickOnSubmit() {
        submit.click();
    }

    public String getHeaderText() {
        return header.getText();
    }

    public void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void hideAdById(String adId) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("document.getElementById('" + adId + "').style.display='none';");
    }
    public String getTableValueByLabel(String label) {
        String xpath = String.format("//td[text()='%s']/following-sibling::td", label);
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public String getStudentName() {
        return getTableValueByLabel("Student Name");
    }

    public String getStudentEmail() {
        return getTableValueByLabel("Student Email");
    }

    public String getGender() {
        return getTableValueByLabel("Gender");
    }

    public String getMobile() {
        return getTableValueByLabel("Mobile");
    }

    public String getDateOfBirth() {
        return getTableValueByLabel("Date of Birth");
    }

    public String getSubject() {
        return getTableValueByLabel("Subjects");
    }

    public String getHobbies() {
        return getTableValueByLabel("Hobbies");
    }

    public String getPicture() {
        return getTableValueByLabel("Picture");
    }

    public String getAddress() {
        return getTableValueByLabel("Address");
    }

    public String getStateAndCity() {
        return getTableValueByLabel("State and City");
    }
}
