package ctgu.crack_detection.controller;


import ctgu.crack_detection.config.DetectionResult;
import ctgu.crack_detection.config.FileName;
import ctgu.crack_detection.config.JsonRead;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.File;

@Controller
public class DownloadController
{
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

    @RequestMapping({"/home","/","/index"})
    public String toHome(Model model){
        JsonRead jsonRead = new JsonRead();
        jsonRead.setPath("C:\\Users\\AoGua\\IdeaProjects\\result.json");
        jsonRead.readJson();
        model.addAttribute("detectionResultList",jsonRead.getDetectionResults());
        return "/home";
    }

    @RequestMapping("/toClassA")
    public String toClassAPage(Model model){
        FileName fileName = new FileName();
        if(System.getProperty("file.separator").equals("\\")){
            fileName.setPath(pathDownloadImagesAWindows);
        }
        else {
            fileName.setPath(pathDownloadImagesALinux);
        }
        fileName.getFileName();
        model.addAttribute("imagesSrc",fileName.getFileList());
        return "/classA";
    }

    @RequestMapping("/toClassB")
    public String toClassB(Model model){
        FileName fileName = new FileName();
        if(System.getProperty("file.separator").equals("\\")){
            fileName.setPath(pathDownloadImagesBWindows);
        }
        else {
            fileName.setPath(pathDownloadImagesBLinux);
        }
        fileName.getFileName();
        model.addAttribute("imagesSrc",fileName.getFileList());
        return "/classB";
    }

    @RequestMapping("/toClassC")
    public String toClassC(Model model){
        FileName fileName = new FileName();
        if(System.getProperty("file.separator").equals("\\")){
            fileName.setPath(pathDownloadImagesCWindows);
        }
        else {
            fileName.setPath(pathDownloadImagesCLinux);
        }
        fileName.getFileName();
        model.addAttribute("imagesSrc",fileName.getFileList());
        return "/classC";
    }
    @RequestMapping("/toClassD")
    public String toClassD(Model model){
        FileName fileName = new FileName();
        if(System.getProperty("file.separator").equals("\\")){
            fileName.setPath(pathDownloadImagesDWindows);
        }
        else {
            fileName.setPath(pathDownloadImagesDLinux);
        }
        fileName.getFileName();
        model.addAttribute("imagesSrc",fileName.getFileList());
        return "/classD";
    }

    @RequestMapping("/toVideoPageA")
    public String toVideoPageA(Model model){
        FileName fileName = new FileName();
        if(System.getProperty("file.separator").equals("\\")){
            fileName.setPath(pathDownloadVideosAWindows);
        }
        else {
            fileName.setPath(pathDownloadVideosALinux);
        }
        fileName.getFileName();
        model.addAttribute("videosSrc",fileName.getFileList().get(0));
        return "/videoPageA";
    }
    @RequestMapping("/toVideoPageB")
    public String toVideoPageB(Model model){
        FileName fileName = new FileName();
        if(System.getProperty("file.separator").equals("\\")){
            fileName.setPath(pathDownloadVideosBWindows);
        }
        else {
            fileName.setPath(pathDownloadVideosBLinux);
        }
        fileName.getFileName();
        model.addAttribute("videosSrc",fileName.getFileList().get(0));
        return "/videoPageB";
    }

}
