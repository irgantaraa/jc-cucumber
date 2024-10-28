package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Utils;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginTest {

    private static WebDriver driver;

    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }

    @AfterAll
    public static void finish() {
        Utils.delay(5);
        DriverSingleton.closeObjectInstance();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("I enter a valid username and password")
    public void i_enter_a_valid_username_and_password() {
        loginPage.loginUser("Admin", "admin123");
    }

    @And("I click the login button")
    public void i_click_the_login_button() {
        loginPage.setBtnLogin();
    }

    @Then("I should be redirected to dashboard page")
    public void i_should_be_redirected_to_dashboard_page() {
        Assert.assertEquals(loginPage.getTxtDashboard(), "Dashboard");
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
        );

    }

    @Given("I am logout")
    public void i_am_logout() {
        loginPage.logout();
    }

    @When("I enter a invalid username and password")
    public void i_enter_a_invalid_username_and_password() {
        loginPage.loginUser("invalid", "invalid");
    }

    @Then("I see message invalid credentials")
    public void i_see_message_invalid_credentials() {
        Assert.assertEquals(loginPage.getTxtInvalid(), "Invalid credentials");
        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );
    }

}
