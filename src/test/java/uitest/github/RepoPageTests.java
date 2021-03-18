package uitest.github;

import org.junit.jupiter.api.Test;
import uitest.AbstractBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RepoPageTests extends AbstractBase {

    @Test
    void wikiInSelenideTest(){
        open("/selenide/selenide");

        $("span[data-content = 'Wiki']").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5"), text("@ExtendWith"));
    }

    @Test
    void wikiInMyProjectTest(){
        open("/f27/qa_github_tests");

        $("span[data-content = 'Wiki']").shouldNotBe(visible);
        $("a[title = '.gitignore']").shouldBe(visible);
    }

    @Test
    void issuesInSelenideTest(){
        open("/selenide/selenide");

        $("span[data-content = 'Issues']").click();
        $(".btn.btn-primary").shouldBe(visible).shouldHave(text("New issue"));
        $("[data-tab-item = 'i1issues-tab'] span.Counter").shouldHave(text(String.valueOf($$(".Box-row").size())));

    }

    @Test
    void contributorsTest(){
        open("/selenide/selenide");

        $("ul li [data-hovercard-type = 'user']").hover();
        $(".Popover .Link--primary").shouldHave(text("Andrei Solntsev"));
        //sleep(5000);
    }
}
