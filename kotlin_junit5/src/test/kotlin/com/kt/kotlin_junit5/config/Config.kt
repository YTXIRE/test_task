package com.able.config

open class Config {
    // local settings
    private val localBaseUrl = "https://google.ru"
    private val localApiUrl = "https://google.ru/api"
    val timeout = 10000
    val browser = "chrome"
    val browserSize = "1920x1080"
    // selenoid settings
    private val remoteBaseUrl = "https://google.ru"
    private val remoteApiUrl = "https://google.ru/api"
    val selenoidUrl = "http://localhost:4444/wd/hub"
    val selenoidBrowserVersion = "96.0"
    val selenoidEnableVNC = true
    val selenoidEnableVideo = false
    val selenoidEnableLog= true
    // db
    val jdbc = "jdbc:mysql"
    private val localHost = "localhost"
    private val remoteHost = "localhost"
    private val localDbName = "test"
    private val remoteDbName = "tes"
    private val localUser = "root"
    private val remoteUser = "root"
    private val localPassword = "root"
    private val remotePassword = "root"
    // mode test run
    val mode: String? = if (System.getProperty("mode") !== null) System.getProperty("mode") else "local"
    val baseUrl = if (mode === "local") localBaseUrl else remoteBaseUrl
    val apiUrl = if (mode === "local") localApiUrl else remoteApiUrl
    val port = if (mode === "local") 3306 else 3307
    val host = if (mode === "local") localHost else remoteHost
    val dbName = if (mode === "local") localDbName else remoteDbName
    val user = if (mode === "local") localUser else remoteUser
    val password = if (mode === "local") localPassword else remotePassword
}