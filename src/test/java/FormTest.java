import org.junit.jupiter.api.Assertions;
import org.example.Form;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class FormTest {

    @Test
    public void testFormSubmissions() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");

        Form form = PageFactory.initElements(driver, Form.class);

        form.hideAdById("Ad.Plus-970x250-1");
        form.enterRandomFirstName("Sophia");
        form.enterRandomLastName("Stetsura");
        form.enterRandomEmail("vasilevna-sofiya@mail.ru");
        form.selectFemaleRadioButton();
        form.enterRandomPhoneNumber("1234567890");
        form.selectDate();
        form.enterSubject("English");
        form.clickHobbiesSport();
        form.uploadImage("/Users/sophiastetsura/Downloads/PXL_20240817_144352781.jpg");
        form.enterCurrentAddress("Pushkin 20");
        form.selectState("Uttar Pradesh");
        form.selectCity("Agra");
        form.clickOnSubmit();

        String modalText = form.getHeaderText();
        Assertions.assertEquals("Thanks for submitting the form", modalText);
        Assertions.assertEquals("Sophia Stetsura", form.getStudentName());
        Assertions.assertEquals("vasilevna-sofiya@mail.ru", form.getStudentEmail());
        Assertions.assertEquals("Female", form.getGender());
        Assertions.assertEquals("1234567890", form.getMobile());
        Assertions.assertEquals("05 May,1990", form.getDateOfBirth());
        Assertions.assertEquals("English", form.getSubject());
        Assertions.assertEquals("Sports", form.getHobbies());
        Assertions.assertEquals("PXL_20240817_144352781.jpg", form.getPicture());
        Assertions.assertEquals("Pushkin 20", form.getAddress());
        Assertions.assertEquals("Uttar Pradesh Agra", form.getStateAndCity());

        driver.quit();
    }
}
