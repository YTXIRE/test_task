class GooglePage {
    constructor() {}

    check_title(title) {
        cy.allure().startStep('Проверка названия страницы').endStep()
        cy.title().should('include', title)
    }

    open() {
        cy.allure().startStep('Открытие страницы').endStep()
        cy.visit('/');
    }

    fill_search_form(text) {
        cy.allure().startStep('Заполнения поля поиска значением {value}').endStep()
        cy.xpath("//input[@title='Поиск']").type(text)
    }

    click_button() {
        cy.allure().startStep('Клик по кнопке поиска').endStep()
        cy.xpath("//input[@title='Поиск']").type('{enter}')
    }

    click_button_with_text(text) {
        cy.allure().startStep('Клик по кнопке с текстом - {text}').endStep()
        cy.xpath(`//td/div/div[text() = "${text}"]`).click()
    }

    check_result(expression, result) {
        cy.allure().startStep('Проверка результата').endStep()
        cy.xpath('//span[@jsname="ubtiRe"]').should('have.text', expression)
        cy.xpath('//span[@jsname="VssY5c"]').should('have.text', result)
    }
}

export default new GooglePage();