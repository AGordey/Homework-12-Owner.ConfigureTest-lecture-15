package qaguru.owner.config;

import com.sun.jna.WString;
import org.aeonbits.owner.Config;
@Config.Sources({
        "file:/tmp/secretAPI.properties",
        "classpath:API.properties"
})
public interface APIconfig extends Config {

    @Key("baseurl")
    @DefaultValue("https://www.google.com/")
    String baseurl();

    @Key("token")
    @DefaultValue("A9cFT51hyLvFdafqzTF2J0uIhioi9p0acbiDm")
    String token();

}
