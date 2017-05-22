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
        genRuleFiles();
    }

    public static void genBeanFiles(){
        for(int i=2;i<1001;i++){
            Path path = Paths.get("Bean" + String.valueOf(i) + ".java");
            try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
                writer.write(genBeans(i));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String genBeans(int index){
        String javaBean = beanString;
        int i = index;
        javaBean = javaBean.replace("$index",String.valueOf(i));
        javaBean = javaBean.replace("$x1",String.valueOf(i+1));
        javaBean = javaBean.replace("$x2",String.valueOf(i+2));
        javaBean = javaBean.replace("$x3",String.valueOf(i+3));
        javaBean = javaBean.replace("$x4",String.valueOf(i+4));

        return javaBean;
    }

    public static void genRuleFiles() {
        Path path = Paths.get("AutoRules.drl");
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-8"))) {
            //package
            writer.write("package autorule;");

            writer.newLine();
            writer.newLine();

            //imports
            writer.write("import org.jackzeng.autobean.RuleResult;");
            writer.newLine();

            for (int i = 2; i < 1001; i++) {
                writer.write("import org.jackzeng.autobean.Bean" + String.valueOf(i) + ";");
                writer.newLine();
            }
            writer.newLine();
            writer.newLine();


            //dialect
            writer.write("dialect  \"mvel\"");
            writer.newLine();
            writer.newLine();

            //rules
            for (int i = 2; i < 1001; i++) {
                writer.newLine();
                writer.write(genRules(i));
            }
            writer.newLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String genRules(int index){
        String drl = ruleString;
        int i = index;
        drl = drl.replace("$index",String.valueOf(i));
        drl = drl.replace("$x1",String.valueOf(i + 1));
        drl = drl.replace("$x2",String.valueOf(i + 2));
        drl = drl.replace("$x3",String.valueOf(i + 3));
        drl = drl.replace("$x4",String.valueOf(i + 4));

        return drl;
    }

    private static String beanString =
            "package org.jackzeng.autobean;                    " +  "\n" +
             "                                                 " + "\n" +
             "public class Bean$index {                        " + "\n" +
             "    private String field$x1;                     " + "\n" +
             "    private double field$x2;                     " + "\n" +
             "    private boolean field$x3;                    " + "\n" +
             "    private int fild$x4;                         " + "\n" +
             "                                                 " + "\n" +
             "    public String getField$x1() {                " + "\n" +
             "        return field$x1;                         " + "\n" +
             "    }                                            " + "\n" +
             "                                                 " + "\n" +
             "    public void setField$x1(String field$x1) {   " + "\n" +
             "        this.field$x1 = field$x1;                " + "\n" +
             "    }                                            " + "\n" +
             "                                                 " + "\n" +
             "    public double getField$x2() {                " + "\n" +
             "        return field$x2;                         " + "\n" +
             "    }                                            " + "\n" +
             "                                                 " + "\n" +
             "    public void setField$x2(double field$x2) {   " + "\n" +
             "        this.field$x2 = field$x2;                " + "\n" +
             "    }                                            " + "\n" +
             "                                                 " + "\n" +
             "    public boolean isField$x3() {                " + "\n" +
             "        return field$x3;                         " + "\n" +
             "    }                                            " + "\n" +
             "                                                 " + "\n" +
             "    public void setField$x3(boolean field$x3) {  " + "\n" +
             "        this.field$x3 = field$x3;                " + "\n" +
             "    }                                            " + "\n" +
             "                                                 " + "\n" +
             "    public int getFild$x4() {                    " + "\n" +
             "        return fild$x4;                          " + "\n" +
             "    }                                            " + "\n" +
             "                                                 " + "\n" +
             "    public void setFild$x4(int fild$x4) {        " + "\n" +
             "        this.fild$x4 = fild$x4;                  " + "\n" +
                    "}}";


    private static String ruleString =
            "rule \"autorule$index\"                                                                              " + "\n" +
                    "    when                                                                                     " + "\n" +
                    "    $b$index : Bean$index(field$x1 == \"String\",field$x2 >= 100,field$x3 == true,fild$x4 == 100)    " + "\n" +
                    "    then                                                                                     " + "\n" +
                    "    RuleResult result = new RuleResult();                                                    " + "\n" +
                    "    result.setDescription(\"autorule$index fired\");                                         " + "\n" +
                    "    result.setRuleName(\"autorule$index\");                                                  " + "\n" +
                    "    result.setRuleResult(true);                                                              " + "\n" +
                    "    result.setScore(100);                                                                    " + "\n" +
                    "                                                                                             " + "\n" +
                    "    System.out.println(result.toString());                                                   " + "\n" +
                    "end                                                                                          " + "\n";
}
