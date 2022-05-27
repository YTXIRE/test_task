package com.kt.kotlin_junit5.tests

import com.kt.kotlin_junit5.pages.GooglePage
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.*

@Feature(value = "Google")
@DisplayName(value = "[KOTLIN][UI]")
class GooglePageTest : ConfigTest() {
    private val googlePage = GooglePage()

    @Test
    @Story(value = "Проверка калькулятора")
    fun `Проверка калькулятора`() {
        googlePage.open()
        googlePage.fill_search_form(value = "Калькулятор")
        googlePage.click_button()
        googlePage.check_title(page_title = "Калькулятор")
        for (item in arrayOf("1", "×", "2", "−", "3", "+", "1", "=")) {
            googlePage.click_button_with_text(text = item)
        }
        googlePage.check_result(
            expression = "1 × 2 - 3 + 1 =",
            result = "0"
        )
    }
}
