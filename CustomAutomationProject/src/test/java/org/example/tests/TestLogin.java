package org.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestLogin {
    private WebDriver driver;
    public Object Assert;

    public TestLogin(Object anAssert)
    {
        Assert = anAssert;
    }

    public static void main(String[] args)
    {
        System.out.println("Hello World!");

       //  WebDriver driver = new ChromeDriver();
       // driver.get("https://agrawalprinters.com/");
        setUp();
        testWebsiteTitle();
        testHomePage();
        navigateToServicesPage();
        navigateToContactUsPage();
        navigateBackToHomePage();
        tearDown();


    }

    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/pdgt/Downloads/chromedriver-mac-arm64");
        driver = new ChromeDriver();
        driver.get("https://agrawalprinters.com/");
        driver.manage().window().maximize();
    }

    public void testWebsiteTitle()
    {
        // Verify the title of the webpage
        String title = driver.getTitle();
        System.out.println("Title of the webpage: " + title);
        Assert.assertTrue(title.contains("Agrawal Printers"));
    }

    public void testHomePage()
    {
        // Verify the title of the home page
        String title = driver.getTitle();
        System.out.println("Title of the homepage: " + title);
        Assert.assertTrue(title.contains("Agrawal Printers"));
    }

    @Test(dependsOnMethods = {"testHomePage"})
    public void navigateToServicesPage()
    {
        // Find the hamburger menu icon and click it
        WebElement hamburgerMenu = driver.findElement(By.cssSelector("#\\31  > svg"));
        hamburgerMenu.click();

        // Click on the "Services" link
        WebElement servicesLink = driver.findElement(By.xpath("//*[@id=\"n-91026-navListId-mobile\"]/li[2]/a/span"));
        ;
        servicesLink.click();

        // Verify the URL
        String servicesUrl = driver.getCurrentUrl();
        Assert.assertTrue(servicesUrl.contains("services"));
    }

    @Test(dependsOnMethods = {"navigateToServicesPage"})
    public void navigateToContactUsPage()
    {
        // Find the hamburger menu icon and click it
        WebElement hamburgerMenu = driver.findElement(By.cssSelector("#\\31  > svg"));
        hamburgerMenu.click();

        // Click on the "Contact Us" link
        WebElement contactUsLink = driver.findElement(By.xpath("//*[@id=\"n-91026-navListId-mobile\"]/li[3]/a/span"));
        contactUsLink.click();

        // Verify the URL
        String contactUrl = driver.getCurrentUrl();
        Assert.assertTrue(contactUrl.contains("contact-us"));
    }

    @Test(dependsOnMethods = {"navigateToContactUsPage"})
    public void navigateBackToHomePage()
    {
        // Find the hamburger menu icon and click it
        WebElement hamburgerMenu = driver.findElement(By.cssSelector("#\\31  > svg"));
        hamburgerMenu.click();

        // Click on the "Home" link
        WebElement homeLink = driver.findElement(By.xpath("//*[@id=\"n-97976-navListId-mobile\"]/li[1]/a/span"));
        homeLink.click();

        // Verify the URL
        String homeUrl = driver.getCurrentUrl();
        Assert.assertTrue(homeUrl.equals("https://agrawalprinters.com/"));
    }

    @AfterClass
    public void tearDown()
    { // Close the browser
        if (driver != null)
        {
            driver.quit();
        }
    }
}
