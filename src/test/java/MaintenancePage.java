import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MaintenancePage extends PageBase {
    public static By path = By.xpath("//div[@id='mainMenu']//a[@id='menu_maintenance_purgeEmployee']");
    public static String head = "Purge Employee Records";

    MaintenancePage(WebDriver driver) {
        super(driver);
    }
}