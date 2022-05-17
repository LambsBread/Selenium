import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class SeleniumTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HashMap<By, String> pages;

    private WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    private String getBodyText() {
        WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
        return bodyElement.getText();
    }

    public Dashboard login() {
        LoginPage loginPage = new LoginPage(this.driver);
        assertTrue(getBodyText().contains(LoginPage.head));

        Dashboard dashboard = loginPage.login();
        assertTrue(getBodyText().contains(Dashboard.head));
        return dashboard;
    }

    private void _initPages() {
        pages = new HashMap<>();
        pages.put(AdminPage.path, AdminPage.head);
        pages.put(Dashboard.path, Dashboard.head);
        pages.put(EmployeePage.path, EmployeePage.head);
        pages.put(DirectoryPage.path, DirectoryPage.head);
        pages.put(MaintenancePage.path, MaintenancePage.head);
        pages.put(InfoPage.path, InfoPage.head);
    }

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", System.getProperty("user.dir"));
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        _initPages();
    }

    @Test
    public void loginTest() {
        login();
    }

    @Test
    public void logoutTest() {
        Dashboard dashboard = login();
        dashboard.logout();
        assertTrue(getBodyText().contains(LoginPage.head));
    }

    @Test
    public void searchUserTest() {
        Dashboard dashboard = login();
        AdminPage adminPage = dashboard.clickAdminPage();
        adminPage.searchUser();
        assertTrue(adminPage.isSearchCorrect());
    }

    @Test
    public void loadPagesTest() {
        login();
        for (Map.Entry<By, String> page : pages.entrySet()) {
            waitAndReturnElement(page.getKey()).click();
            assertTrue(getBodyText().contains(page.getValue()));
        }
    }

    @Test
    public void hoverTest() {
        Dashboard dashboard = login();
        dashboard.hoverToAdminPage();
        assertTrue(getBodyText().contains(Dashboard.hoverText));
    }

    @Test
    public void backButtonTest() {
        Dashboard dashboard = login();
        dashboard.clickAdminPage();
        assertTrue(getBodyText().contains(AdminPage.head));

        driver.navigate().back();
        assertTrue(getBodyText().contains(Dashboard.head));
    }

    @Test
    public void downloadTest() throws InterruptedException {
        login();
        waitAndReturnElement(InfoPage.path).click();
        assertTrue(getBodyText().contains(InfoPage.head));

        waitAndReturnElement(InfoPage.file1).click();
        waitAndReturnElement(InfoPage.file2).click();
        Thread.sleep(4000);

        File f = new File(System.getProperty("user.dir") + "\\3.png");
        File f2 = new File(System.getProperty("user.dir") + "\\4.png");
        assertTrue(f.exists());
        assertTrue(f2.exists());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
