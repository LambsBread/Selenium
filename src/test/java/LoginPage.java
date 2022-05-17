import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    public static By path = By.xpath("/");
    public static String head = "LOGIN Panel";

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://opensource-demo.orangehrmlive.com");
    }

    private final By nameInput = By.name("txtUsername");
    private final By passInput = By.name("txtPassword");
    private final By submit = By.name("Submit");

    public Dashboard login() {
        waitAndReturnElement(nameInput).sendKeys("Admin");
        waitAndReturnElement(passInput).sendKeys("admin123");
        waitAndReturnElement(submit).click();
        return new Dashboard(this.driver);
    }

}
