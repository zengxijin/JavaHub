package org.jackzeng.truck;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zengxj
 * @create 2017/11/16
 */
public class CSVOps2 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\zengxj\\Desktop\\中行POS明细清单\\中街店\\data\\";

        List<String> files = getFiles(filePath);

        String outFile = "csvMerge" + System.currentTimeMillis() + ".csv";

        CsvWriter writer = new CsvWriter(outFile,',', Charset.forName("GBK"));
        String[] headers = {"终端号","批号","交易卡号","交易日期","交易时间","交易金额","手续费","结算金额","授权码","交易码","分期","卡别","参考号","原始文件名"};
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
                    System.out.println(line);
                    if (line == null || line.contains("序号") || line.contains("小计") || line.contains("合计") || line.contains("您通过")
                            || line.contains("终端号")) {
                        System.out.println("忽略：" + line);
                    } else {
                        String[] content = line.split(" ");
                        String[] contentNew = new String[14];
                        int j = 0;
                        for (int i=0; i < content.length; i++) {
                            if (!content[i].equals("")) {
                                contentNew[j] = content[i];
                                j++;
                            }
                        }

                        if (j == 13) {
                            contentNew[13] = file;
                            writer.writeRecord(contentNew);
                        }
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
