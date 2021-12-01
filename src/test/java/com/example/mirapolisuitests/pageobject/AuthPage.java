package com.example.mirapolisuitests.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuthPage extends AbstractPage {
    @FindBy(how = How.CSS, using = ".mainContainer .head")
    private SelenideElement logo;

    @FindBy(how = How.ID, using = "login_form_panel")
    private SelenideElement loginForm;

    @FindBy(how = How.NAME, using = "user")
    private SelenideElement loginInput;

    @FindBy(how = How.NAME, using = "password")
    private SelenideElement passwordInput;

    @FindBy(how = How.ID, using = "button_submit_login_form")
    private SelenideElement authButton;

    @FindBy(how = How.ID, using = "show_password")
    private SelenideElement showPasswordButton;

    @FindBy(how = How.CSS, using = "#login_form_panel .mira-default-login-page-link")
    private SelenideElement resetPasswordLink;

    public void inputLogin(String login) {
        loginInput.setValue(login);
    }

    public SelenideElement getPasswordInput() {
        return passwordInput;
    }

    public void inputPassword(String password) {
        passwordInput.setValue(password);
    }

    public SelenideElement getLoginForm() {
        return loginForm;
    }

    public SelenideElement getLogo() {
        return logo;
    }

    public void clickLoginButton() {
        authButton.click();
    }

    public void clickOnResetPasswordLink() {
        resetPasswordLink.click();
    }

    public void clickShowPasswordButton() {
        showPasswordButton.click();
    }

    public void clickLogo() {
        logo.click();
    }
}
