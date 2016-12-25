package com.revature.Tests;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepDefinitions {
    private LoginPage loginPage;
    @Given("^I am on the login page$")
    public void goToLoginPage() throws Throwable {
        String PATH_TO_CHROME_DRIVER = "C:/selenium/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("^I enter \"([^\"]*)\" as the username$")
    public void enterUsername(String username) throws Throwable {
        loginPage.setUsername(username);
    }

    @Given("^I enter \"([^\"]*)\" as the password$")
    public void enterPassword(String password) throws Throwable {
        loginPage.setPassword(password);
    }

    @When("^I click the login button$")
    public void clickLogin() throws Throwable {
        loginPage.clickLoginButton();
    }

    @Then("^I will be greeted by \"([^\"]*)\"$")
    public void checkGreeting(String greeting) throws Throwable {
        org.junit.Assert.assertEquals(greeting, loginPage.getPageTitle());
        loginPage.closeWindow();
    }

}
