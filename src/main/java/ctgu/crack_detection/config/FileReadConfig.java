package ctgu.crack_detection.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileReadConfig implements WebMvcConfigurer {
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

    @Value("${path.upload.videos.windows}")
    private String pathUploadVideosWindows;
    @Value("${path.upload.videos.linux}")
    private String pathUploadVideosLinux;

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

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //使用目录的方式映射本地文件夹
        registry.addResourceHandler("/imagesClassA/**")
                .addResourceLocations("file:" + pathDownloadImagesAWindows)
                .addResourceLocations("file:"+ pathDownloadImagesALinux);
        registry.addResourceHandler("/imagesClassB/**")
                .addResourceLocations("file:" + pathDownloadImagesBWindows)
                .addResourceLocations("file:"+ pathDownloadImagesBLinux);
        registry.addResourceHandler("/imagesClassC/**")
                .addResourceLocations("file:" + pathDownloadImagesCWindows)
                .addResourceLocations("file:"+ pathDownloadImagesCLinux);
        registry.addResourceHandler("/imagesClassD/**")
                .addResourceLocations("file:" + pathDownloadImagesDWindows)
                .addResourceLocations("file:"+ pathDownloadImagesDLinux);
        registry.addResourceHandler("/videosClassA/**")
                .addResourceLocations("file:" + pathDownloadVideosAWindows)
                .addResourceLocations("file:"+ pathDownloadVideosALinux);
        registry.addResourceHandler("/videosClassB/**")
                .addResourceLocations("file:" + pathDownloadVideosBWindows)
                .addResourceLocations("file:"+ pathDownloadVideosBLinux);
        registry.addResourceHandler("/videoUpload/**")
                .addResourceLocations("file:"+pathUploadVideosWindows)
                .addResourceLocations("file:"+pathUploadVideosLinux);
        registry.addResourceHandler("/imageUpload/**")
                .addResourceLocations("file:"+pathUploadImagesWindows)
        .addResourceLocations("file:"+pathUploadImagesLinux);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
