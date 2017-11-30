package org.jackzeng.truck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zengxj
 * @create 2017/11/2
 * file read and write best practise
 */
public class FileOps {

    /**
     * for small file better performance
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<String> readIntoMemoryUTF8(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    /**
     * for small contents to write
     *
     * @param contents
     * @param fileName
     * @throws IOException
     */
    public static void wirteAllUTF8(List<String> contents, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.write(path, contents, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    /**
     * for large file reading with Scanner
     *
     * @param fileName
     * @throws IOException
     */
    public static void readFileV1(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (Scanner scanner = new Scanner(path, StandardCharsets.UTF_8.name())) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        }
    }


    /**
     * for large file reading with BufferedReader
     *
     * @param fileName
     * @throws IOException
     */
    public static void readFileV2(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /**
     * for large file writing with BufferedWriter
     *
     * @param fileName
     * @throws IOException
     */
    public static void writeFile(String fileName) throws IOException {
        LocalDateTime now = LocalDateTime.now();
        Path path = Paths.get(fileName);
        Files.deleteIfExists(path);

        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE_NEW,StandardOpenOption.APPEND)) {

            writer.write(now.toString());
            writer.newLine();
        }
    }

    public static void main(String[] args) throws IOException {

        // reading
        String fileName = "C:\\Users\\zengxj\\Desktop\\backup\\AsyncTaskSample.txt";

        List<String> contents = readIntoMemoryUTF8(fileName);
        contents.forEach(System.out::println);

        readFileV1(fileName);
        readFileV2(fileName);

        //write
        String fileNameOut = "C:\\Users\\zengxj\\Desktop\\backup\\AsyncTaskSampleOut.txt";
        wirteAllUTF8(Arrays.asList("123", "345"), fileNameOut);
        writeFile(fileNameOut);
    }


}
