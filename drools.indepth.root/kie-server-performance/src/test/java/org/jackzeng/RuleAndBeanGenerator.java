package org.jackzeng;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by XijinZeng on 2017/5/19.
 */
public class RuleAndBeanGenerator {

    public static void main(String[] args) {
        Path path = Paths.get("myrulefile.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))){
            writer.write("");
            writer.newLine();
            writer.write("我是中文啊");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
