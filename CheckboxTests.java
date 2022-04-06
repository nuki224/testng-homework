import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;
public class CheckboxTests {
    public SoftAssert softAssert;
    @BeforeTest
    void setUp() {
        ConfigTests config = new ConfigTests();
        config.config();
        baseUrl = "http://the-internet.herokuapp.com";
        Configuration.reportsFolder = "C:\\Users\\User\\Desktop\\homew0rk" +
                "\\selenide_\\src\\main\\resources\\CheckboxFailedTests";
        holdBrowserOpen = true;
    }
    @Test
    public void test1() {
        softAssert = new SoftAssert();
        open("/checkboxes");
        uncheckCheckedCheckbox($$(By.tagName("input")));
        softAssert.assertEquals($(By.xpath("//input[@type='checkbox'][2]")).isSelected(), true);
        checkUncheckedCheckbox($$(By.tagName("input")));
        softAssert.assertEquals($(By.xpath("//input[@type='checkbox'][1]")).isSelected(), false);
    }
    void uncheckCheckedCheckbox(ElementsCollection element) {
        for (SelenideElement checkbox : element) {
            if (checkbox.isSelected()) {checkbox.click();}
        }
    }
    void checkUncheckedCheckbox(ElementsCollection element) {
        for (SelenideElement checkbox : element) {
            if(!checkbox.isSelected()) {checkbox.click();}
        }
    }
}

