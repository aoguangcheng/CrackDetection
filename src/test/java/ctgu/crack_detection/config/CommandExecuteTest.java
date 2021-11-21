package ctgu.crack_detection.config;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class CommandExecuteTest {

    @Test
    void executeCommand() {
        List<String> content = new ArrayList<String>();
        content.add("D:");
        content.add("cd D:\\faster-rcnn-keras-master");
        content.add("call conda activate bridge");
        content.add("call python D://faster-rcnn-keras-master//predict.py C://Users//AoGua//IdeaProjects//imageUpload");
        String path = "C:\\Users\\AoGua\\IdeaProjects\\imagesClassA\\exec.bat";
        BatWriter batWriter = new BatWriter(content,path);
        batWriter.batWriter();
        CommandExecute commandExecute = new CommandExecute();
        commandExecute.executeCommand("cmd.exe /k start "+path);
        System.out.println(commandExecute.toString());
    }
}