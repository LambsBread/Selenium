import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DirectoryPage extends PageBase {
    public static By path = By.xpath("//div[@id='mainMenu']//a[@id='menu_directory_viewDirectory']");
    public static String head = "Search Directory";

    DirectoryPage(WebDriver driver) {
        super(driver);
    }
}

