package ctgu.crack_detection.config;

import com.alibaba.fastjson.JSON;
import lombok.*;

import javax.xml.transform.dom.DOMResult;
import java.io.*;
import java.util.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class JsonRead {
    String path;
    String jsonString;
    List<DetectionResult> detectionResults = new ArrayList<DetectionResult>();

    public void readJson(){
        try {
            String jsonString = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(this.path)));
            String s = null;
            while ((s = bufferedReader.readLine()) != null){
                jsonString += "\n" + s;
            }
            this.jsonString = jsonString;
            bufferedReader.close();
            HashMap hashMap = JSON.parseObject(this.jsonString,HashMap.class);
            for(Object key : hashMap.keySet())
            {
                System.out.println(key + " " + hashMap.get(key));
                String keyString = key.toString();
                int index = keyString.length();
                while (index-- != -1){
                    if (keyString.charAt(index) == '/')
                    {
                        break;
                    }
                }
                String fileName = keyString.substring(index + 1,key.toString().length());
                DetectionResult detectionResult = new DetectionResult();
                detectionResult.setFileName(fileName);
                detectionResult.setFileType(fileName.charAt(0) == 'I' ? "IMAGE" : "VIDEO" );
                detectionResult.setDate(fileName.substring(6, fileName.length() - 4));
                detectionResult.setClassification(hashMap.get(key).toString().equals("1") ? "dangerous":"slight");
                this.detectionResults.add(detectionResult);
            }
            Collections.sort(this.detectionResults);
            int i = 0;
            for(DetectionResult detectionResult : detectionResults){
                i++;
                detectionResult.setNumber(i);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
