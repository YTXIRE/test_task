from core.utils.allure_wrapper import step
from core.utils.selene import be, have
from core.utils.selene.core import query
from elements.elements import Elements


class GooglePage(Elements):
    def __init__(self, browser):
        self.browser = browser

    @step('Открытие страницы')
    def open(self, url: str = '/'):
        self.browser.open(url)

    @step('Заполнения поля поиска значением {value}')
    def fill_search_form(self, value: str):
        self.element('[title="Поиск"]').set_value(value)

    @step('Клик по кнопке поиска')
    def click_button(self):
        self.element('[title="Поиск"]').press_enter()

    @step('Проверка названия страницы')
    def check_title(self, title: str):
        page_title = self.browser.get(query.title)
        assert title in page_title, f"Заголовок страницы: {page_title}, ожидаемый результат: {title}"

    @step('Клик по кнопке с текстом - {text}')
    def click_button_with_text(self, text: str):
        self.element(f'//td/div/div[text() = "{text}"]').press_enter()

    @step('Проверка результата')
    def check_result(self, expression: str, result: str):
        self.element('//span[@jsname="ubtiRe"]').should(have.text(expression))
        self.element('//span[@jsname="VssY5c"]').should(have.text(result))
