package com.example.java_junit5.tests;


import com.example.java_junit5.pages.GooglePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Feature(value = "Google")
@DisplayName(value = "[KOTLIN][UI]")
public class GooglePageTest extends ConfigTest {
    @Test
    @Story(value = "Проверка калькулятора")
    public void check_work_calculator() {
        GooglePage.open("/");
        GooglePage.fill_search_form("Калькулятор");
        GooglePage.click_button();
        GooglePage.check_title("Калькулятор");
        String[] expression = new String[]{"1", "×", "2", "−", "3", "+", "1", "="};
        for (String item : expression) {
            GooglePage.click_button_with_text(item);
        }
        GooglePage.check_result(
                "1 × 2 - 3 + 1 =",
                "0"
        );
    }
}
