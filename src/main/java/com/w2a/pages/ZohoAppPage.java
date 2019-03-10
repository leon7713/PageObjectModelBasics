package com.w2a.pages;

import com.w2a.base.Page;
import com.w2a.com.w2a.pages.crm.CRMHomePage;
import org.openqa.selenium.By;

import java.io.IOException;

public class ZohoAppPage extends Page {

    public ZohoAppPage() throws IOException {
    }

    public void gotoCliq() {
        driver.findElement(By.cssSelector(".zicon-apps-chat.zicon-apps-96")).click();
    }

    public CRMHomePage gotoCRM() throws IOException {

        driver.findElement(By.cssSelector(".zicon-apps-crm.zicon-apps-96")).click();
        return new CRMHomePage();
    }

    public void gotoSalesIQ() {
        driver.findElement(By.cssSelector(".zicon-apps-salesiq.zicon-apps-96")).click();
    }
}
