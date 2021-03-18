package uitest.github;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import uitest.AbstractBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTests extends AbstractBase {

    @Test
    @DisplayName("Search 'selenide'")
    void mainPageSearchTest() {
        open("/");

        $(byName("q")).setValue("selenide").pressEnter();
        $(".repo-list a[href = '/selenide/selenide']").shouldBe(visible);
    }

    @Test
    @DisplayName("Input and button for email sign up exist")
    void signUpViaEmailExistTest() {
        open("/");

        $("#user_email_control").shouldBe(visible);
        $("form[action = '/join'] button").shouldHave(text("Sign up for GitHub"));
    }

    @Test
    @DisplayName("Sign in button exist")
    void signInButtonExistTest() {
        open("/");

        $$("a.HeaderMenu-link").findBy(text("Sign in")).click();
        $("h1").shouldHave(text("Sign in to GitHub"));
    }

    @Test
    @DisplayName("Sign up button exist")
    void signUpButtonExistTest() {
        open("/");

        $$("a.HeaderMenu-link").findBy(text("Sign up")).click();
        $("h1").shouldHave(text("Create your account"));
    }
}
