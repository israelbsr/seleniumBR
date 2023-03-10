package com.dotdash.test.parallel;

import com.dotdash.flow.LoginFlow;
import com.dotdash.pageobject.LoginPage;
import com.dotdash.test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends BaseTest {

    private LoginPage login_page = null;

    @BeforeMethod
    void init() {
        if (login_page == null) login_page = new LoginPage(driver);
    }

    @Test
    void login_invalid_creds() throws InterruptedException {
    
        login_page
                .input_username("abc")
                .input_password("abc")
                .click_on_login_btn();
        login_page.verify_wrong_credentials_msg();
    }

    @Test
    void login_valid_creds() {
       
        LoginFlow login_flow = new LoginFlow(driver, "tomsmith", "SuperSecretPassword!");
        login_flow.login();
        login_flow.verify_correct_credentials_msg();
    }

}


