from allure import title, description, suite, parent_suite, sub_suite


@suite('Google')
@parent_suite('[Pytest][UI]')
@sub_suite('Работа с поисковой страницей Google')
class TestGoogle:
    @title('Проверка калькулятора')
    @description('Проверка работы калькулятора с выражением "1 × 2 - 3 + 1 ="')
    def test_google_search(self, google_page):
        google_page.open()
        google_page.fill_search_form('Калькулятор')
        google_page.click_button()
        google_page.check_title('Калькулятор')
        for item in ['1', '×', '2', '−', '3', '+', '1', '=']:
            google_page.click_button_with_text(item)
        google_page.check_result(
            expression='1 × 2 - 3 + 1 =',
            result='0',
        )
