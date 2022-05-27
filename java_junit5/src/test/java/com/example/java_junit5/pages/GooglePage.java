package com.example.java_junit5.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.title;

public class GooglePage {
    @Step("Открытие страницы {url}")
    public static void open(String url) {
        if (url == null) {
            url = "/";
        }
        Selenide.open(url);
        Selenide.localStorage().clear();
    }

    //
    @Step("Заполнения поля поиска значением {value}")
    public static void fill_search_form(String value) {
        $x("//input[@title='Поиск']").setValue(value);
    }

    @Step("Клик по кнопке поиска")
    public static void click_button() {
        $x("//input[@title='Поиск']").pressEnter();
    }

    @Step("Проверка названия страницы")
    public static void check_title(String page_title) {
        final String pageTitle = title();
        assert Objects.requireNonNull(pageTitle).contains(page_title) :
                "Заголовок страницы:" + pageTitle + ", ожидаемый результат: " + page_title;
    }

    @Step("Клик по кнопке с текстом - {text}")
    public static void click_button_with_text(String text) {
        $x("//td/div/div[text() = '" + text + "']").pressEnter();
    }

    @Step("Проверка результата")
    public static void check_result(String expression, String result) {
        $x("//span[@jsname='ubtiRe']").shouldBe(text(expression));
        $x("//span[@jsname='VssY5c']").shouldBe(text(result));
    }
}
