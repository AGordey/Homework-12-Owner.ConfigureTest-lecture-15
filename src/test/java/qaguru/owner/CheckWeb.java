package qaguru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qaguru.owner.config.WEB;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckWeb {

    // Тест проходит т.к объявляют  "LocalOrSelenoid" = "Local"
    @Test
    @DisplayName("Считывание с данными для локального запуска")
    public void TestingLocalWeb() {
        System.setProperty("LocalOrSelenoid", "Local");
        WEB config = ConfigFactory
                .create(WEB.class, System.getProperties());

        assertThat(config.browser()).isEqualTo("Chrome");
        assertThat(config.version()).isEqualTo("101");
        assertThat(config.host()).isEqualTo("https://localhost:4444/wd/hub");
    }
    // Тест проходит т.к объявляют  "LocalOrSelenoid" = "Selenoid"
    @Test
    @DisplayName("Считывание с данными для удаленного запуска")
    public void TestingRemoteWeb() {
        System.setProperty("LocalOrSelenoid", "Selenoid");
        WEB config = ConfigFactory
                .create(WEB.class, System.getProperties());

        assertThat(config.browser()).isEqualTo("Chrome");
        assertThat(config.version()).isEqualTo("100");
        assertThat(config.host()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}

