/// <reference types="cypress" />
/// <reference types="@shelex/cypress-allure-plugin" />

import GooglePage from "../pages/GooglePage.js";

describe('[UI]: Google', () => {
    it('Проверка калькулятора', () => {
        cy.allure().parentSuite('[JS][CYPRESS][UI]')
        cy.allure().suite('Проверка калькулятора')
        const google_page = GooglePage;
        google_page.open();
        google_page.fill_search_form('Калькулятор');
        google_page.click_button();
        google_page.check_title('Калькулятор')
        for (let item of ['1', '×', '2', '−', '3', '+', '1', '=']) {
            google_page.click_button_with_text(item);
        }
        google_page.check_result(
            '1 × 2 - 3 + 1 =',
            '0',
        );
    })
})
