package com.w2a.pages;

import com.w2a.base.Page;
import org.openqa.selenium.By;

import java.io.IOException;

public class HomePage extends Page {

    public HomePage() throws IOException {
    }

    public void goToCustomers() {
        driver.findElement(By.cssSelector(".zh-customers")).click();
    }
    public void  goToSupport() {
        driver.findElement(By.cssSelector(".zh-support")).click();
    }
    public void goToContactSales() {
        driver.findElement(By.cssSelector(".zh-contact")).click();
    }

    public LoginPage goToLogin() throws IOException {
        click("loginLink_CSS");
        return new LoginPage();
    }

    public void goToSignUp() {
        driver.findElement(By.cssSelector(".zh-signup")).click();
    }

    public void validateFooterLinks() {
    }
}
