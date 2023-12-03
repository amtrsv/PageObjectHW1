package tests;
import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEN = new Faker(new Locale("en"));
    public Faker fakerRandomCity = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = fakerEN.internet().emailAddress(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            gender = faker.options().option("Male", "Female", "Other"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            subjects = faker.options().option("English", "Maths", "Biology"),
            picture = faker.options().option("amtrsv.png", "amtrsv32.png", "amtrsv134.png", "amtrsv12345.png"),
            yearBirth = Integer.toString(faker.number().numberBetween(1900, 2100)),
            monthBirth = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            dayBirth = String.format("0%d", faker.number().numberBetween(1, 11)),
            currentAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setRandomCity(state);

    public String setRandomCity(String state) {

        switch (state) {
            case "NCR":
                return fakerRandomCity.options().option("Delphi", "Gurgaon", "Noida");
            case "Utar Pradesh":
                return fakerRandomCity.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return fakerRandomCity.options().option("Karnal", "Panipat");
            case "Rajastan":
                return fakerRandomCity.options().option("Jaipur", "Jaiselmer");
            default:
                return state;
        }
    }
}
