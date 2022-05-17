import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeePage extends PageBase {
    public static By path = By.xpath("//div[@id='mainMenu']//a[@id='menu_pim_viewPimModule']");
    public static String head = "Employee Information";

    EmployeePage(WebDriver driver) {
        super(driver);
    }
}

