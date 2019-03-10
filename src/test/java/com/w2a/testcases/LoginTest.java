package com.w2a.testcases;

import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest{

    @Test (dataProvider = "getData")
    public void LoginTest(String username, String password) throws IOException {
        HomePage home = new HomePage();
        LoginPage lp = home.goToLogin();
        lp.doLogin(username, password);
    }

}
