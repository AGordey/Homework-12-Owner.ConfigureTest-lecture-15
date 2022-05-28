package qaguru.owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qaguru.owner.config.APIconfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckAPI {

    @Test
    @DisplayName("Тест на передачу параметров через файл на файловой системе")
    public void testClasspathRemote() throws IOException {
        String content = "baseurl=https://yandex.by/\ntoken=123123123HHH";
        Path propsPath = Paths.get("/tmp/secretAPI.properties");
        //Для падения теста закомментируй строку ниже
        Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));

        APIconfig config = ConfigFactory
                .create(APIconfig.class, System.getProperties());
        assertThat(config.baseurl()).isEqualTo("https://yandex.by/");
        assertThat(config.token()).isEqualTo("123123123HHH");

        Files.delete(propsPath);
    }

     // Тест проходит, при отсутствии файла на локальном диске - для падения закоментируй строку 31
    @Test
    @DisplayName("Тест на передачу параметров через системную проперти")
    public void testClasspathLocal() {

        APIconfig config = ConfigFactory.create(APIconfig.class, System.getProperties());

        assertThat(config.baseurl()).isEqualTo("https://www.google.com/");
        assertThat(config.token()).isEqualTo("A9cFT51hyLvFdafqzTF2J0uIhioi9p0acbiDm");
    }


}