package uitest.github;

import org.junit.jupiter.api.Test;
import uitest.AbstractBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTests extends AbstractBase {

    @Test
    void mainPageSearch() {
        open("/");

        $(byName("q")).setValue("selenide").pressEnter();
        $(".repo-list a[href = '/selenide/selenide']").shouldBe(visible);
    }

    @Test
    void signUpViaEmailExist() {
        open("/");

        $("#user_email_control").shouldBe(visible);
        $("form[action = '/join'] button").shouldHave(text("Sign up for GitHub"));
    }

    @Test
    void signInButtonExist() {
        open("/");

        $$("a.HeaderMenu-link").findBy(text("Sign in")).click();
        $("h1").shouldHave(text("Sign in to GitHub"));
    }

    @Test
    void signUpButtonExist() {
        open("/");

        $$("a.HeaderMenu-link").findBy(text("Sign up")).click();
        $("h1").shouldHave(text("Create your account"));
    }
}
