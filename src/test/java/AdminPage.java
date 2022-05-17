import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminPage extends PageBase {
    public static By path = By.xpath("//div[@class='menu']//a[@href='/index.php/admin/viewAdminModule']");
    public static String head = "System Users";

    AdminPage(WebDriver driver) {
        super(driver);
    }

    private final By userNameBox = By.id("searchSystemUser_userName");
    private final By searchButton = By.className("searchbutton");
    private final By resultTable = By.id("resultTable");

    public void searchUser() {
        waitAndReturnElement(userNameBox).sendKeys("Admin");
        waitAndReturnElement(searchButton).click();
    }

    public boolean isSearchCorrect() {
        List<WebElement> result = waitAndReturnElement(resultTable).findElements(By.tagName("a"));
        return result.get(result.size() - 1).getText().equals("Admin");
    }
}
