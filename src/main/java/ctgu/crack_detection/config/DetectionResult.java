package ctgu.crack_detection.config;


import lombok.*;
import org.springframework.lang.Nullable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetectionResult implements Comparable<DetectionResult>{
    private Integer number;
    private String fileName;
    private String fileType;
    private String date;
    private String classification;

    @Override
    public int compareTo(DetectionResult detectionResult) {
//        return this.getFileName().compareTo(detectionResult.getFileName());
        return detectionResult.getFileName().compareTo(this.getFileName());
    }
}