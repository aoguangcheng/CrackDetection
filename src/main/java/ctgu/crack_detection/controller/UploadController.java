package ctgu.crack_detection.controller;

import ctgu.crack_detection.config.BatWriter;
import ctgu.crack_detection.config.CommandExecute;
import ctgu.crack_detection.config.UploadConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

@Controller
public class UploadController {
    @Value("${path.download.imagesA.windows}")
    private String pathDownloadImagesAWindows;
    @Value("${path.download.imagesA.linux}")
    private String pathDownloadImagesALinux;

    @Value("${path.download.imagesB.windows}")
    private String pathDownloadImagesBWindows;
    @Value("${path.download.imagesB.linux}")
    private String pathDownloadImagesBLinux;

    @Value("${path.download.imagesC.windows}")
    private String pathDownloadImagesCWindows;
    @Value("${path.download.imagesC.linux}")
    private String pathDownloadImagesCLinux;

    @Value("${path.download.imagesD.windows}")
    private String pathDownloadImagesDWindows;
    @Value("${path.download.imagesD.linux}")
    private String pathDownloadImagesDLinux;

    @Value("${path.download.videosA.windows}")
    private String pathDownloadVideosAWindows;
    @Value("${path.download.videosA.linux}")
    private String pathDownloadVideosALinux;

    @Value("${path.download.videosB.windows}")
    private String pathDownloadVideosBWindows;
    @Value("${path.download.videosB.linux}")
    private String pathDownloadVideosBLinux;

    @Value("${path.upload.images.windows}")
    private String pathUploadImagesWindows;
    @Value("${path.upload.images.linux}")
    private String pathUploadImagesLinux;

    @Value("${path.upload.videos.windows}")
    private String pathUploadVideosWindows;
    @Value("${path.upload.videos.linux}")
    private String pathUploadVideosLinux;

    @PostMapping("/uploadVideos")
    public String uploadVideos(@RequestParam("file") MultipartFile file, Model model, HttpSession session){
        //如果上传的是空文件则返回
        if(file.getSize() < 10){
            return "redirect:/home";
        }
        UploadConfig uploadConfig;
        //如果操作系统是Windows,反斜线
        if (System.getProperty("file.separator")=="\\"){
            uploadConfig= new UploadConfig(pathUploadVideosWindows,"","");
        }
        else {
            uploadConfig= new UploadConfig(pathUploadVideosLinux,"","");
        }
        uploadConfig.uploadFile(file, "videos");
        //将上传的视频文件名存储在session中
//        获取session对象的方法：
//        User user = (User)session.getAttribute("user");
        session.setAttribute("video",uploadConfig.getFileName());
        List<String> content = new ArrayList<String>();
        content.add("C:");
        content.add("cd C::\\faster-rcnn-keras-master");
        content.add("call conda activate bridge");
        content.add("call python C://faster-rcnn-keras-master//video.py C://Users//AoGua//IdeaProjects//videoUpload//"+ uploadConfig.getFileName() +" C://Users//AoGua//IdeaProjects//videosClassA// "+uploadConfig.getFileName().substring(0,uploadConfig.getFileName().length() - 4));
        content.add("exit");
        System.out.println(uploadConfig.getFileName());
        String path = "C:\\Users\\AoGua\\IdeaProjects\\exec.bat";
        BatWriter batWriter = new BatWriter(content,path);
        batWriter.batWriter();
        CommandExecute commandExecute = new CommandExecute();
        commandExecute.executeCommand("cmd.exe /k start "+path);
        content.add("exit");
        System.out.println(commandExecute.toString());
        return "redirect:/home";
    }

    @PostMapping("/uploadImages")
    public String uploadFile(@RequestParam("file") MultipartFile file, Model model, HttpSession session){
        if(file.getSize() < 1){
            return "redirect:/home";
        }
        UploadConfig uploadConfig;
        //如果操作系统是Windows,反斜线
        if (System.getProperty("file.separator")=="\\"){
            uploadConfig= new UploadConfig(pathUploadImagesWindows,"","");
        }
        else {
            uploadConfig= new UploadConfig(pathUploadImagesLinux,"","");
        }
        uploadConfig.uploadFile(file, "images");
        //将上传的图片文件名存储在session中
        session.setAttribute("image",uploadConfig.getFileName());
//        目标识别的bat文件
        List<String> content = new ArrayList<String>();
        content.add("C:");
        content.add("cd C:\\faster-rcnn-keras-master");
        content.add("call conda activate bridge");
        content.add("call python C://faster-rcnn-keras-master//predictimg.py C://Users//AoGua//IdeaProjects//imageUpload//"+uploadConfig.getFileName() + " " + pathDownloadImagesAWindows + uploadConfig.getFileName());
        content.add("exit");
        String pathDetection = "C:\\Users\\AoGua\\IdeaProjects\\execDetection.bat";
        BatWriter batWriterDetection = new BatWriter(content,pathDetection);
        batWriterDetection.batWriter();
        CommandExecute commandExecute = new CommandExecute();
        commandExecute.executeCommand("cmd.exe /c start "+pathDetection);
        content.clear();
//        分类识别bat文件
        content.add("C:");
        content.add("cd C:\\Users\\AoGua\\Desktop\\LearnMaterials\\test_classification");
        content.add("call conda activate bridge");
        content.add("call python C://Users//AoGua//Desktop//LearnMaterials//test_classification//predictimg.py C://Users//AoGua//IdeaProjects//imageUpload//" + uploadConfig.getFileName() + "  C://Users//AoGua//IdeaProjects//result.json");
        content.add("exit");
        String pathClassification = "C:\\Users\\AoGua\\IdeaProjects\\execClassification.bat";
        BatWriter batWriterClassification = new BatWriter(content,pathClassification);
        batWriterClassification.batWriter();
        commandExecute.executeCommand("cmd.exe /c start "+pathClassification);
        System.out.println(commandExecute.toString());
        return "redirect:/home";
    }
}
