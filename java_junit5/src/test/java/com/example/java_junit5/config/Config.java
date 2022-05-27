package com.example.java_junit5.config;

public class Config {
    // local settings
    private static final String localBaseUrl = "https://google.ru";
    private static final String localApiUrl = "https://google.ru/api";
    public static final Integer timeout = 10000;
    public static final String browser = "chrome";
    public static final String browserSize = "1920x1080";
    // selenoid settings
    private static final String remoteBaseUrl = "https://google.ru";
    private static final String remoteApiUrl = "https://google.ru/api";
    public static final String selenoidUrl = "http://localhost:4444/wd/hub";
    public static final String selenoidBrowserVersion = "102.0";
    public static final Boolean selenoidEnableVNC = true;
    public static final Boolean selenoidEnableVideo = false;
    public static final Boolean selenoidEnableLog = true;
    // db
    static final String jdbc = "jdbc:mysql";
    private static final String localHost = "localhost";
    private static final String remoteHost = "localhost";
    private static final String localDbName = "test";
    private static final String remoteDbName = "test";
    private static final String localUser = "root";
    private static final String remoteUser = "root";
    private static final String localPassword = "root";
    private static final String remotePassword = "root";
    // mode test run
    private static final String mode_property = System.getProperty("mode");
    public static final String mode = (mode_property != null) ? mode_property : "local";
    public static final String baseUrl = (mode.equals("local")) ? localBaseUrl : remoteBaseUrl;
    public static final String apiUrl = (mode.equals("local")) ? localApiUrl : remoteApiUrl;
    public static final Integer port = (mode.equals("local")) ? 3306 : 3307;
    public static final String host = (mode.equals("local")) ? localHost : remoteHost;
    public static final String dbName = (mode.equals("local")) ? localDbName : remoteDbName;
    public static final String user = (mode.equals("local")) ? localUser : remoteUser;
    public static final String password = (mode.equals("local")) ? localPassword : remotePassword;
}
