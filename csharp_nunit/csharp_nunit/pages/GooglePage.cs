using NSelene;
using NUnit.Framework;

namespace csharp_nunit.pages
{
    public static class GooglePage
    {
        internal static void Open(string url = "/")
        {
            Selene.Open(url);
        }

        internal static void FillSearchForm(string value)
        {
            Selene.S("//input[@title='Поиск']").SetValue(value);
        }

        internal static void ClickButton()
        {
            Selene.S("//input[@title='Поиск']").PressEnter();
        }

        internal static void CheckTitle(string pageTitle)
        {
            var title = Selene.GetWebDriver().Title;
            StringAssert.Contains(pageTitle, title, "Заголовок страницы: " + title + ", ожидаемый результат: " + pageTitle);
        }

        internal static void ClickButtonWithText(string value)
        {
            Selene.S("//td/div/div[text() = '" + value + "']").PressEnter();
        }

        internal static void CheckResult(string expression, string result)
        {
            Selene.S("//span[@jsname='ubtiRe']").Should(Have.Text(expression));
            Selene.S("//span[@jsname='VssY5c']").Should(Have.Text(result));
        }
    }
}