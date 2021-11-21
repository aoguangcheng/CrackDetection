package ctgu.crack_detection.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class FileNameTest {

    @Test
    void getFileName() {
        FileName fileName = new FileName();
        fileName.setPath("C://Users/AoGua/IdeaProjects/imageUpload");
        fileName.getFileName();
    }
}