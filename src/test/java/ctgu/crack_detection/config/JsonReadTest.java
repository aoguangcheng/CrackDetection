package ctgu.crack_detection.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class JsonReadTest {

    @Test
    void readJson() {
        JsonRead jsonRead = new JsonRead();
        jsonRead.setPath("C:\\Users\\AoGua\\IdeaProjects\\result.json");
        jsonRead.readJson();
        System.out.println(jsonRead.toString());
    }
}