package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;

public class RegistrationWithPageObjectTests extends TestBase{

    StudentRegistrationPage registrationPage = new StudentRegistrationPage();

    @Test
    @DisplayName("Проверка формы на ввод всех полей")
    void checkFormRegistration(){
        registrationPage.openPage()
                        .closeAd()
                        .setFirstName("Andrey")
                        .setLastName("Matrosov")
                        .setEmail("amtrsv@yandex.ru")
                        .setGender("Male")
                        .setUserNumber("9778384180")
                        .setDateOfBirth("17", "November", "1994")
                        .setSubjectsInput("Commerce")
                        .setHobbiesCheckbox("Sports")
                        .loadPictureInput()
                        .setCurrentAddress("Moscow")
                        .setState("Haryana")
                        .setCity("Karnal")
                        .setClickButton()
                        .resultCheck("Student Name", "Andrey Matrosov")
                        .resultCheck("Student Email", "amtrsv@yandex.ru")
                        .resultCheck("Gender", "Male")
                        .resultCheck("Mobile", "9778384180")
                        .resultCheck("Date of Birth", "17 November,1994")
                        .resultCheck("Subjects", "Commerce")
                        .resultCheck("Hobbies", "Sports")
                        .resultCheck("Picture", "amtrsv.png")
                        .resultCheck("Address", "Moscow")
                        .resultCheck("State and City", "Haryana Karnal");

    }


    @Test
    @DisplayName("Проверка формы на ввод обязательных полей")
    void checkFormRegistrationRequiredFields(){

        registrationPage.openPage()
                        .closeAd()
                        .setFirstName("Andrey")
                        .setLastName("Matrosov")
                        .setGender("Male")
                        .setUserNumber("9778384180")
                        .setSubjectsInput("Commerce")
                        .setHobbiesCheckbox("Sports")
                        .setCurrentAddress("Moscow")
                        .setClickButton()
                .resultCheck("Student Name", "Andrey Matrosov")
                .resultCheck("Gender", "Male")
                .resultCheck("Mobile", "9778384180")
                .resultCheck("Subjects", "Commerce")
                .resultCheck("Hobbies", "Sports")
                .resultCheck("Address", "Moscow");
    }

    @Test
    @DisplayName("Проверка отправки пустой формы")
    void checkFormRegistrationEmptyFields() {
        registrationPage.openPage()
                        .closeAd()
                        .setClickButton();
    }
}
