import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Dashboard extends PageBase {
    public static By path = By.xpath("//div[@id='mainMenu']//a[@id='menu_dashboard_index']");
    public static String head = "Employee Distribution by Subunit";
    public static String hoverText = "Employee Distribution by Subunit";

    public Dashboard(WebDriver driver) {
        super(driver);
    }

    final private By userDropDown = By.xpath("//div//a[@class='panelTrigger']");
    final private By logoutButton = By.xpath("//div[@class='panelContainer']/ul/li[3]/a");
    final private By adminPage = By.xpath("//div[@class='menu']//a[@href='/index.php/admin/viewAdminModule']");

    public void logout() {
        waitAndReturnElement(userDropDown).click();
        waitAndReturnElement(logoutButton).click();
    }

    public AdminPage clickAdminPage() {
        waitAndReturnElement(adminPage).click();
        return new AdminPage(driver);
    }

    public void hoverToAdminPage() {
        Actions builder = new Actions(driver);
        WebElement target = waitAndReturnElement(AdminPage.path);
        builder.moveToElement(target).perform();
    }
}
