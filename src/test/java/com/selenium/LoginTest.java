package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    protected WebDriver driver;
    
    @BeforeMethod
    public void setup() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Configure Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Allow all origins
        options.addArguments("--start-maximized"); // Start maximized
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("--disable-extensions"); // Disable extensions
        
        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        
        // Optional: Set implicit wait (not recommended for production)
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get("https://www.google.com");
        
        // Print page title
        System.out.println("Page title: " + driver.getTitle());
        
        // Add your test assertions here
        // Assert.assertEquals(driver.getTitle(), "Google");
    }
    
    @AfterMethod
    public void teardown() {
        // Quit the driver if it exists
        if (driver != null) {
            driver.quit();
        }
    }
}