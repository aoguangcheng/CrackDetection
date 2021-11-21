package ctgu.crack_detection.config;

import lombok.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FileName {
    //文件夹的路径
    private String path;
    private List<String> fileList = new ArrayList<String>();

    public void getFileName(){
        File file = new File(this.path);
        if(!file.exists()){
            System.out.println("this directory is not exist!!");
            return ;
        }
        File fileList[] = file.listFiles();
        for(int i = 0;i < fileList.length; i++){
            this.fileList.add(fileList[i].getName());
        }
        System.out.println(this.toString());
    }
}
