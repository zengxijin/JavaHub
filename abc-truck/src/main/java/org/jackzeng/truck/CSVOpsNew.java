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
 * @author zengxijin created on 2018/4/12
 */
public class CSVOpsNew {
    public static void main(String[] args) throws IOException {
        List<String> files = new ArrayList<>();
        //files.add("/Users/zengxijin/Desktop/Consumer_Complaints_TEST.csv");
        files.add("/Users/zengxijin/Desktop/work/beike/KnowledgeGraph/Consumer_Complaints_raw.csv");

        String outFile = "csvMerge.csv";

        CsvWriter writer = new CsvWriter(outFile,',', Charset.forName("UTF-8"));
        String[] headers = {"Date received","Product","Sub-product","Issue","Sub-issue",
                "Consumer complaint narrative","Company public response","Company","State",
                "ZIP code","Tags","Consumer consent provided?","Submitted via","Date sent to company",
                "Company response to consumer","Timely response?","Consumer disputed?","Complaint ID"};
        writer.writeRecord(headers);



        files.forEach(file -> {
            System.out.println(file);

            CsvReader csvReader = null;
            File fileHandle = null;
            InputStreamReader isr = null;
            try {
                // 创建CSV读对象
                fileHandle = new File(file);
                isr = new InputStreamReader(new FileInputStream(fileHandle),"UTF-8");
                csvReader = new CsvReader(isr);

                // 读表头
                csvReader.readHeaders();
                while (csvReader.readRecord()) {
                    int columns = csvReader.getColumnCount();

                    String[] content = new String[columns];
                    for (int i=0; i < columns; i++) {
                        String rawString = csvReader.get(i);
                        if (rawString != null) {
                            rawString = rawString.replace("\"", "");
                            rawString = rawString.replace("\'", "");
                            rawString = rawString.replace("$", "");
                            rawString = rawString.replace("{", "");
                            rawString = rawString.replace("}", "");
                            rawString = rawString.replace("&", "");
                        }
                        content[i] = rawString;
                    }

                    content[5] = "all the samle context";

                    writer.writeRecord(content);

                }

                //rm -rf /home/zengxijin/neo4j-community-3.3.4/import/Consumer_Complaints.csv & mv /home/zengxijin/csvMerge.csv /home/zengxijin/neo4j-community-3.3.4/import/Consumer_Complaints.csv

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (csvReader != null)
                    csvReader.close();
            }
        });

        writer.close();
    }
}
