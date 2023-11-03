import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragNDrop {
    @BeforeAll
    static void BeforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }
    @Test
    void DragNDropActionTest(){
        open("/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
        Selenide.actions().dragAndDropBy($("#column-a"), 200,0).build().perform();
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
    @Test
    void DragNDropTest(){
        open("/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
        $("div#column-a").dragAndDrop((DragAndDropOptions) $("div#column-b"));
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
