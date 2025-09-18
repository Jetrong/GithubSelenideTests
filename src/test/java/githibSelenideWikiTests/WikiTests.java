package githibSelenideWikiTests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class WikiTests {
        @BeforeAll
        static void beforeAll(){
            Configuration.browserSize = "1920x1080";   // нужный размер
            // или
            // Configuration.startMaximized = true;     // работает только в 6.x и ниже
        }

    @Test
    public void wikiTest(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $$("ul a.internal.present").shouldHave(CollectionCondition.itemWithText("Soft assertions"));
        $(withText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("JUnit5 extension"));
    }
}
