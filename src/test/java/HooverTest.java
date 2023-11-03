import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Text;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HooverTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void LookingForEnterprise() throws InterruptedException {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $("ul [aria-labelledby=solutions-for-heading]").$(byText("Enterprise")).click();
        $("#hero-section-brand-heading").should(appear, Duration.ofSeconds(5));
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered\n" +
                "developer platform."));
    }
}