using OpenQA.Selenium.Chrome;

namespace csharp_nunit.utils
{
    public static class ChromeOptionsExtensions
    {
        public static ChromeOptions AddGlobal(this ChromeOptions options, string capabilityName, object capabilityValue)
        {
            options.AddAdditionalCapability(capabilityName, capabilityValue, true); 
            return options;
        }
    }
}