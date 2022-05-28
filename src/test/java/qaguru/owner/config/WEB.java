package qaguru.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${LocalOrSelenoid}.properties")

public interface WEB extends Config {

        @Key("browser.name")
        @DefaultValue("Chrome")
        String browser();

        @Key("browser.version")
        @DefaultValue("100")
        String version();

        @Key("host")
        @DefaultValue("http://localhost:4444/wd/hub")
        String host();

}
