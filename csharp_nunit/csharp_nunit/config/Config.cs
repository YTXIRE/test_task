using System.Drawing;

namespace csharp_nunit.config {
    public class Config {
        // local settings
        private const string LocalBaseUrl = "https://google.ru";
        private const string LocalApiUrl = "https://google.ru/api";
        protected const int Timeout = 10000;
        protected string Browser = "chrome";
        protected readonly int BrowserWidth = 1920;
        protected readonly int BrowserHeight = 1080;
        // selenoid settings
        private const string RemoteBaseUrl = "https://google.ru";
        private const string RemoteApiUrl = "https://google.ru/api";
        protected string SelenoidUrl = "http://localhost:4444/wd/hub";
        protected const string SelenoidBrowserVersion = "96.0";
        protected static readonly object SelenoidEnableVnc = "true";
        protected static readonly object SelenoidEnableVideo = "false";
        protected bool SelenoidEnableLog = true;
        // db
        protected string Jdbc = "jdbc:mysql";
        private const string LocalHost = "localhost";
        private const string RemoteHost = "localhost";
        private const string LocalDbName = "test";
        private const string RemoteDbName = "test";
        private const string LocalUser = "root";
        private const string RemoteUser = "root";
        private const string LocalPassword = "root";
        private const string RemotePassword = "root";
        // mode test run
        private static readonly string RunMode = System.Environment.GetEnvironmentVariable("mode");
        protected static readonly string Mode = RunMode ?? "local";
        protected readonly string BaseUrl = (Mode == "local") ? LocalBaseUrl : RemoteBaseUrl;
        protected string ApiUrl = (Mode == "local") ? LocalApiUrl : RemoteApiUrl;
        protected int Port = (Mode == "local") ? 3306 : 3307;
        protected string Host = (Mode == "local") ? LocalHost : RemoteHost;
        protected string DbName = (Mode == "local") ? LocalDbName : RemoteDbName;
        protected string User = (Mode == "local") ? LocalUser : RemoteUser;
        protected string Password = (Mode == "local") ? LocalPassword : RemotePassword;
    }
}