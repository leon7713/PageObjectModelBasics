package com.w2a.rough;

import com.w2a.base.Page;
import com.w2a.com.w2a.pages.crm.com.w2w.pages.crm.accounts.AccountsPage;
import com.w2a.com.w2a.pages.crm.com.w2w.pages.crm.accounts.CreateAccountPage;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;

import java.io.IOException;

import static com.w2a.base.Page.driver;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException, IOException {

        HomePage home = new HomePage();
        LoginPage lp = home.goToLogin();
        ZohoAppPage zp = lp.doLogin("leonushar@gmail.com", "wSCz-_ysVDjm6cR");
        zp.gotoCRM();
        AccountsPage account = Page.menu.gotoAccounts();
        CreateAccountPage cap = account.gotoCreateAccount();
        cap.createAccount("Leon");

        Thread.sleep(3000);
        driver.close();
    }
}
