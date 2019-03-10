package com.w2a.pages;

import com.w2a.base.Page;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginPage extends Page {

    public LoginPage() throws IOException {
    }

    public ZohoAppPage doLogin(String username, String password) throws IOException {

        type("email_CSS", username);
        type("password_CSS", password);
        click("signinbtn_CSS");

//        if (driver.findElement(By.cssSelector(".close-btn")).isDisplayed()) {
//            driver.findElement(By.cssSelector(".close-btn")).click();
//        }

        if (isElementPresent(By.cssSelector(OR.getProperty("closebtn_CSS")))) {
            click("closebtn_CSS");
        }

        return new ZohoAppPage();
    }
}
