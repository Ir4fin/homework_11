package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;
import pages.components.StateAndCityComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper");

    private final static String TITLE_TEXT = "Student Registration Form";

    @Step("Открываем тестовую форму для заполнения")
    public PracticeFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Вводим случайное имя")
    public PracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Вводим случайную фамилию")
    public PracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Заполняем email")
    public PracticeFormPage setUserEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    @Step("Устанавливаем значение пола")
    public PracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }

    @Step("Вводим случайный номер телефона")
    public PracticeFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    @Step("Заполняем случайную дату рождения")
    public PracticeFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    @Step("Заполняем строку Subjects")
    public PracticeFormPage setSubjectsInput(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    @Step("Указываем хобби")
    public PracticeFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    @Step("Загружаем тестовый файл {value}")
    public PracticeFormPage uploadFile(String value) {
        $("#uploadPicture").uploadFile(new File(value));

        return this;
    }

    @Step("Вводим случайный адрес")
    public PracticeFormPage setAddress(String value) {
        $("#currentAddress").setValue(value);

        return this;
    }
    @Step("Задаем область и город")
    public PracticeFormPage setStateAndCity(String state, String city) {
        stateAndCityComponent.setStateAndCity(state, city);

        return this;
    }
    @Step("Нажимаем на Submit")
    public PracticeFormPage clickOnSubmit() {
        $("#submit").click();

        return this;
    }

    @Step("Проверяем, что таблица с результатами отображена на экране")
    public PracticeFormPage checkResultTableIsVisible() {
        resultTableComponent.checkIsVisible();

        return this;
    }
    @Step("Сверяем значения в таблице результатов с введенными данными")
    public PracticeFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key, value);

        return this;
    }

}
