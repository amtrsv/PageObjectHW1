package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.FormResultComponent;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StudentRegistrationPage {
    public SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            loadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            buttonSubmit = $("#submit"),
            checkTable = $(".table-responsive");


    CalendarComponent calendarComponent = new CalendarComponent();
    FormResultComponent formResult = new FormResultComponent();

    public StudentRegistrationPage closeAd() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public StudentRegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }


    public StudentRegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;

    }

    public StudentRegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public StudentRegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();
        return this;

    }

    public StudentRegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDateOfBirth(day, month, year);
        return this;
    }

    public StudentRegistrationPage setSubjectsInput(String value) {
        subjectsInput.val(value).pressEnter();
        return this;

    }

    public StudentRegistrationPage setHobbiesCheckbox(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;

    }

    public StudentRegistrationPage loadPictureInput(String classpath) {
        loadPicture.uploadFromClasspath(classpath);
        return this;
    }

    public StudentRegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public StudentRegistrationPage setCity(String value) {
        cityInput.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage setState(String value) {
        stateInput.val(value).pressEnter();
        return this;
    }

    public StudentRegistrationPage resultCheck(String key, String value) {
        formResult.resultCheck(key, value);

        return this;
    }

    public StudentRegistrationPage setClickButton() {
        buttonSubmit.click();
        return this;
    }

    public StudentRegistrationPage tableVisible() {
        checkTable.shouldBe(visible);

        return this;
    }
    public void tableHidden() {
        checkTable.shouldBe(hidden);

}
    }

