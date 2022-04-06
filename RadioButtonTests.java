import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class RadioButtonTests {
    public SoftAssert softAssert;
    @BeforeTest
    void setUp() {
        ConfigTests config = new ConfigTests(); config.config();
        baseUrl = " https://demoqa.com";
        holdBrowserOpen = true;
        reportsFolder = "C:\\Users\\User\\Desktop\\homew0rk" +
                "\\selenide_\\src\\main\\resources\\RadioButtonFailedTests";
    }
    @Test
    void test2() {
        open("/radio-button");
        selectYesOption();
        softAssert.assertEquals($("#yesRadio").isSelected(), false);
        assertNoOption();
    }
    void selectYesOption () {
        $(By.xpath("//label[@for='yesRadio']")).click();
    }
    void assertNoOption () {
        softAssert.assertEquals($("#noRadio").isEnabled(),true);
    }
}
