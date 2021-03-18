package uitest.github;

import org.junit.jupiter.api.Test;
import uitest.AbstractBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends AbstractBase {

    @Test
    void searchInRepoTest(){
        open("/selenide/selenide");

        $(byName("q")).setValue("dragAndDropTo");
        $$("#jump-to-results li").findBy(text("In this repository")).click();
        $$(".width-full").findBy(text("public class DragAndDropTo")).parent().parent().click();
        $("[itemprop = 'text']").shouldHave(text("public class DragAndDropTo"));
    }

    @Test
    void searchInOrgTest(){
        open("/selenide/selenide");

        $(byName("q")).setValue("appium");
        $$("#jump-to-results li").findBy(text("In this organization")).click();
        $(".repo-list a[href = '/selenide/selenide-appium']").click();
        $("#readme").shouldHave(text("Selenide adaptor for Appium framework"));
    }
}
