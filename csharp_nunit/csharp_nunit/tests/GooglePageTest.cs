using System.Collections.Generic;
using csharp_nunit.pages;
using NUnit.Framework;

namespace csharp_nunit.tests
{
    public class Tests : ConfigTest
    {
        [Test]
        public void TestGoogleSearch()
        {
            GooglePage.Open(BaseUrl);
            GooglePage.FillSearchForm("Калькулятор");
            GooglePage.ClickButton();
            GooglePage.CheckTitle("Калькулятор");
            foreach (var item in new List<string>  {"1", "×", "2", "−", "3", "+", "1", "="}) {
                GooglePage.ClickButtonWithText(item);
            }
            GooglePage.CheckResult("1 × 2 - 3 + 1 =", "0");
        }
    }
}
