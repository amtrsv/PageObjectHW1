package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class RegistrationWithPageObjectTests extends TestBase{

    StudentRegistrationPage registrationPage = new StudentRegistrationPage();

    @Test
    @DisplayName("Проверка формы на ввод всех полей")
    @Tag("WEB")
    void checkFormRegistration() {
        step("Открываем страрницу", () -> {
            registrationPage.openPage();
        });
        step("Заполняем все поля", () -> {
            registrationPage
                            .closeAd()
                            .setFirstName("Andrey")
                            .setLastName("Matrosov")
                            .setEmail("amtrsv@yandex.ru")
                            .setGender("Male")
                            .setUserNumber("9778384180")
                            .setDateOfBirth("18", "January", "2000")
                            .setSubjectsInput("Commerce")
                            .setHobbiesCheckbox("Sports")
                            .loadPictureInput("amtrsv32.png")
                            .setCurrentAddress("Moscow")
                            .setState("Haryana")
                            .setCity("Karnal")
                            .setClickButton()
                            .tableVisible();
        });
        step("Проверяем корректность заполненных полей", () -> {
            registrationPage
                            .resultCheck("Student Name", "Andrey Matrosov")
                            .resultCheck("Student Email", "amtrsv@yandex.ru")
                            .resultCheck("Gender", "Male")
                            .resultCheck("Mobile", "9778384180")
                            .resultCheck("Date of Birth", "18 January,2000")
                            .resultCheck("Subjects", "Commerce")
                            .resultCheck("Hobbies", "Sports")
                            .resultCheck("Picture", "amtrsv32.png")
                            .resultCheck("Address", "Moscow")
                            .resultCheck("State and City", "Haryana Karnal");

        });
    }

    @Test
    @DisplayName("Проверка формы на ввод обязательных полей")
    @Tag("WEB")
    void checkFormRegistrationRequiredFields(){


        step("Открываем страрницу", () -> {
            registrationPage.openPage();
        });

        step("Открываем страрницу", () -> {

            registrationPage.closeAd();
            registrationPage
                        .setFirstName("Andrey")
                        .setLastName("Matrosov")
                        .setGender("Male")
                        .setUserNumber("9778384180")
                        .setSubjectsInput("Commerce")
                        .setHobbiesCheckbox("Sports")
                        .setCurrentAddress("Moscow")
                        .setClickButton()
                        .tableVisible();
        });

        step("Проверяем корректность заполненных полей", () -> {
            registrationPage.tableVisible();
        });
            registrationPage.resultCheck("Student Name", "Andrey Matrosov")
                        .resultCheck("Gender", "Male")
                        .resultCheck("Mobile", "9778384180")
                        .resultCheck("Subjects", "Commerce")
                        .resultCheck("Hobbies", "Sports")
                        .resultCheck("Address", "Moscow");
    }

    @Test
    @DisplayName("Проверка отправки пустой формы")
    @Tag("WEB")
    void checkFormRegistrationEmptyFields() {

        step("Открываем страрницу", () -> {
            registrationPage.openPage();
        });

        step("Открываем страрницу", () -> {

            registrationPage.closeAd();
        });

        step("Проверяем что фома пустая, нажатием кнопки submit", () -> {

            registrationPage.setClickButton()
                            .tableHidden();
        });
    }
}
