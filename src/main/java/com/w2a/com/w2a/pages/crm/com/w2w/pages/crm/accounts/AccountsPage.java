package com.w2a.com.w2a.pages.crm.com.w2w.pages.crm.accounts;

import com.w2a.base.Page;

import java.io.IOException;

public class AccountsPage extends Page {

    public AccountsPage() throws IOException {
    }

    public CreateAccountPage gotoCreateAccount() throws IOException {
        click("crmlink_CSS");
        return new CreateAccountPage();
    }

    public void gotoImportAccounts() {

    }
}
