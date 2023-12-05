package tests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationPage;


public class RegistrationWithRandomDataTests extends TestBase {
    StudentRegistrationPage registrationPage = new StudentRegistrationPage();
    TestData testData = new TestData();

    @Test
    @Tag("PO")
    @DisplayName("Проверка формы на ввод всех полей")

    void checkFormRegistration() {


        registrationPage.openPage()
                .closeAd()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.dayBirth, testData.monthBirth, testData.yearBirth)
                .setSubjectsInput(testData.subjects)
                .setHobbiesCheckbox(testData.hobbies)
                .loadPictureInput(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .setClickButton()
                .tableVisible()
                .resultCheck("Student Name", testData.firstName + " " + testData.lastName)
                .resultCheck("Student Email", testData.userEmail)
                .resultCheck("Gender", testData.gender)
                .resultCheck("Mobile", testData.userNumber)
                .resultCheck("Date of Birth", testData.dayBirth+ " " +testData.monthBirth+ "," +testData.yearBirth)
                .resultCheck("Subjects", testData.subjects)
                .resultCheck("Hobbies", testData.hobbies)
                .resultCheck("Picture", testData.picture)
                .resultCheck("Address", testData.currentAddress)
                .resultCheck("State and City", testData.state + " " + testData.city);

        }

    @Test
    @Tag("PO")
    @DisplayName("Проверка формы на ввод обязательных полей")
    void checkFormRegistrationRequiredFields() {

        registrationPage.openPage()
                .closeAd()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setSubjectsInput(testData.subjects)
                .setHobbiesCheckbox(testData.hobbies)
                .setCurrentAddress(testData.currentAddress)
                .setClickButton()
                .tableVisible()
                .resultCheck("Student Name", testData.firstName + " " + testData.lastName)
                .resultCheck("Gender", testData.gender)
                .resultCheck("Mobile", testData.userNumber)
                .resultCheck("Subjects", testData.subjects)
                .resultCheck("Hobbies", testData.hobbies)
                .resultCheck("Address", testData.currentAddress);

    }

    @Test
    @Tag("PO")
    @DisplayName("Проверка отправки пустой формы")
    void checkFormRegistrationEmptyFields() {
        registrationPage.openPage()
                .closeAd()
                .setClickButton()
                .tableHidden();

    }

}