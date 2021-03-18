package uitest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class AbstractBase {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }
}
