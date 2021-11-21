package ctgu.crack_detection.config;


import com.sun.scenario.effect.impl.prism.ps.PPSBlend_ADDPeer;
import lombok.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommandExecute {
    //执行的命令
    private String commandString;
    //获取执行命令的结果
    private List<String> commandResult = new ArrayList<String>();

    public void executeCommand(String commandString){
        this.commandString = commandString;
        BufferedReader bufferedReader = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(this.commandString);
//            Runtime.getRuntime().exec(this.commandString);
//            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line = null;
//            while ((line = bufferedReader.readLine()) != null){
//                this.commandResult.add(line);
//            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
//            if(bufferedReader == null){
//                try {
//                    bufferedReader.close();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
