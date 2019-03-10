package com.w2a.testcases;

import com.w2a.base.Page;
import com.w2a.com.w2a.pages.crm.com.w2w.pages.crm.accounts.AccountsPage;
import com.w2a.com.w2a.pages.crm.com.w2w.pages.crm.accounts.CreateAccountPage;
import com.w2a.pages.ZohoAppPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateAccountTest extends BaseTest{

    @Test (dataProvider = "getDataTwo")
    public void createAccountTest(String accountName) throws IOException {

        ZohoAppPage zp = new ZohoAppPage();
        zp.gotoCRM();
        AccountsPage account = Page.menu.gotoAccounts();
        CreateAccountPage cap = account.gotoCreateAccount();
        cap.createAccount(accountName);
    }
}
