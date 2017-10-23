package com.jack.excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zengxijin created on 2017/10/23
 */
public class ExcelMerge {
    public static void main(String[] args) throws IOException, BiffException, WriteException {

        merge(getFiles());

    }

    private static List<String> getFiles() {
        File f = new File("/Users/zengxijin/e");
        File fa[] = f.listFiles();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < fa.length; i++) {
            File fs = fa[i];
            if (!fs.isDirectory()) {
                //System.out.println(fs.getName());
                list.add(fs.getName());
            }
        }

        return list;
    }

    private static void merge(List<String> files) throws IOException, BiffException, WriteException {

        // 打开文件
        WritableWorkbook book = Workbook.createWorkbook(new File(
                "out.xls"));
        // 生成名为“sheet1”的工作表，参数0表示这是第一页
        WritableSheet sheetOut = book.createSheet("sheet1", 0);

        int rowCount = 0;
        int sheetCount = 1;

        for (String fileName : files) {
            //String fileName = "/Users/zengxijin/e/MB巴南万达店1709POS-09.xls";
            File file = new File("/Users/zengxijin/e/" + fileName); //根据文件名创建一个文件对象
            Workbook wb = Workbook.getWorkbook(file); //从文件流中取得Excel工作区对象
            Sheet sheet = wb.getSheet(0); //从工作区中取得页，取得这个对象的时候既可以用名称来获得，也可以用序号。


            for(int i=0; i < sheet.getRows(); i++){
                //抛弃前4行数据
                if (i < 4) continue;

                //超过最大行数
                if (rowCount > 60000) {
                    sheetOut = book.createSheet("sheet" + (++sheetCount), sheetCount);
                    sheetCount++;
                    //重置行统计
                    rowCount = 0;
                }

                String str = "";
                for(int j=0; j < sheet.getColumns(); j++){
                    Cell cell = sheet.getCell(j,i);

                    String content = cell.getContents();
                    if (content.startsWith("总笔数") || content.contains("交易金额") || content.contains("结算金额")) {
                        break;
                        //无效，跳过
                    } else {
                        Label label = new Label(j, rowCount, content);
                        sheetOut.addCell(label);
                        str = str + content + "\t";
                    }

                }

                rowCount++;
                System.out.println(i+ " " + str);
            }

            wb.close();



            // 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string
//            Label label = new Label(0, 0, "string");
//            // 将定义好的单元格添加到工作表中
//            sheetOut.addCell(label);
//            // 生成一个保存数字的单元格,单元格位置是第二列，第一行，单元格的内容为1234.5
//            Number number = new Number(1, 0, 1234.5);
//            sheetOut.addCell(number);
//            // 生成一个保存日期的单元格，单元格位置是第三列，第一行，单元格的内容为当前日期
//            DateTime dtime = new DateTime(2, 0, new Date());
//            sheetOut.addCell(dtime);
//            // 写入数据并关闭文件

        }

        book.write();
        book.close();


    }


}
