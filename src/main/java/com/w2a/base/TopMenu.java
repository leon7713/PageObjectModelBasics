package com.w2a.base;

import com.w2a.com.w2a.pages.crm.com.w2w.pages.crm.accounts.AccountsPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TopMenu {

    WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    public void gotoHome() {

    }

    public void gotoLeads() {

    }

    public void gotoContacts() {

    }

    public AccountsPage gotoAccounts() throws IOException {

        Page.click("accountstab_CSS");
        return new AccountsPage();
    }

    public void gotoDeals() {

    }

    public void gotoActivities() {

    }

    public void gotoReports() {

    }

    public void gotoAnalitycs() {

    }

    public void gotoProjects() {

    }

    public void sighOut() {

    }
}
