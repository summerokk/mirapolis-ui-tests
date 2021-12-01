package com.example.mirapolisuitests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.example.mirapolisuitests.pageobject.AuthPage;
import com.example.mirapolisuitests.pageobject.DashboardPage;
import com.example.mirapolisuitests.pageobject.ResetPasswordPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthPageTest {
    private final static String AUTH_URL = "https://lmslite47vr.demo.mirapolis.ru/mira";
    private final static String INVALID_CSS_CLASS = "invalid";

    @BeforeAll
    static void setUpAll() {
        Configuration.headless = true;
    }

    @BeforeEach
    void setUpEach() {
        clearBrowserCookies();
    }

    @Test
    void authPage_shouldBeLoadedSuccessfully() {
        AuthPage authPage = open(AUTH_URL, AuthPage.class);
        authPage.getLogo().should(Condition.exist);
    }

    @Test
    void clickLOnLogo_shouldRedirectBack() {
        AuthPage authPage = open(AUTH_URL, AuthPage.class);
        authPage.clickLogo();

        authPage.getLoginForm().should(Condition.exist);
    }

    @Test
    void clickLOnLoginButton_shouldRedirectToDashboardPage_whenLoginAndPasswordAreCorrect() {
        AuthPage authPage = open(AUTH_URL, AuthPage.class);
        authPage.inputLogin(ConfProperties.getProperty("login"));
        authPage.inputPassword(ConfProperties.getProperty("password"));

        authPage.clickLoginButton();

        DashboardPage dashboardPage = page(DashboardPage.class);
        dashboardPage.getUserInfoWidget().should(Condition.exist);
    }

    @Test
    void showPasswordButton_shouldChangePasswordType_whenUserClicksOnIt() {
        AuthPage authPage = open(AUTH_URL, AuthPage.class);

        authPage.clickShowPasswordButton();
        final Condition inputTextType = Condition.attribute("type", "text");
        authPage.getPasswordInput().shouldHave(inputTextType);

        authPage.clickShowPasswordButton();
        final Condition inputPasswordType = Condition.attribute("type", "password");
        authPage.getPasswordInput().shouldHave(inputPasswordType);
    }

    @Test
    void clickLOnLoginButton_shouldRedirectBackWithErrorAndInvalidCssClassForLoginForm_whenLoginAndPasswordAreWrong() {
        AuthPage authPage = open(AUTH_URL, AuthPage.class);
        authPage.inputLogin("wrong_login");
        authPage.inputPassword("wrong_password");
        authPage.clickLoginButton();

        String errorMessage = authPage.getAlertMessage();

        authPage.getLoginForm().shouldHave(Condition.cssClass(INVALID_CSS_CLASS));
        assertEquals("Неверные данные для авторизации", errorMessage);
    }

    @Test
    void clickLOnLoginButton_shouldRedirectBackWithErrorAndInvalidCssClassForLoginForm_whenLoginAndPasswordAreEmpty() {
        AuthPage authPage = open(AUTH_URL, AuthPage.class);
        authPage.inputLogin("");
        authPage.inputPassword("");
        authPage.clickLoginButton();

        String errorMessage = authPage.getAlertMessage();

        authPage.getLoginForm().shouldHave(Condition.cssClass(INVALID_CSS_CLASS));
        assertEquals("Неверные данные для авторизации.", errorMessage);
    }

    @Test
    void clickOnResetPasswordLink_shouldRedirectToResetPasswordPage() {
        AuthPage authPage = open(AUTH_URL, AuthPage.class);
        authPage.clickOnResetPasswordLink();
        
        ResetPasswordPage resetPasswordPage = page(ResetPasswordPage.class);
        resetPasswordPage.getLoginInput().should(Condition.exist);
    }
}
