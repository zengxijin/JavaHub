package org.jackzeng.truck;

import java.io.*;

/**
 * @author zengxj
 * @create 2017/11/2
 */
public class MainApp {

    public static void main(String[] args) throws IOException {
        fileWriter();
        //fileRead();
    }

    private static void fileRead() throws IOException {
        String fileName = "C:\\Users\\zengxj\\Desktop\\backup\\AsyncTaskSample.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        }
    }

    private static void fileWriter() throws IOException {
        String fileName = "C:\\Users\\zengxj\\Desktop\\backup\\AsyncTaskSampleOut.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            writer.newLine();
            writer.write("123");
            writer.newLine();
            writer.write("123");
            writer.newLine();
            writer.write("123");
        }
    }
}
