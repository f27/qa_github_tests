package uitest.github;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitest.AbstractBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RepoPageTests extends AbstractBase {

    @Test
    @DisplayName("/selenide/selenide has Wiki->Soft assertions->JUnit5 code")
    void wikiInSelenideTest(){
        open("/selenide/selenide");

        $("span[data-content = 'Wiki']").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $("#wiki-body").shouldHave(text("Using JUnit5"), text("@ExtendWith"));
    }

    @Test
    @DisplayName("/f27/qa_github_tests doesn't have Wiki")
    void wikiInMyProjectTest(){
        open("/f27/qa_github_tests");

        $("span[data-content = 'Wiki']").shouldNotBe(visible);
        $("a[title = '.gitignore']").shouldBe(visible);
    }

    @Test
    @DisplayName("Selenide repo has Issue tab and amount of issues correct")
    void issuesInSelenideTest(){
        open("/selenide/selenide");

        $("span[data-content = 'Issues']").click();
        $(".btn.btn-primary").shouldBe(visible).shouldHave(text("New issue"));
        $("[data-tab-item = 'i1issues-tab'] span.Counter").shouldHave(text(String.valueOf($$(".Box-row").size())));

    }

    @Test
    @DisplayName("Andrei Solntsev in first position of contributors")
    void contributorsTest(){
        open("/selenide/selenide");

        $("ul li [data-hovercard-type = 'user']").hover();
        $(".Popover .Link--primary").shouldHave(text("Andrei Solntsev"));
        //sleep(5000);
    }
}
