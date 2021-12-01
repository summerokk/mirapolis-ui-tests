package com.example.mirapolisuitests.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {
    @FindBy(how = How.CLASS_NAME, using = "user_info_widget")
    private SelenideElement userInfoWidget;

    public SelenideElement getUserInfoWidget() {
        return userInfoWidget;
    }
}
