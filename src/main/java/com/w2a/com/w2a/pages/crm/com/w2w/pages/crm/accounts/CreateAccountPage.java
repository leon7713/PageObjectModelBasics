package com.w2a.com.w2a.pages.crm.com.w2w.pages.crm.accounts;

import com.w2a.base.Page;

import java.io.IOException;

public class CreateAccountPage extends Page {

    public CreateAccountPage() throws IOException {
    }

    public void createAccount(String accountName) {
        Page.type("accountname_CSS", accountName);
    }
}
