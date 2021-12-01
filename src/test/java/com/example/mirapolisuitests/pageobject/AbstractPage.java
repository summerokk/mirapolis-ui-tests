package com.example.mirapolisuitests.pageobject;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;

public abstract class AbstractPage {
    public String getAlertMessage() {
        Alert alert = getAlert();
        String alertMessage = alert.getText();
        alert.accept();

        return alertMessage;
    }

    public Alert getAlert() {
        return Selenide.switchTo().alert();
    }
}
