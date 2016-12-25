package com.revature.Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:7001/Project");
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
        implicitwait();
    }

    public void setPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
        implicitwait();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void clickLoginButton() {
        driver.findElement(By.tagName("button")).click();
        implicitwait();
    }

    private void implicitwait() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    public void closeWindow() {
        implicitwait();
        driver.quit();
    }
}