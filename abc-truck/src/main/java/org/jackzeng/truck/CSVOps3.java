package org.jackzeng.truck;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zengxj
 * @create 2017/11/16
 */
public class CSVOps3 {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\zengxj\\Desktop\\大连万达2018年POS明细\\大连POS对账单\\大连POS对账单\\data\\";

        List<String> files = getFiles(filePath);

        String outFile = "csvMerge" + System.currentTimeMillis() + ".csv";

        CsvWriter writer = new CsvWriter(outFile,',', Charset.forName("GBK"));
        String[] headers = {"终端号","发卡行","卡种","卡号-序列号","交易日期","交易时间",
                "交易类型","授权号","交易金额","小费","分期期数","银行手续费","DCC返还手续费","划账金额","凭证号","批次号","POS交易序号",
                "结算账号","订单号","柜台编号","系统参考号","原始文件名"};
        writer.writeRecord(headers);
        files.forEach(file -> {
            System.out.println(file);
            List<String[]> data = getRows(filePath + file, file);
            data.forEach(
                    d-> {
                        try {
                            writer.writeRecord(d);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        });

        writer.close();
    }

    public static List<String[]> getRows(String filePath, String fileName) {

        Sheet sheet = null;
        Row row = null;
        List<Map<String,String>> list = null;
        String cellData = null;
        Workbook wb = readExcel(filePath);

        List<String[]> allBuffer = new ArrayList<>();

        if(wb != null) {
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            for (int i = 1; i<rownum; i++) {
                row = sheet.getRow(i);
                int colnum = row.getPhysicalNumberOfCells();
                System.out.println("列:" + colnum);
                List<String> listBuffer = new ArrayList<>();
                if(row != null && colnum == 25) {
                    for (int j=0;j<colnum;j++){
                        Cell cell = row.getCell(j);
                        if (cell != null) {
                            cellData = row.getCell(j).getStringCellValue();
                            listBuffer.add(cellData);
                        }
                    }

                    StringBuilder builder = new StringBuilder();

                    listBuffer.forEach(
                            e -> {
                                if (!e.equals("")) {
                                    builder.append(e + ",");
                                }
                            }
                    );
                    String data = builder.toString() + fileName;
                    System.out.println(data);
                    if (data.contains("终端号")) {
                        System.out.println("忽略：" + data);
                    } else {
                        String[] all = data.split("\\,");
                        allBuffer.add(all);
                    }
                }
            }
        }

        return allBuffer;
    }


    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                //return wb = new XSSFWorkbook(is);
                return null;
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
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
