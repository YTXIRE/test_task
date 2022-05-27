package com.kt.kotlin_junit5.pages

import com.codeborne.selenide.Selectors.byXpath
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.title
import com.codeborne.selenide.Condition.text
import io.qameta.allure.Step

class GooglePage {
    @Step("Открытие страницы {url}")
    fun open(url: String = "/") {
        Selenide.open(url)
        Selenide.localStorage().clear()
    }

    @Step("Заполнения поля поиска значением {value}")
    fun fill_search_form(value: String) {
        element(byXpath("//input[@title='Поиск']")).value = value
    }

    @Step("Клик по кнопке поиска")
    fun click_button() {
        element(byXpath("//input[@title='Поиск']")).pressEnter()
    }

    @Step("Проверка названия страницы")
    fun check_title(page_title: String) {
        val pageTitle = title()
        assert(pageTitle?.contains(page_title) == true)
        { "Заголовок страницы: $pageTitle, ожидаемый результат: $page_title" }
    }

    @Step("Клик по кнопке с текстом - {text}")
    fun click_button_with_text(text: String) {
        element(byXpath("//td/div/div[text() = '$text']")).pressEnter()
    }

    @Step("Проверка результата")
    fun check_result(expression: String, result: String) {
        element(byXpath("//span[@jsname='ubtiRe']")).shouldBe(text(expression))
        element(byXpath("//span[@jsname='VssY5c']")).shouldBe(text(result))
    }
}