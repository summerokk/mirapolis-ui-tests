package com.example.mirapolisuitests.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordPage {
    @FindBy(how = How.CLASS_NAME, using = "mira-page-forgot-password-button")
    private SelenideElement loginInput;

    public SelenideElement getLoginInput() {
        return loginInput;
    }
}
