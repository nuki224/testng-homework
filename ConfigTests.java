import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Configuration.browserSize;

public class ConfigTests {
    @BeforeSuite
    void config () {
        Configuration.assertionMode = SOFT;
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        Configuration.timeout = 6000;
        browserSize = null;
    }
}
