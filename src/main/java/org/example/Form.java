package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Form {
    private WebDriver driver;

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

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(css = "#hobbies-checkbox-1")
    private WebElement hobbiesSport;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "submit")
    private WebElement submit;
}
