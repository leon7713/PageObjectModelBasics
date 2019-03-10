package com.w2a.testcases;

import com.w2a.base.Page;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

public class BaseTest {

    @AfterSuite
    public void tearDown() {
        Page.quit();
    }

    @DataProvider
    public Object[][] getData() {
        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[1][2];
        data[0][0] = "leonushar@gmail.com";
        data[0][1] = "wSCz-_ysVDjm6cR";
        return data;
    }

    @DataProvider
    public Object[][] getDataTwo() {
        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[1][1];
        data[0][0] = "Leon";
        return data;
    }
}
