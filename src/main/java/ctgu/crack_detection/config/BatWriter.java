package ctgu.crack_detection.config;

import lombok.*;
import sun.awt.geom.AreaOp;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BatWriter {
    //把content中的每一个字符串一行一行的写入bat文件
    private List<String> content = new ArrayList<String>();
    //写入文件的路径
    private String path;

    public void batWriter(){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.path);
            for(int i = 0; i < this.content.size();i++)
            {
                fileWriter.write(this.content.get(i) + "\n");
            }
            fileWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
