package org.jackzeng.truck;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zengxj
 * @create 2017/11/16
 */
public class CSVOps {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\zengxj\\Documents\\WeChat Files\\zengxijin\\Files\\S421和S423(1)\\S421和S423\\";

        List<String> files = getFiles(filePath);

        String outFile = "csvMerge.csv";

        CsvWriter writer = new CsvWriter(outFile,',', Charset.forName("GBK"));
        String[] headers = {"序号","终端编号","交易时间","卡号","交易金额","红利收入","红利支出","小费","手续费","分期付款手续费","净收金额","交易检索号","交易类型","交易日期"};
        writer.writeRecord(headers);

        files.forEach(file -> {
            System.out.println(file);

            CsvReader csvReader = null;
            File fileHandle = null;
            InputStreamReader isr = null;
            try {
                // 创建CSV读对象
                fileHandle = new File(filePath + file);
                isr = new InputStreamReader(new FileInputStream(fileHandle),"GBK");
                csvReader = new CsvReader(isr);

                // 读表头
                csvReader.readHeaders();
                while (csvReader.readRecord()) {
                    // 读一整行
                    String line = csvReader.getRawRecord();
                    if (line == null || line.contains("序号") || line.contains("终端小计") || line.contains("合计") || line.contains("您通过")) {
                        System.out.println("忽略：" + line);
                    } else {
                        String[] content = line.split("\\,");
                        writer.writeRecord(content);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (csvReader != null)
                    csvReader.close();
            }
        });

        writer.close();
    }

    private static List<String> getFiles(String path) {
        File f = new File(path);
        File fa[] = f.listFiles();

        List<String> list = new ArrayList<>();
        for (File fs : fa) {
            if (!fs.isDirectory()) {
                //System.out.println(fs.getName());
                list.add(fs.getName());
            }
        }

        return list;
    }
}
