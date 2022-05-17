import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoPage extends PageBase {
    public static By path = By.xpath("//div[@id='mainMenu']//a[@id='menu_pim_viewMyDetails']");
    public static String head = "Personal Details";
    public static By file1 = By.xpath("//div[@id='attachmentList']//a[@href='/index.php/pim/viewAttachment/empNumber/7/attachId/2']");
    public static By file2 = By.xpath("//div[@id='attachmentList']//a[@href='/index.php/pim/viewAttachment/empNumber/7/attachId/4']");

    InfoPage(WebDriver driver) {
        super(driver);
    }
}
