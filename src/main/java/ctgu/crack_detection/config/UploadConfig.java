package ctgu.crack_detection.config;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UploadConfig {
    private String absoluteFilePath;
    private String relativeFilePath;
    private String fileName;
    public void uploadFile(MultipartFile file, String type){
        if(type == "images") {
            this.fileName = "IMAGE-" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
                    .format(new Date()) + ".jpg";
        }
        else{
            this.fileName = "VIDEO-" + new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss")
                    .format(new Date()) + ".mp4";
        }
        //文件上传后存储的路径名
        String path = this.absoluteFilePath;
        File fileStore = new File(path,this.fileName);
        //如果fileStore的上一级文件夹不存在则创建
        if(!fileStore.getParentFile().exists()) {
            fileStore.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(path+File.separator+fileName));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
